package Stages;

import Components.PipelineRegister;
import Components.RegisterFile;
import main.Memory;

public class MemoryAccess implements Runnable{
	PipelineRegister prev;
	PipelineRegister next;
	Memory dataMemory;
	RegisterFile regfile;
	Fetch fetch;

	public MemoryAccess(PipelineRegister prev, PipelineRegister next, Memory datamemory,Fetch fetch,RegisterFile regfile) {
		super();
		this.regfile=regfile;
		this.fetch=fetch;
		this.prev = prev;
		this.next = next;
		this.dataMemory = datamemory;
	}
	
	@Override
	public String toString() {
		return "MemoryAccess [prev=" + prev + ", next=" + next + ", datamemory=" + dataMemory + "]";
	}


	public void run() {
//		//if the instruction is branch change the pc in fetching stage
//		if(Integer.parseInt(prev.readRegister("BRANCH"))==0) {
//			int pc = Integer.parseInt(regfile.getFromRegs("PC"),2);
//			pc+=Integer.parseInt(prev.readRegister("SHAMT"),2)/4;
//			fetch.setInstruction(pc);
//		}
//		if(Integer.parseInt(prev.readRegister("WriteRegister"))==1) {
////			regfile.getRd()
//			
//		}
		
		
		
		
	}
}
