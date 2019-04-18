package Stages;

import Components.ALU;
import Components.PipelineRegister;
import Components.RegisterFile;

public class Execute implements Runnable {
	ALU ALUExecuted;
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	public Execute(RegisterFile reg, PipelineRegister next, PipelineRegister prev)
	{regFile = reg;
	this.prev = prev;
	this.next = next;
	}
	public void run() {
		ALUExecuted=new ALU(regFile,next,prev);
		
	}
}
