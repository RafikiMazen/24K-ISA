package Stages;
import Components.PipelineRegister;
import Components.RegisterFile;

public class Decode implements Runnable {
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	String instruction;
	String Opcode;
	String rs;
	String rt;
	String rd;
	String immediate;
	int temp;

	public Decode(RegisterFile reg, PipelineRegister next, PipelineRegister prev) {
		regFile = reg;
		this.prev = prev;
		this.next = next;
	}

	public void run() {
		regFile.setRegs("PC", prev.readRegister("PC"));
		String inst = prev.readRegister("IR");
		regFile.setRegs("IR", inst);
		DecodeNow();
	}

	public void DecodeNow() {
		instruction= prev.readRegister("IR");
		Opcode = instruction.substring(0, 5);
		switch (Opcode) {
		case ("00000"):
		case ("00001"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("00010"):
		case ("00011"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("00100"):
		case ("00101"):
		case ("00110"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("Immediate", regFile.getFromRegsbyBits(instruction.substring(10)));
			next.setRegister("Opcode",Opcode);
		case ("00111"):
		case ("01000"):
		case ("01001"):
		case ("01010"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("01100"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("01101"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("01110"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10000"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10001"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10010"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10011"):
			next.setRegister("rsd", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10100"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10101"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15)));
			next.setRegister("Opcode",Opcode);
			break;
		}
	}
}