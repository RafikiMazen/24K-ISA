package Stages;

import Components.PipelineRegister;
import Components.Register;
import Components.RegisterFile;

public class Decode {
	private RegisterFile regFile;
	PipelineRegister prev;
	PipelineRegister next;
	
	public Decode(RegisterFile reg,  PipelineRegister next, PipelineRegister prev) {
		regFile=reg;
		this.prev=prev;
		this.next=next;
	}
	public void run() {
		regFile.setRegs("PC", prev.readRegister("PC"));
		String inst= prev.readRegister("IR");
				regFile.setRegs("IR",inst);
	String instruction;
	String Opcode; 
	String sub;
	Register R1;
	Register R2;
	Register R3;
	int i;
	int temp;
	public Decode() {
		Opcode=instruction.substring(0,6);
		if(instruction==)
		R1=instruction.substring(6,12);
		R2=instruction.substring(12,18);
		R3=instruction.substring(18,24);;

		i=new PipelineRegister().immediate;
		 sub=instruction.substring(6,11);
		 String s =DecodeNow();
	}
	
	public String DecodeNow() {
	if(Opcode.equals("00000"+sub+"00000000000000000"))
			Memory.load(R1,R2);
		if(Opcode.equals("00001"+sub+"00000000000000000" ))
			Memory.store(R1,R2);
		//ARITHMATIC AND LOGICAL OPERATIONS
		if(Opcode.equals("00010"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=Integer.parseInt(R2.value,2)+Integer.parseInt(R3.value,2);
		if(Opcode.equals("00011"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R2.value-R3.value;
		if(Opcode.equals("00100"+sub+instruction.substring(11)))
			R1.value=i;
		if(Opcode.equals("00101"+sub+instruction.substring(11)))
			R1.value=R1.value>>i;
		if(Opcode.equals("00110"+sub+instruction.substring(11)))
			R1.value=R1.value<<i;
		if(Opcode.equals("00111"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R2.value*R3.value;
		if(Opcode.equals("01000"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R2.value/R3.value;
		if(Opcode.equals("01001"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R2.value&R3.value;
		if(Opcode.equals("01010"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R2.value|R3.value;
		if(Opcode.equals("01100"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=~R2.value;
		if(Opcode.equals("01101"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R2.value^R3.value;
		if(Opcode.equals("01110"+sub+instruction.substring(11,16)+"000000000000"))
			R1.value=R1.value.toString().substring(0,12);
}
}