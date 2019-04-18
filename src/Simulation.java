import Components.PipelineRegister;

public class Simulation {

	private FetchStage fetch;
	private DecodeStage decode;
	private ExecuteStage exexute;
	private MemoryWrite memoryW;
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
