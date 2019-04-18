package Stages;

import Components.PipelineRegister;
import main.Memory;

public class Fetch implements Runnable {
	private Memory instructionMemory;
	private PipelineRegister next;
	int instructionAddress;
	String instruction;
	
	public Fetch(Memory memory, PipelineRegister next) {
		this.next=next;
		instructionMemory= memory;
		instructionAddress = -4;
		instruction="";
	}
	
	public void setInstruction(int value) {
		instruction=""+value;
	}
	
	public void run () {
		instructionAddress+=4;
		instruction=instructionMemory.readFromIndex(instructionAddress);
		next.updateValues(this);
		
	}

	public int getInstructionAddress() {
		return instructionAddress;
	}

	public String getInstruction() {
		return instruction;
	}
//TODO missing logic in has moreInstructions
	public boolean hasMoreInstruction() {
		if(instructionAddress/4>=instructionMemory.getInstructions() )
			return true;
		else
			return false;
	}

}

