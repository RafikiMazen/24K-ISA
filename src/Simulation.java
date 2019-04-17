
public class Simulation {

//	private HashMap <String,Integer> registers;
	private FetchStage fetch;
	private DecodeStage decode;
	private ExecuteStage exexute;
	private MemoryWrite memoryW;
	private WriteBack WB;
	private PipelinneRegister IF_ID;
	private PipeLinneRegister ID_EX;
	private PipeLinneRegister EX_MEM;
	private PipeLinneRegister MEM_WB;
	
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
