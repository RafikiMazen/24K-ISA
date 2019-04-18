package Stages;

import Components.PipelineRegister;
import main.Memory;

public class Fetch implements Runnable {
	private Memory instructionMemory;
	private PipelineRegister prev;
	int instructionAddress;
	String instruction;
	
	public Fetch(Memory memory, PipelineRegister prev) {
		this.prev=prev;
		instructionMemory= memory;
		instructionAddress=-4;
		instruction="";
	}
	
	public void setInstruction(int value) {
		
	}
	
	public void run () {
		instructionAddress+=4;
		instruction=instructionMemory.readFromIndex(instructionAddress);
		prev.updateValues(this);
		
	}

	public int getInstructionAddress() {
		return instructionAddress;
	}

	public String getInstruction() {
		return instruction;
	}
//TODO
	public boolean hasMoreInstruction() {
		if(instructionAddress/4>=instructionMemory.getInstructions() )
			return true;
		else
			return false;
	}

}

