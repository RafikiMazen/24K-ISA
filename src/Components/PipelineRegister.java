package Components;

import java.util.HashMap;
import java.util.Map.Entry;

public class PipelineRegister {
	int type ;
	HashMap<String,String> registers;
	
	public PipelineRegister(int type) {
		if(type==1) {
//			setup registers for first step
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
	
	public void setRegister(String reg,String value) {
		
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
