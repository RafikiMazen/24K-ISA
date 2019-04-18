package Components;

public class RegisterFile {
	Register [] registers;
	
	
	public RegisterFile() {
		//TODO Create all registers and add them 
		//ADD $S0,$S1 ... in order
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
