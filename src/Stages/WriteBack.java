package Stages;

import main.Memory;

public class WriteBack implements Runnable {
	Memory memory;
	String NewData;
	int AddressIndex;
	
	public WriteBack(Memory memory,String newData,int AddressIndex) {
		this.memory=memory;
		this.NewData=newData;
		this.AddressIndex=AddressIndex;
	}
	public void run() {
		for(int i=0;i<memory.getSize();i++) {
			if(AddressIndex== Integer.parseInt(memory.readFromIndex(i))) {
				 memory.setIntoMemory(AddressIndex, NewData);
			}
		}
	}
}
