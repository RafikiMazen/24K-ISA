package Stages;

import Components.ALU;
import Components.PipelineRegister;
import Components.RegisterFile;

public class Execute implements Runnable {
	ALU ALUExecuted;
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
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
	
	public Execute(RegisterFile reg, PipelineRegister next, PipelineRegister prev) {
		regFile = reg;
		this.prev = prev;
		this.next = next;
		jump= false;
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
	}
	public void run() {
		settersFromPrev();
		int tempA=0;
		int tempB=0;
		
		switch(Opcode) {
		case "00010":
			tempA = Integer.parseInt(R1Value,2)+Integer.parseInt(R2Value,2);
			R1Value= Integer.toBinaryString(tempA);
			break;
			
		case "00011":
			tempA = Integer.parseInt(R1Value,2)-Integer.parseInt(R2Value,2);
			R1Value= Integer.toBinaryString(tempA);
			break;
		case "00100":
			R1Value=immediate;
			break;
		}
		
		if (Opcode.equals("10001"))

		{
			jump = true;
			regFile.setRegs("PC", prev.getR1Value());

		}

		if (Opcode.equals("10010")) {
			next.setR1Address(regFile.getFromRegsbyBits(instruction.substring(5, 10)));
			next.setR2Address(regFile.getFromRegsbyBits(instruction.substring(10, 15)));
			next.setOpcode(Opcode);
			jump = true;
			next.setR1Value(regFile.getFromRegs("PC"));
			regFile.setRegs("PC", prev.getR1Value());
//			regFile.setRegs("AR", prev.readRegister("R2") );
			next.setRegister("R2", prev.readRegister("R2"));

		}
		if (Opcode.equals("10011")) {
			regFile.setRegs("PC", prev.readRegister("Immediate"));

			jump = true;
		}
		if (Opcode.equals("10100")) {
			jump = true;

		}

		if (Opcode.equals("10101")) {
			jump = true;
		}

		ALUExecuted = new ALU(regFile, next, prev);
		ALUExecuted.operation();
		next.setRegister("R1", ALUExecuted.getR1());
		next.setJump(jump);
		next.setMemoryRead(ALUExecuted.isMemoryRead());
		next.setMemoryWrite(ALUExecuted.isMemoryWrite());
		next.setRegister("Opcode", Opcode);
//		setterToNext();

	}
}
