package Components;

import java.util.HashMap;
import java.util.Map.Entry;

import Stages.Fetch;

public class PipelineRegister {
	int type ;
	HashMap<String,String> registers;
	boolean flag;

	public PipelineRegister(int type) {
		if(type==1) {
			registers.put("PC", "");
			registers.put("IR", "");
		}
		if(type==2) {
			//			setup registers for first step
		}
		if(type==3) {
			//			setup registers for first step
		}
		if(type==4) {
			//			setup registers for first step
		}

	}


	public void clear() {
		registers.clear();
		flag=false;
	}
	public void setRegister(String reg,String value) {
		registers.replace(reg, value);
	}

	public void updateValues(Fetch fetch){
		flag=true;
		if(type==1) {
			registers.replace("PC", Integer.toBinaryString(fetch.getInstructionAddress()));
			registers.replace("IR", fetch.getInstruction());
		}
		if(type==2) {

		}
	}

	public String readRegister(String reg) {
		String key;
		for(Entry<String, String> rec : registers.entrySet()) {
			if(rec.getKey()==reg) {
				return rec.getValue();
			}
		}
		return null;
	}



}
