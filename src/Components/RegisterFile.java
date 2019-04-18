package Components;

public class RegisterFile {
	Register [] registers;
	Register rs;
	Register rt;
	Register rd;
	
	
	public RegisterFile() {
		//TODO Create all registers and add them 
	}
	
	public String getFromRegs(String name) {
		for(int i =0;i<registers.length;i++ ) {
			if(registers[i].name==name)
				return registers[i].value;
		}
		return null;
	}
	public void setRegs(String name,String value) {
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
