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
	String instruction;
	
	public Fetch(ArrayList<String> instructions, RegisterFile regFile) {
		this.next=new PipelineRegister(1);
		this.instructions=instructions ;
		instructionAddress =regFile.getPC();
		regFile.setPC(instructionAddress+1);
		instruction=instructions.get(instructionAddress);
		next.updateValues(this);
	}
	

	

	public int getInstructionAddress() {
		return instructionAddress;
	}

	public String getInstruction() {
		return instruction;
	}
}


