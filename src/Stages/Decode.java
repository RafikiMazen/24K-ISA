package Stages;

import Components.PipelineRegister;
import Components.RegisterFile;

public class Decode implements Runnable {
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	
	public Decode(RegisterFile reg,  PipelineRegister next, PipelineRegister prev) {
		regFile=reg;
		this.prev=prev;
		this.next=next;
	}
	public void run() {
		regFile.setRegs("PC", prev.readRegister("PC"));
		String inst= prev.readRegister("IR");
		regFile.setRegs("IR",inst);
		
		
	}
}
