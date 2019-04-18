package Stages;

public class Fetch {
	Memory Memory;
	String MemorySpace;
	public Fetch(String instruction) {
		 Memory=new Memory();
		 for(int i=0;i<Memory.Addresses.size();i++) {
		if(instruction==Memory.Addresses.get(i)) {
			MemorySpace= Memory.Addresses.get(i);
		}
			
		 }
	}

}

