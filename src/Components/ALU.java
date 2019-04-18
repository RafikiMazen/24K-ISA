package Components;

import java.util.Scanner;

import Stages.Memory;

public class ALU {
//	String instruction;
	String Opcode;
	Register R1;
	Register R2;
	Register R3;
	int i;
	int temp;
	public ALU() {
//		Opcode=instruction.substring(0,6);
		String s =operation();
		R1=new PipelineRegister().rd;
		R2=new PipelineRegister().rs;
		R3=new PipelineRegister().rt;
		i=new PipelineRegister().immediate;
	}
	public String operation() {
//		String sub=instruction.substring(6,11);
//		String R1Binary= IntegerToBinary(R1.value);
//		String R2Binary= IntegerToBinary(R2.value);
//		String R3Binary= IntegerToBinary(R3.value);
//		switch(Opcode) {
//		//Load from memory
//		case "00000"+sub+"00": 
//		case "00001":
//		case "00010":
//		case "00011":	
//		}
		//Memory
//	if(Opcode.equals("00000"+sub+"00000000000000000"))
	if(Opcode.equals("00000"))
		Memory.load(R1,R2);
//	if(Opcode.equals("00001"+sub+"00000000000000000" ))
	if(Opcode.equals("00001"))
		Memory.store(R1,R2);
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
		temp=Integer.parseInt(R2.value,2)+Integer.parseInt(R3.value,2);
		R1.value=Integer.toString(temp);
	}if(Opcode.equals("00011")) {
		temp=Integer.parseInt(R2.value,2)-Integer.parseInt(R3.value,2);
	R1.value=Integer.toString(temp);
	}
	if(Opcode.equals("00100"))
		R1.value=Integer.toString(i);
	if(Opcode.equals("00101"))
		R1.value=Integer.toString(Integer.parseInt(R1.value)>>i);
	if(Opcode.equals("00110"))
		R1.value=Integer.toString(Integer.parseInt(R1.value)<<i);
	if(Opcode.equals("00111"))
	{
		temp=Integer.parseInt(R2.value,2)*Integer.parseInt(R3.value,2);
	R1.value=Integer.toString(temp);
	}
	if(Opcode.equals("01000"))
	{
		temp=Integer.parseInt(R2.value,2)/Integer.parseInt(R3.value,2);
	R1.value=Integer.toString(temp);
	}
	if(Opcode.equals("01001"))
	{
		temp=Integer.parseInt(R2.value,2)&Integer.parseInt(R3.value,2);
	R1.value=Integer.toString(temp);
	}
	if(Opcode.equals("01010"))
	{
		temp=Integer.parseInt(R2.value,2)|Integer.parseInt(R3.value,2);
	R1.value=Integer.toString(temp);
	}
	if(Opcode.equals("01100")) {
		int negate=~Integer.parseInt(R2.value);
		String tempString= Integer.toString(negate);
		R1.value=tempString;
	}if(Opcode.equals("01101"))
	{
		temp=Integer.parseInt(R2.value,2)^Integer.parseInt(R3.value,2);
	R1.value=Integer.toString(temp);
	}
	if(Opcode.equals("01110"))
		R1.value=R1.value.toString().substring(0,12);
	}
	public String IntegerToBinary(int integerValue) {
//		 	int n, m;
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
