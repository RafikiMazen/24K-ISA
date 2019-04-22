package Components;

public class RegisterFile {
	Register [] registers;
	int PC;
	
	
	
	public int getPC() {
		return PC;
	}

	public void setPC(int pC) {
		PC = pC;
	}

	public RegisterFile() {
		   //TODO Create all registers and add them 
		PC=0;
		registers=new Register[32];
        Register $a0= new Register("00000", "$a0", "0");
        Register $a1= new Register("00001", "$a1", "0");
        Register $a2= new Register("00010", "$a2", "0");
        Register $a3= new Register("00011", "$a3", "0");
        Register $a4= new Register("00100", "$a4", "0");
        Register $a5= new Register("00101", "$a5", "0");
        Register $b0= new Register("00110", "$b0", "0");
        Register $b1= new Register("00111", "$b1", "0");
        Register $b2= new Register("01000", "$b2", "0");
        Register $b3= new Register("01001", "$b3", "0");
        Register $b4= new Register("01010", "$b4", "0");
        Register $b5= new Register("01011", "$b5", "0");
        Register $d0= new Register("01100", "$d0", "0");
        Register $d1= new Register("01101", "$d1", "0");
        Register $d2= new Register("01110", "$d2", "0");
        Register $d3= new Register("01111", "$d3", "0");
        Register $d4= new Register("10000", "$d4", "0");
        Register $d5= new Register("10001", "$d5", "0");
        Register $r0= new Register("10010", "$r0", "0");
        Register $r1= new Register("10011", "$r1", "0");
        Register $r2= new Register("10100", "$r2", "0");
        Register $r3= new Register("10101", "$r3", "0");
        Register $r4= new Register("10110", "$r4", "0");
        Register $r5= new Register("10111", "$r5", "0");
        Register $y0= new Register("11000", "$y0", "0");
        Register $y1= new Register("11001", "$y1", "0");
        Register $y2= new Register("11010", "$y2", "0");
        Register $y3= new Register("11011", "$y3", "0");
        Register $y4= new Register("11100", "$y4", "0");
        Register $y5= new Register("11101", "$y5", "0");
        Register $24k= new Register("11110", "$24k", "0");
        Register $zero= new Register("11111", "$zero", "0");
        
        registers[0]=$a0;
        registers[1]=$a1;   
        registers[2]=$a2;
        registers[3]=$a3;
        registers[4]=$a4;
        registers[5]=$a5;
        registers[6]=$b0;
        registers[7]=$b1;   
        registers[8]=$b2;
        registers[9]=$b3;
        registers[10]=$b4;
        registers[11]=$b5;
        registers[12]=$d0;
        registers[13]=$d1;  
        registers[14]=$d2;
        registers[15]=$d3;
        registers[16]=$d4;
        registers[17]=$d5;
        registers[18]=$r0;
        registers[19]=$r1;  
        registers[20]=$r2;
        registers[21]=$r3;
        registers[22]=$r4;
        registers[23]=$r5;
        registers[24]=$y0;
        registers[25]=$y1;  
        registers[26]=$y2;
        registers[27]=$y3;
        registers[28]=$y4;
        registers[29]=$y5;
        registers[30]=$24k;
        registers[31]=$zero;
      
	}
	
	
	public Register getRegs(String bits) {
		int index= Integer.parseInt(bits,2);
		return registers[index];
	}
	
	
	public String getFromRegs(String name) {
		for(int i =0;i<registers.length;i++ ) {
			if(registers[i].name==name)
				return registers[i].value;
		}
		return "0";
	}
	public String getFromRegsbyBits(String bits) {
		int index= Integer.parseInt(bits,2);
		return registers[index].value;
	}
	
	public void setRegs(String name,String value) {
		for(int i =0;i<registers.length;i++ ) {
			if(registers[i].name==name)
				registers[i].value=value;
		}
	}
	public void setRegsbyBits(String bits,String value) {
		int index= Integer.parseInt(bits,2);
		registers[index].value=value;
	}



}
