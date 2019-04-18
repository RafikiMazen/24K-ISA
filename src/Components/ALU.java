package Components;

import java.util.Scanner;

import Stages.Memory;

public class ALU {
	//	String instruction;
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	String Opcode;
	String rs;
	String rt;
	String rd;
	String Immediate;
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
	}
	public void operation() {
		//Memory
		if(Opcode.equals("00000"))
			//			Memory.load(R1,R2);
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
		//		R1.value=R1.value.toString().substring(0,12);
		if(Opcode.equals("00010")) {
			temp=Integer.parseInt(prev.readRegister("R2"),2)+Integer.parseInt(prev.readRegister("R3"),2);
			regFile.setRegs("R1", Integer.toString(temp));
		}if(Opcode.equals("00011")) {
			temp=Integer.parseInt(prev.readRegister("R2"),2)-Integer.parseInt(prev.readRegister("R3"),2);
			regFile.setRegs("R1", Integer.toString(temp));
		}
		if(Opcode.equals("00100"))
			//		R1.value=Integer.toString(i);
			regFile.setRegs("R1", Immediate);
		if(Opcode.equals("00101"))
			regFile.setRegs("R1",(Integer.toString(Integer.parseInt(prev.readRegister("R1"),2)>>Integer.parseInt(Immediate))));
		//	regFile.setRegs("R1", (Integer.parseInt(prev.readRegister("R1"),2))>>Immediate);
		if(Opcode.equals("00110"))
			regFile.setRegs("R1",(Integer.toString(Integer.parseInt(prev.readRegister("R1"),2)<<Integer.parseInt(Immediate))));
		if(Opcode.equals("00111"))
		{	temp=Integer.parseInt(prev.readRegister("R2"),2)*Integer.parseInt(prev.readRegister("R3"),2);
		//			temp=Integer.parseInt(R2.value,2)*Integer.parseInt(R3.value,2);
		regFile.setRegs("R1", Integer.toString(temp));
		}
		if(Opcode.equals("01000"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)/Integer.parseInt(prev.readRegister("R3"),2);
			regFile.setRegs("R1", Integer.toString(temp));
		}
		if(Opcode.equals("01001"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)&Integer.parseInt(prev.readRegister("R3"),2);
			regFile.setRegs("R1", Integer.toString(temp));
		}
		if(Opcode.equals("01010"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)|Integer.parseInt(prev.readRegister("R3"),2);
			regFile.setRegs("R1", Integer.toString(temp));
		}
		if(Opcode.equals("01100")) {
			int negate=~Integer.parseInt(prev.readRegister("R2"),2);
			String tempString= Integer.toString(negate);
			regFile.setRegs("R1", Integer.toString(temp));
		}if(Opcode.equals("01101"))
		{
			temp=Integer.parseInt(prev.readRegister("R2"),2)^Integer.parseInt(prev.readRegister("R3"),2);
			regFile.setRegs("R1", Integer.toString(temp));
		}
		if(Opcode.equals("01110"))
			//			R1.value=R1.value.toString().substring(0,12);
			regFile.setRegs("R1", (Integer.toString(Integer.parseInt(prev.readRegister("R1"),2)).substring(0,12)));

		if(Opcode.equals("01111")) {
			//			R1.value=R1.value.toString().substring(0,12);
			regFile.setRegs("R1", (Integer.toString(Integer.parseInt(prev.readRegister("R1"),2)).substring(0,12)));

		}
		if(Opcode.equals("10000")) {
			//			R1.value=R1.value.toString().substring(0,12);
			if((Integer.parseInt(prev.readRegister("R2"),2))>(Integer.parseInt(prev.readRegister("R3"),2)))
				regFile.setRegs("R1", Integer.toString(1));
			else
				regFile.setRegs("R1", Integer.toString(0));
		}
		if(Opcode.equals("10001") ||Opcode.equals("10010")||Opcode.equals("10011")||Opcode.equals("10100")||Opcode.equals("10101"))
		{
			Jump=true;

		}
	}
	public String IntegerToBinary(int integerValue) {
		String x = "";
		while(integerValue > 0)
		{
			int a = integerValue % 2;
			x = a + x;
			integerValue = integerValue / 2;
		}
		return x;
	}
}
