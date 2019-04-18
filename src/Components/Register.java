package Components;

public class Register {
	int index;
	String name;
	String value;
	int size;

	public Register(int index, String name, String value, int size) {
		super();
		this.index = index;
		this.name = name;
		this.value = value;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
