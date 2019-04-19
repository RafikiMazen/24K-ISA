package Components;

import java.util.HashMap;
import java.util.Map.Entry;

import Stages.Fetch;

public class PipelineRegister {
	int type ;
//	HashMap<String,String> registers;
	boolean flag;
	boolean jump;
	boolean writeMem;
	boolean readMem;
	boolean writeReg;

	String PC;
	String IR;
	String R1Value;
	String R1Address;
	String R2Value;
	String R2Address;
	String R3Value;
	String R3Address;
	String Opcode;
	String Immediate;
	String writeAddress;
	String writeValue;
	
	public boolean isWriteReg() {
		return writeReg;
	}
	
	
	public void setWriteReg(boolean writeReg) {
		this.writeReg = writeReg;
	}
	
	

	

	public boolean isWriteMem() {
		return writeMem;
	}


	public void setWriteMem(boolean writeMem) {
		this.writeMem = writeMem;
	}


	public boolean isReadMem() {
		return readMem;
	}


	public void setReadMem(boolean readMem) {
		this.readMem = readMem;
	}


	public String getWriteAddress() {
		return writeAddress;
	}


	public void setWriteAddress(String writeAddress) {
		this.writeAddress = writeAddress;
	}


	public String getWriteValue() {
		return writeValue;
	}


	public void setWriteValue(String writeValue) {
		this.writeValue = writeValue;
	}


	public String getImmediate() {
		return Immediate;
	}


	public void setImmediate(String immediate) {
		Immediate = immediate;
	}


	public String getR3Value() {
		return R3Value;
	}


	public void setR3Value(String r3Value) {
		R3Value = r3Value;
	}


	public String getR3Address() {
		return R3Address;
	}


	public void setR3Address(String r3Address) {
		R3Address = r3Address;
	}


	public String getOpcode() {
		return Opcode;
	}


	public void setOpcode(String opcode) {
		Opcode = opcode;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public String getPC() {
		return PC;
	}


	public void setPC(String pC) {
		PC = pC;
	}


	public String getIR() {
		return IR;
	}


	public void setIR(String iR) {
		IR = iR;
	}


	public String getR1Value() {
		return R1Value;
	}


	public void setR1Value(String r1Value) {
		R1Value = r1Value;
	}


	public String getR1Address() {
		return R1Address;
	}


	public void setR1Address(String r1Address) {
		R1Address = r1Address;
	}


	public String getR2Value() {
		return R2Value;
	}


	public void setR2Value(String r2Value) {
		R2Value = r2Value;
	}


	public String getR2Address() {
		return R2Address;
	}


	public void setR2Address(String r2Address) {
		R2Address = r2Address;
	}


	public boolean isJump() {
		return jump;
	}


	public void setJump(boolean jump) {
		this.jump = jump;
	}

    public boolean isMemoryRead() {
		return memoryRead;
	}


	public void setMemoryRead(boolean memoryRead) {
		this.memoryRead = memoryRead;
	}


	public boolean isMemoryWrite() {
		return memoryWrite;
	}


	public void setMemoryWrite(boolean memoryWrite) {
		this.memoryWrite = memoryWrite;
	}

	boolean memoryRead;
    boolean memoryWrite;
	public PipelineRegister(int type) {
		if(type==1) {
//			registers.put("PC", "");
//			registers.put("IR", "");
		}
		if(type==2) {
			//			setup registers for first step
		}
		if(type==3) {
			//			setup registers for first step
		}
		if(type==4) {
			//			setup registers for first step
		}

	}


//	public void clear() {
//		registers.clear();
//		flag=false;
//	}
//	public void setRegister(String reg,String value) {
//		registers.replace(reg, value);
//	}

	public void updateValues(Fetch fetch){
		flag=true;
		if(type==1) {
			PC=Integer.toBinaryString(fetch.getInstructionAddress());
			IR=fetch.getInstruction();
		}
		if(type==2) {

		}
	}

//	public String readRegister(String reg) {
//		String key;
//		for(Entry<String, String> rec : registers.entrySet()) {
//			if(rec.getKey()==reg) {
//				return rec.getValue();
//			}
//		}
//		return null;
//	}



}
