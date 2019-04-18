package main;

public class Memory {
	String [] memory;
	String type;
	int size ;
	int instructions;

	public Memory(String type, int size) {
		this.type=type;
		this.size=size;
		memory = new String [20];
		instructions=0;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getInstructions() {
		return instructions;
	}

	public void setInstructions(int instructions) {
		this.instructions = instructions;
	}

	public void readfromFile(String path) {
		//TODO add reading from file if the program is already stored
	}

	public String readFromIndex(int index) {
		int i = index/4;
		if(i<memory.length)
			return memory[i];
		else {
			System.out.println("out of memory bound");
			return null;
		}
	}
	public void setIntoMemory(int index, String value) {
		int i = index/4;
		if(i<memory.length) {
			memory[i]=value;
			instructions++;
		}
		else {
			System.out.println("out of memory bound");
			memory[i]=value;
		}
	}

}
