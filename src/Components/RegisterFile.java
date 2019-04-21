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
		registers=new Register[32];
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
	
	public String getFromRegs(String name) {
		for(int i =0;i<registers.length;i++ ) {
			if(registers[i].name==name)
				return registers[i].value;
		}
		return null;
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
