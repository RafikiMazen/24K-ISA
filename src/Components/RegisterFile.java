package Components;

import java.util.ArrayList;

public class RegisterFile {
	
	
	ArrayList<Register> Registers = new ArrayList<Register>();
	
	
	

	public RegisterFile() {
		//TODO Create all registers and add them 
		Register $a0= new Register("00000", "$a0", null);
		Register $a1= new Register("00001", "$a1", null);
		Register $a2= new Register("00010", "$a2", null);
		Register $a3= new Register("00011", "$a3", null);
		Register $a4= new Register("00100", "$a4", null);
		Register $a5= new Register("00101", "$a5", null);
		Register $b0= new Register("00110", "$b0", null);
		Register $b1= new Register("00111", "$b1", null);
		Register $b2= new Register("01000", "$b2", null);
		Register $b3= new Register("01001", "$b3", null);
		Register $b4= new Register("01010", "$b4", null);
		Register $b5= new Register("01011", "$b5", null);
		Register $d0= new Register("01100", "$d0", null);
		Register $d1= new Register("01101", "$d1", null);
		Register $d2= new Register("01110", "$d2", null);
		Register $d3= new Register("01111", "$d3", null);
		Register $d4= new Register("10000", "$d4", null);
		Register $d5= new Register("10001", "$d5", null);
		Register $r0= new Register("10010", "$r0", null);
		Register $r1= new Register("10011", "$r1", null);
		Register $r2= new Register("10100", "$r2", null);
		Register $r3= new Register("10101", "$r3", null);
		Register $r4= new Register("10110", "$r4", null);
		Register $r5= new Register("10111", "$r5", null);
		Register $y0= new Register("11000", "$y0", null);
		Register $y1= new Register("11001", "$y1", null);
		Register $y2= new Register("11010", "$y2", null);
		Register $y3= new Register("11011", "$y3", null);
		Register $y4= new Register("11100", "$y4", null);
		Register $y5= new Register("11101", "$y5", null);
		Register $24k= new Register("11110", "$24k", null);
		Register $zero= new Register("11111", "$zero", null);
		
		Registers.add($a0);
		Registers.add($a1);
		Registers.add($a2);
		Registers.add($a3);
		Registers.add($a4);
		Registers.add($a5);
		Registers.add($b0);
		Registers.add($b1);
		Registers.add($b2);
		Registers.add($b3);
		Registers.add($b4);
		Registers.add($b5);
		Registers.add($d0);
		Registers.add($d1);
		Registers.add($d2);
		Registers.add($d3);
		Registers.add($d4);
		Registers.add($d5);
		Registers.add($r0);
		Registers.add($r1);
		Registers.add($r2);
		Registers.add($r3);
		Registers.add($r4);
		Registers.add($r5);
		Registers.add($y0);
		Registers.add($y1);
		Registers.add($y2);
		Registers.add($y3);
		Registers.add($y4);
		Registers.add($y5);
		Registers.add($24k);
		Registers.add($zero);
		

	}
	
	public String getFromRegs(String name) {
		

		for(int i =0;i<Registers.size();i++ ) {
			if(((Register) Registers.get(i)).getName()==name)
				return ((Register) Registers.get(i)).getValue();
		}
		return null;
	}
	public String getFromRegsbyBits(String bits) {
	
		for(int i =0;i<Registers.size();i++ ) {
			if(((Register) Registers.get(i)).getIndex()==bits)
				return ((Register) Registers.get(i)).getValue();
		}
		return null;
	}
	
	public void setRegs(String name,String value) {
		for(int i =0;i<Registers.size();i++ ) {
			if(((Register) Registers.get(i)).getName()==name)
				((Register) Registers.get(i)).setValue(value);
		}
	}
	public void setRegsbyBits(String bits,String value) {
		for(int i =0;i<Registers.size();i++ ) {
			if(((Register) Registers.get(i)).getIndex()==bits)
				((Register) Registers.get(i)).setValue(value);
		}
	}



}
