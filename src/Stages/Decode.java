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
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
		next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
		next.setRegister("Opcode",Opcode);
		break;
			
			
		case ("00001"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("00010"):
			
		next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
		next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
		next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
		next.setRegister("Opcode",Opcode);
		break;
			
		case ("00011"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("00100"):
			
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
		next.setRegister("immediate", regFile.getFromRegsbyBits(instruction.substring(10)));
		next.setRegister("Opcode",Opcode);
		break;
			
		case ("00101"):
			

		next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
		next.setRegister("immediate", regFile.getFromRegsbyBits(instruction.substring(10)));
		next.setRegister("Opcode",Opcode);
		break;
			
			
		case ("00110"):
		next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));			next.setRegister("Immediate", regFile.getFromRegsbyBits(instruction.substring(10)));
		next.setRegister("immediate", regFile.getFromRegsbyBits(instruction.substring(10)));
		next.setRegister("Opcode",Opcode);
		break;
			
		case ("00111"):
	
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
			next.setRegister("Opcode",Opcode);
			break;
		
		case ("01000"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
		next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
		next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
		next.setRegister("Opcode",Opcode);
		break;
		case ("01001"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
		next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
		next.setRegister("R3", regFile.getFromRegsbyBits(instruction.substring(15, 20)));
		next.setRegister("Opcode",Opcode);
		break;
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
		case ("01111"):
			
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
			next.setRegister("dst", regFile.getFromRegsbyBits(instruction.substring(5)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10100"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("dst", regFile.getFromRegsbyBits(instruction.substring(15)));
			next.setRegister("Opcode",Opcode);
			break;
		case ("10101"):
			next.setRegister("R1", regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setRegister("R2", regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setRegister("dst", regFile.getFromRegsbyBits(instruction.substring(15)));
			next.setRegister("Opcode",Opcode);
			break;
		}
	}
}