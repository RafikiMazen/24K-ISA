package Components;


public class Register {
	String index;
	String name;
	String value;
	
	

	public Register(String index, String name, String value) {
		super();
		this.index = index;
		this.name = name;
		this.value = value;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
