package Stages;

import Components.ALU;
import Components.PipelineRegister;
import Components.RegisterFile;

public class Execute implements Runnable {
	ALU ALUExecuted;
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	public Execute()
	{
		ALUExecuted=new ALU(regFile,next,prev);
	}
	public void run() {
		
	}
}
