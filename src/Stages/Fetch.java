package Stages;

import main.Memory;

public class Fetch {
	private Memory instructionMemory;
	int instructionAddress;
	String instruction;
	
	public Fetch(Memory memory) {
		instructionMemory= memory;
		instructionAddress=-4;
		instruction="";
	}
	
	public void run () {
		instructionAddress+=4;
		instruction=instructionMemory.readFromIndex(instructionAddress);
		
		//update pipeline
	}

	public int getInstructionAddress() {
		return instructionAddress;
	}

	public String getInstruction() {
		return instruction;
	}

	public boolean hasMoreInstruction() {
		// TODO Auto-generated method stub
		return false;
	}

}

