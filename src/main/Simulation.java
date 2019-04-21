package main;
import java.util.ArrayList;
import java.util.Queue;

//import com.sun.org.apache.bcel.internal.generic.Instruction;

//import Components.PipelineRegister;
//import Components.Register;
import Components.RegisterFile;
import Stages.Decode;
import Stages.Execute;
import Stages.Fetch;
import Stages.MemoryAccess;
import Stages.WriteBack;

public class Simulation {
	private Memory dataMemory;
//	private Memory instructionMemory;
	private RegisterFile registers;
//	private Fetch fetch;
//	private Decode decode;
//	private Execute execute;
//	private MemoryAccess memoryA;
//	private WriteBack WB;
//	private PipelineRegister IF_ID;
//	private PipelineRegister ID_EX;
//	private PipelineRegister EX_MEM;
//	private PipelineRegister MEM_WB;
	private Queue<Fetch> decodeQueue;
	private Queue<Decode> executeQueue;
	private Queue<Execute> memQueue;
	private Queue<MemoryAccess> writeBackQueue;
	ArrayList<String> instructions;

	public Simulation() {
//		IF_ID = new PipelineRegister(1);
//		ID_EX = new PipelineRegister(2);
//		EX_MEM = new PipelineRegister(3);
//		MEM_WB = new PipelineRegister(4);
		dataMemory = new Memory("data",400);
		instructions=new ArrayList<String>();
//		instructionMemory = new Memory("instruction",15);
		
		registers = new RegisterFile();
//		fetch = new Fetch(instructionMemory,IF_ID);
//		decode= new Decode(registers,ID_EX,IF_ID);
//		memoryA= new MemoryAccess(EX_MEM, MEM_WB, dataMemory,fetch,registers);

	}
	public void go() {
//		TODO: Check that threads are all done, and actually create the threads :'D
		
		while(true) {
			Fetch tempFetch=null;
			Decode tempDecode=null;
			Execute tempExecute=null;
			MemoryAccess tempMem=null;
			int didntEnter=0;
			if(registers.getPC()<instructions.size()) {
			tempFetch=new Fetch(instructions,registers);
			decodeQueue.add(tempFetch);
			}
			else {
				didntEnter++;
			}
			
			
			if(!decodeQueue.isEmpty())
				{tempDecode=new Decode(registers,decodeQueue.poll());
				executeQueue.add(tempDecode);
				}
			else {
				didntEnter++;
			}
			
			if(!executeQueue.isEmpty())
			{
				tempExecute=new Execute(registers, executeQueue.poll());
				memQueue.add(tempExecute);
			}
			else {
				didntEnter++;
			}
			
			if(!memQueue.isEmpty())
			{
				tempMem=new MemoryAccess(memQueue.poll(), dataMemory);
				writeBackQueue.add(tempMem);
			}
			else {
				didntEnter++;
			}
			if(!writeBackQueue.isEmpty())
			{
				new WriteBack(registers, writeBackQueue.poll());
			}
			else {
				didntEnter++;
			}
			
			
			
			if(tempFetch!=null) {
				decodeQueue.add(tempFetch);
			}
			if(tempDecode!=null) {
				executeQueue.add(tempDecode);
			}
			if(tempExecute!=null) {
				memQueue.add(tempExecute);
			}
			if(tempMem!=null) {
				writeBackQueue.add(tempMem);
			}
			
			
			if(didntEnter>=5) {
				System.out.println("program finished");
				break;
			}
		}	
	}

	public static void main(String[] args) {
		System.out.println("This is 24K wa elhag 3abdo Welcoming you to the Simulation");
	}


}
