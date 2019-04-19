package Components;

import java.util.Scanner;


public class ALU {
	//	String instruction;
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	String Opcode;
	private String R1;
	private String R2;
	private String R3;
public String getR1() {
		return R1;
	}
	public void setR1(String r1) {
		R1 = r1;
	}
	public String getR2() {
		return R2;
	}
	public void setR2(String r2) {
		R2 = r2;
	}
	public String getR3() {
		return R3;
	}
	public void setR3(String r3) {
		R3 = r3;
	}
	//	String Immediate;
	int temp;
	boolean MemoryWrite;
	boolean MemoryRead;
	boolean Jump;

	public ALU(RegisterFile reg, PipelineRegister next, PipelineRegister prev) {
		regFile = reg;
		this.prev = prev;
		this.next = next;
		MemoryRead=false;
		MemoryWrite=false;
		Jump=false;
		Opcode=prev.getOpcode();
	}
	public void operation() {
		//Memory
		if(Opcode.equals("00000"))
//						Memory.load(R1,R2);
			MemoryRead=true;
		if(Opcode.equals("00001"))
			//			Memory.store(R1,R2);
			MemoryWrite=true;
		//ARITHMATIC AND LOGICAL OPERATIONS
		//	if(Opcode.equals("00010"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=Integer.parseInt(R2.value,2)+Integer.parseInt(R3.value,2);
		//	if(Opcode.equals("00011"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R2.value-R3.value;
		//	if(Opcode.equals("00100"+sub+instruction.substring(11)))
		//		R1.value=i;
		//	if(Opcode.equals("00101"+sub+instruction.substring(11)))
		//		R1.value=R1.value>>i;
		//	if(Opcode.equals("00110"+sub+instruction.substring(11)))
		//		R1.value=R1.value<<i;
		//	if(Opcode.equals("00111"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R2.value*R3.value;
		//	if(Opcode.equals("01000"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R2.value/R3.value;
		//	if(Opcode.equals("01001"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R2.value&R3.value;
		//	if(Opcode.equals("01010"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R2.value|R3.value;
		//	if(Opcode.equals("01100"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=~R2.value;
		//	if(Opcode.equals("01101"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R2.value^R3.value;
		//	if(Opcode.equals("01110"+sub+instruction.substring(11,16)+"000000000000"))
		//		R1.value=R1.value.toBinaryString().substring(0,12);
		if(Opcode.equals("00010")) {
			temp=(Integer.parseInt(prev.readRegister("R2"),2))+(Integer.parseInt(prev.readRegister("R3"),2));
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1=Integer.toBinaryString(temp);
		}if(Opcode.equals("00011")) {
			temp=Integer.parseInt(prev.readRegister("R2"),2)-Integer.parseInt(prev.readRegister("R3"),2);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1=Integer.toBinaryString(temp);
		}
		if(Opcode.equals("00100"))
		{
			//		R1.value=Integer.toBinaryString(i);
			String Immediate =prev.readRegister("Immediate");
//			regFile.setRegs("R1", Immediate);
			R1=Immediate;
		}
		if(Opcode.equals("00101"))
		{	
			String Immediate =prev.readRegister("Immediate");
		//	regFile.setRegs("R1",(Integer.toBinaryString(Integer.parseInt(prev.readRegister("R1"),2)>>Integer.parseInt(Immediate))));

			R1=""+(Integer.parseInt(prev.readRegister("R1"),2)>>Integer.parseInt(Immediate,2));
		}
		if(Opcode.equals("00110")) {
			String Immediate =prev.readRegister("Immediate");
//			regFile.setRegs("R1",(Integer.toBinaryString(Integer.parseInt(prev.readRegister("R1"),2)<<Integer.parseInt(Immediate))));
			R1=(Integer.toBinaryString(Integer.parseInt(prev.readRegister("R1"),2)<<Integer.parseInt(Immediate)));
		}
		if(Opcode.equals("00111"))
		{	
			temp=(Integer.parseInt(prev.readRegister("R2"),2))*(Integer.parseInt(prev.readRegister("R3"),2));
		//			temp=Integer.parseInt(R2.value,2)*Integer.parseInt(R3.value,2);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1= Integer.toBinaryString(temp);
		}
		if(Opcode.equals("01000"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)/Integer.parseInt(prev.readRegister("R3"),2);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1=Integer.toBinaryString(temp);
		}
		if(Opcode.equals("01001"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)&Integer.parseInt(prev.readRegister("R3"),2);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			 R1=Integer.toBinaryString(temp);
			
		}
		if(Opcode.equals("01010"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)|Integer.parseInt(prev.readRegister("R3"),2);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1=Integer.toBinaryString(temp);
		}
		if(Opcode.equals("01100")) {
			int negate=~Integer.parseInt(prev.readRegister("R2"),2);
			String tempString= Integer.toString(negate);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1=Integer.toBinaryString(temp);
		}
		if(Opcode.equals("01101"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)^Integer.parseInt(prev.readRegister("R3"),2);
//			regFile.setRegs("R1", Integer.toBinaryString(temp));
			R1=Integer.toBinaryString(temp);
		}
		if(Opcode.equals("01110"))
			//			R1.value=R1.value.toBinaryString().substring(0,12);
//			regFile.setRegs("R1", (Integer.toBinaryString(Integer.parseInt(prev.readRegister("R1"),2)).substring(0,12)));
		R1=Integer.toBinaryString(Integer.parseInt(prev.readRegister("R1"),2)).substring(0,12);

		if(Opcode.equals("01111")) {
//			R1.value=R1.value.toBinaryString().substring(0,12);
//			regFile.setRegs("R1", (Integer.toBinaryString(Integer.parseInt(prev.readRegister("R1"),2)).substring(0,12)));

		}
		if(Opcode.equals("10000")) {
			//			R1.value=R1.value.toBinaryString().substring(0,12);
			if((Integer.parseInt(prev.readRegister("R2"),2))>(Integer.parseInt(prev.readRegister("R3"),2)))
			{	
//				regFile.setRegs("R1", Integer.toBinaryString(1));
			R1=Integer.toBinaryString(1);
			}
			else {
//				regFile.setRegs("R1", Integer.toBinaryString(0));
			R1=Integer.toBinaryString(0);
			}
		}
	
	}
	
//	public String IntegerToBinary(int integerValue) {
//		Strin/g x = "";
//		while(integerValue > 0)
//		{
//			int a = integerValue % 2;
//			x = a + x;
//			integerValue = integerValue / 2;
//		}
//		return x;
//	}
	public boolean isMemoryWrite() {
		return MemoryWrite;
	}
	public void setMemoryWrite(boolean memoryWrite) {
		MemoryWrite = memoryWrite;
	}
	public boolean isMemoryRead() {
		return MemoryRead;
	}
	public void setMemoryRead(boolean memoryRead) {
		MemoryRead = memoryRead;
	}
	public boolean isJump() {
		return Jump;
	}
	public void setJump(boolean jump) {
		Jump = jump;
	}
}
