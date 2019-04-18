
public class Memory {
	String [] memory;
	String type;

	public Memory(String type) {
		this.type=type;
		memory = new String [20];
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
		if(i<memory.length)
			memory[i]=value;
		else {
			System.out.println("out of memory bound");
			memory[i]=value;
		}
	}

}

