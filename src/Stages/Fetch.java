package Stages;

import java.util.ArrayList;

import Components.PipelineRegister;
import Components.RegisterFile;
//import main.Memory;

public class Fetch{
	//	private Memory instructionMemory;

	ArrayList<String> instructions;
	public PipelineRegister getNext() {
		return next;
	}
	private PipelineRegister next;
	int instructionAddress;
	String instruction;String Opcode;
	String R1Value;
	String R2Value;
	String R3Value;
	String R1Address;
	String R2Address;
	String R3Address;
	String immediate;
	String writeAddress;
	String writeValue;
	boolean jump;
	boolean writeMem;
	boolean readMem;
	boolean writeReg;
	boolean equal;
	String jumpValue;

	public Fetch(ArrayList<String> instructions, RegisterFile regFile) {
		this.next=new PipelineRegister(1);
		this.instructions=instructions ;
		instructionAddress =regFile.getPC();
		regFile.setPC(instructionAddress+1);
		instruction=instructions.get(instructionAddress);
		System.out.println(instruction);
		next.setPC(Integer.toBinaryString(instructionAddress));
		next.setIR(instruction);
		String Opcode=instruction.substring(0, 5);


		switch(Opcode) {



		case ("10001"):
			R1Address = instruction.substring(5, 10);
		R1Value = regFile.getFromRegsbyBits(R1Address);
		jumpValue = R1Value;
		jump = true;
		break;
		case ("10010"):
			R1Address = instruction.substring(5, 10);
		R1Value = regFile.getFromRegsbyBits(R1Address);
		R2Address = instruction.substring(10, 15);
		R2Value = regFile.getFromRegsbyBits(R2Address);
		writeAddress = R2Address;
		writeValue = R2Value;
		jumpValue = R1Value;
		jump = true;
		writeReg = true;
		break;
		case ("10011"):

			jumpValue = instruction.substring(5);
		jump = true;
		break;
		case ("10100"):
		case ("10101"):
			R1Address = instruction.substring(5, 10);
		R1Value = regFile.getFromRegsbyBits(R1Address);
		R2Address = instruction.substring(10, 15);
		R2Value = regFile.getFromRegsbyBits(R2Address);
		if(Integer.parseInt(R1Value, 2)== Integer.parseInt(R2Value, 2)) {
			jumpValue = instruction.substring(15);
			jump = true;
		}
		break;
		default:break;
		}

		if(jump) {

			regFile.setPC(Integer.parseInt(jumpValue, 2));
		}


		setterToNext();
		System.out.println("Fetch");
		System.out.println("****************");
		System.out.println("PC "+instructionAddress);
		System.out.println("instruction "+instruction);
		System.out.println("****************");
		System.out.println();
		//		next.updateValues(this);
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

	public int getInstructionAddress() {
		return instructionAddress;
	}

	public String getInstruction() {
		return instruction;
	}
}


