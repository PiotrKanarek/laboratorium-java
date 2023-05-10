package pl.wit.lab4.p3;

public final class Parameter implements IParameter {
	private String name = null;
	private Object value = null;

	public Parameter(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public String myToString() {
		return "name=".concat(getName())
				.concat(", value=").
				concat(getValue().toString());
	}

	public String debug() {
		return myToString();
	}
}
