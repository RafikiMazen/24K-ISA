package Stages;

import Components.PipelineRegister;
import Components.RegisterFile;

public class Decode {
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	String instruction;
	String Opcode;
	String R1Value;
	String R2Value;
	String R3Value;
	String R1Address;
	String R2Address;
	String R3Address;
	String immediate;
	String writeAddress;
	String writeValue;
	String jumpValue;
	public String getJumpValue() {
		return jumpValue;
	}


	public void setJumpValue(String jumpValue) {
		this.jumpValue = jumpValue;
	}


	boolean jump;
	boolean writeMem;
	boolean readMem;
	boolean writeReg;

	int temp;

	public Decode(RegisterFile reg, Fetch fetch) {
		regFile = reg;
		this.prev = fetch.getNext();
		this.next = new PipelineRegister(2);
		instruction = prev.getIR();
		Opcode = instruction.substring(0, 5);
		next.setOpcode(Opcode);
		switch (Opcode) {
		case ("00000"):
			readMem = true;
			R1Address = instruction.substring(5, 10);
			R1Value = "";
			R2Address = instruction.substring(10, 15);
			writeAddress = R1Address;
			R2Value = regFile.getFromRegsbyBits(R2Address);
			break;
		case ("00001"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);

			writeValue = R1Value;
			writeMem = true;
			break;
		case ("00010"):
		case ("00011"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);
			R3Address = instruction.substring(15, 20);
//			R3Value = regFile.getFromRegsbyBits(R3Address);
			writeAddress = R3Address;
//			writeValue = R3Value;
			writeReg = true;
			break;
		case ("00100"):
		case ("00101"):
		case ("00110"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			immediate = instruction.substring(10);
			writeAddress = R1Address;
			writeValue = immediate;
			writeReg = true;
			break;
		case ("00111"):
		case ("01000"):
		case ("01001"):
		case ("01010"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);
			R3Address = instruction.substring(15, 20);
			R3Value = regFile.getFromRegsbyBits(R3Address);
			writeAddress = R3Address;
			writeValue = R3Value;
			writeReg = true;
			break;
		case ("01100"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);
			// TODO
			writeAddress = R2Address;
			writeValue = R2Value;
			writeReg = true;
			break;
		case ("01101"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);
			R3Address = instruction.substring(15, 20);
			R3Value = regFile.getFromRegsbyBits(R3Address);
			writeAddress = R3Address;
			writeValue = R3Value;
			writeReg = true;
			break;
		case ("01110"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);
			writeAddress = R2Address;
			writeValue = R2Value;
			writeReg=true;
			break;
		case ("10000"):
			R1Address = instruction.substring(5, 10);
			R1Value = regFile.getFromRegsbyBits(R1Address);
			R2Address = instruction.substring(10, 15);
			R2Value = regFile.getFromRegsbyBits(R2Address);
			R3Address = instruction.substring(15, 20);
			R3Value = regFile.getFromRegsbyBits(R3Address);
			writeAddress = R3Address;
			writeValue = R3Value;
			writeReg = true;
//		case ("10001"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			jumpValue = R1Value;
//			jump = true;
//			break;
//		case ("10010"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			writeAddress = R2Address;
//			writeValue = R2Value;
//			jumpValue = R1Value;
//			jump = true;
//			writeReg = true;
//			break;
//		case ("10011"):
//
//			jumpValue = instruction.substring(5);
//			jump = true;
//			break;
//		case ("10100"):
//		case ("10101"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			jumpValue = instruction.substring(15);
//			jump = true;
//			break;
		default:
			System.out.println("Error in decoding!!!!!!!!!");
		}
		setterToNext();
		System.out.println("DECODE");
		System.out.println("***********");
		System.out.println("Opcode" + Opcode);
		System.out.println("writing Address " + writeAddress);
		System.out.println("***********");
		System.out.println();
	}
	
	
    public void setterToNext() {

        next.setOpcode(Opcode);
        next.setR1Value(R1Value);
        next.setR2Value(R2Value);
        next.setR3Value(R3Value);
        next.setR1Address(R1Address);
        next.setR2Address(R2Address);
        next.setR3Address(R3Address);
        next.setImmediate(immediate);
        next.setWriteAddress(writeAddress);
        next.setWriteValue(writeValue);
        next.setJump(jump);
        next.setWriteMem(writeMem);
        next.setReadMem(readMem);
        next.setReadMem(readMem);
        next.setJumpValue(jumpValue);
    
}
}

//	public void run() {
//		regFile.setRegs("PC", prev.getPC());
//		String inst = prev.getIR();
//		regFile.setRegs("IR", inst);
//		DecodeNow();
//	}
//
//	public void DecodeNow() {
//		instruction = prev.getIR();
//		Opcode = instruction.substring(0, 5);
//		next.setOpcode(Opcode);
//		switch (Opcode) {
//		case ("00000"):
//			readMem = true;
//			R1Address = instruction.substring(5, 10);
//			R1Value = "";
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			break;
//		case ("00001"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			writeAddress = R2Address;
//			writeValue = R2Value;
//			writeMem = true;
//			break;
//		case ("00010"):
//		case ("00011"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			R3Address = instruction.substring(15, 20);
//			R3Value = regFile.getFromRegsbyBits(R3Address);
//			writeAddress = R3Address;
//			writeValue = R3Value;
//			writeReg = true;
//			break;
//		case ("00100"):
//		case ("00101"):
//		case ("00110"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			writeAddress = R1Address;
//			writeValue = R1Value;
//			writeReg = true;
//			break;
//		case ("00111"):
//		case ("01000"):
//		case ("01001"):
//		case ("01010"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			R3Address = instruction.substring(15, 20);
//			R3Value = regFile.getFromRegsbyBits(R3Address);
//			writeAddress = R3Address;
//			writeValue = R3Value;
//			writeReg = true;
//			break;
//		case ("01100"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			writeAddress = R2Address;
//			writeValue = R2Value;
//			writeReg = true;
//			break;
//		case ("01101"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			R3Address = instruction.substring(15, 20);
//			R3Value = regFile.getFromRegsbyBits(R3Address);
//			writeAddress = R3Address;
//			writeValue = R3Value;
//			writeReg = true;
//			break;
//		case ("01110"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			break;
//		case ("10000"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			R3Address = instruction.substring(15, 20);
//			R3Value = regFile.getFromRegsbyBits(R3Address);
//			writeAddress = R3Address;
//			writeValue = R3Value;
//			writeReg = true;
//		case ("10001"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			jump = true;
//			break;
//		case ("10010"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			writeAddress = R2Address;
//			writeValue = R2Value;
//			jump = true;
//			writeReg = true;
//			break;
//		case ("10011"):
//			immediate = instruction.substring(5);
//			jump = true;
//			break;
//		case ("10100"):
//		case ("10101"):
//			R1Address = instruction.substring(5, 10);
//			R1Value = regFile.getFromRegsbyBits(R1Address);
//			R2Address = instruction.substring(10, 15);
//			R2Value = regFile.getFromRegsbyBits(R2Address);
//			immediate = instruction.substring(10);
//			jump = true;
//			break;
//		default:
//			System.out.println("Error in decoding!!!!!!!!!");
//		}
//	}
//}