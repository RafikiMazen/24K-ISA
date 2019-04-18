package Stages;

import Components.PipelineRegister;
import Components.RegisterFile;
import main.Memory;

public class MemoryAccess implements Runnable{
	PipelineRegister prev;
	PipelineRegister next;
	Memory datamemory;
	RegisterFile regfile;
	Fetch fetch;

	public MemoryAccess(PipelineRegister prev, PipelineRegister next, Memory datamemory,Fetch fetch,RegisterFile regfile) {
		super();
		this.regfile=regfile;
		this.fetch=fetch;
		this.prev = prev;
		this.next = next;
		this.datamemory = datamemory;
	}
	
	


	@Override
	public String toString() {
		return "MemoryAccess [prev=" + prev + ", next=" + next + ", datamemory=" + datamemory + "]";
	}


	public void run() {
		if(Integer.parseInt(prev.readRegister("Zero"))==0) {
			int pc = Integer.parseInt(regfile.getFromRegs("PC"),2);
			pc+=Integer.parseInt(prev.readRegister("SHAMT"),2)/4;
			fetch.setInstruction(pc);
		}
		
	}
}
