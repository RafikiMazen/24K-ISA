package Stages;

import Components.PipelineRegister;
import Components.RegisterFile;
import main.Memory;

public class WriteBack {
	PipelineRegister prev;
//	PipelineRegister next;
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
	
	public WriteBack(RegisterFile regFile, MemoryAccess memAccess) {
		prev=memAccess.getNext();
		this.regfile=regFile;
		settersFromPrev();
		if(!(writeAddress.equals("")||writeAddress==null)) {
			regFile.setRegsbyBits(writeAddress, writeValue);
		}
	}
	
	
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
		writeValue=prev.getWriteAddress();
		jump=prev.isJump();
		writeMem=prev.isWriteMem();
		readMem=prev.isReadMem();
		writeReg=prev.isWriteReg();
		jumpValue=prev.getJumpValue();
	}
	
}

