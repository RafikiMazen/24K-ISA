package main;
import Components.PipelineRegister;
import Components.RegisterFile;
import Stages.Decode;
import Stages.Execute;
import Stages.Fetch;
import Stages.MemoryAccess;
import Stages.WriteBack;

public class Simulation {
	private Memory dataMemory;
	private Memory instructionMemory;
	private RegisterFile registers;
	private Fetch fetch;
	private Decode decode;
	private Execute execute;
	private MemoryAccess memoryW;
	private WriteBack WB;
	private PipelineRegister IF_ID;
	private PipelineRegister ID_EX;
	private PipelineRegister EX_MEM;
	private PipelineRegister MEM_WB;

	public Simulation() {
		IF_ID = new PipelineRegister(1);
		ID_EX = new PipelineRegister(2);
		EX_MEM = new PipelineRegister(3);
		MEM_WB = new PipelineRegister(4);
		dataMemory = new Memory("data");
		instructionMemory = new Memory("instruction");
		registers = new RegisterFile();
		fetch = new Fetch(instructionMemory);
		decode= new Decode(registers);

	}
	void run() {
		while(fetch.hasMoreInstruction()) {
			fetch.run();
			decode.run();
			execute.run();
			memoryW.run();
			WB.run();		
			IF_ID.updateValues();
			ID_EX.updateValues();
			EX_MEM.updateValues();
			MEM_WB.updateValues();
		}	
	}

	public static void main(String[] args) {
		System.out.println("This is 24K wa elhag 3abdo Welcoming you to the Simulation");
	}


}
