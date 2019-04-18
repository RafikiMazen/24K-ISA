package Stages;

import Components.RegisterFile;
import main.Memory;

public class Fetch {
	private Memory instructionMemory;
	private RegisterFile regFile;
	int instruction;
	
	public Fetch(Memory memory) {
		instructionMemory= memory;
		instruction=0;
	}
	
	public void run () {
		if(instruction==0)
			instruction = regFile.getFromRegs("PC");
		regFile.setaRegs("IR", instruction);
		regFile.setaRegs("PC", instruction+4);
		//update pipeline
	}

	public int getInstruction() {
		return instruction;
	}

	public boolean hasMoreInstruction() {
		// TODO Auto-generated method stub
		return false;
	}

}

