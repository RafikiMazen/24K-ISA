package Stages;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import Components.PipelineRegister;
import Components.RegisterFile;
import main.Memory;

public class MemoryAccess{
	public PipelineRegister getNext() {
		return next;
	}
	public void setNext(PipelineRegister next) {
		this.next = next;
	}

	PipelineRegister prev;
	PipelineRegister next;
	Memory dataMemory;
	RegisterFile regfile;
//	Fetch fetch;
	String Opcode;
	String R1Value;
	String R2Value;
	String R3Value;
	String R1Address;
	String R2Address;
	String R3Address;
	String immediate;
	String writeAddress;
	String writeValue;
	boolean jump;
	boolean writeMem;
	boolean readMem;
	boolean writeReg;
	String jumpValue;
	
	
public void settersFromPrev() {
		
		Opcode=prev.getOpcode();
		R1Value=prev.getR1Value();
		R2Value=prev.getR2Value();
		R3Value=prev.getR3Value();
		R1Address=prev.getR1Address();
		R2Address=prev.getR2Address();
		R3Address=prev.getR3Address();
		immediate=prev.getImmediate();
		writeAddress=prev.getWriteAddress();
		writeValue=prev.getWriteValue();
		jump=prev.isJump();
		writeMem=prev.isWriteMem();
		readMem=prev.isReadMem();
		writeReg=prev.isWriteReg();
		jumpValue=prev.getJumpValue();
	}
	public void setterToNext()
	{

		next.setOpcode(Opcode);
		next.setR1Value(R1Value);
		next.setR2Value(R2Value);
		next.setR3Value(R3Value);
		next.setR1Address(R1Address);
		next.setR2Address(R2Address);
		next.setR3Address(R3Address);
		next.setImmediate(immediate);
		next.setWriteAddress(writeAddress);
		next.setWriteValue(writeValue);
		next.setJump(jump);
		next.setWriteMem(writeMem);
		next.setReadMem(readMem);
		next.setReadMem(readMem);
		next.setJumpValue(jumpValue);
	}

	public MemoryAccess(Execute excute, Memory datamemory) {
		super();
//		this.regfile=regfile;
//		this.fetch=fetch;
		this.prev = excute.next;
		this.next = new PipelineRegister(4);
		this.dataMemory = datamemory;
		System.out.println();
		settersFromPrev();
//		System.out.println(writeValue+ " hobba");
		if(readMem) {
			writeValue=dataMemory.readFromIndex(Integer.parseInt(prev.getR2Value(),2));
			writeAddress=prev.getR1Address();
		}
		
		if(writeMem) {
			dataMemory.setIntoMemory(Integer.parseInt(prev.getR2Value(),2), R1Value);
		}
		
//		if(jump) {
//			
//			regfile.setPC(Integer.parseInt(jumpValue, 2));
//		}
		if(Opcode.equals("01111"))
			{
				dataMemory.snapFinger();
			}
		setterToNext();
		System.out.println("Memory Access");
		System.out.println("****************");
		System.out.println("Writing value "+writeValue);
		System.out.println("writing Address " + writeAddress);
		System.out.println("****************");
		System.out.println();
			}
	
	@Override
	public String toString() {
		return "MemoryAccess [prev=" + prev + ", next=" + next + ", datamemory=" + dataMemory + "]";
	}


//	public void run() {
//		settersFromPrev();
////		//if the instruction is branch change the pc in fetching stage
////		if(Integer.parseInt(prev.readRegister("BRANCH"))==0) {
////			int pc = Integer.parseInt(regfile.getFromRegs("PC"),2);
////			pc+=Integer.parseInt(prev.readRegister("SHAMT"),2)/4;
////			fetch.setInstruction(pc);
////		}
////		if(Integer.parseInt(prev.readRegister("WriteRegister"))==1) {
//////			regfile.getRd()
////			
////		}
//		
//		if(readMem) {
//			writeValue=dataMemory.readFromIndex(Integer.parseInt(prev.getR2Value(),2));
//		}
//		
//		if(writeMem) {
//			dataMemory.setIntoMemory(Integer.parseInt(prev.getR2Value(),2), R1Value);
//		}
//		
//		if(jump) {
//			
//			regfile.setRegs("PC", R1Value);
//		}
//		
//		
//	}
}
