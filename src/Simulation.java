import Components.PipelineRegister;
import Stages.Decode;
import Stages.Execute;
import Stages.Fetch;
import Stages.Memory;
import Stages.WriteBack;

public class Simulation {

	private Fetch fetch;
	private Decode decode;
	private Execute exexute;
	private Memory memoryW;
	private WriteBack WB;
	private PipelineRegister IF_ID;
	private PipelineRegister ID_EX;
	private PipelineRegister EX_MEM;
	private PipelineRegister MEM_WB;

	public Simulation() {
		//initiate variables
	}
	void run() {
		while(hasMoreInstruction()) {
			fetch.run();
			decode.run();
			execute.run();
			memoryW.run();
			WB.run();			
		}	
	}
	 
	
}
