package Components;

public class RegisterFile {
	Register [] registers;
	Register rs;
	Register rt;
	Register rd;
	
	
	public RegisterFile() {
		//TODO Create all registers and add them 
	}
	
	public int getFromRegs(String name) {
		for(int i =0;i<registers.length;i++ ) {
			if(registers[i].name==name)
				return registers[i].value;
		}
		return 0;
	}
	public void setaRegs(String name,int value) {
		for(int i =0;i<registers.length;i++ ) {
			if(registers[i].name==name)
				registers[i].value=value;
		}
	}

	public Register getRs() {
		return rs;
	}



	public void setRs(Register rs) {
		this.rs = rs;
	}



	public Register getRt() {
		return rt;
	}



	public void setRt(Register rt) {
		this.rt = rt;
	}



	public Register getRd() {
		return rd;
	}



	public void setRd(Register rd) {
		this.rd = rd;
	}




}
