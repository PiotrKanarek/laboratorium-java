package pl.wit.lab4.p4;

import pl.wit.lab4.p3.IParameter;

public class Parameter2 implements IParameter {
	private String name = null;
	private Object value = null;

	public Parameter2(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Metoda zadeklarowana jako final
	 * Brak możliwości jej przesłonięcia w klasie pochodnej
	 */
	public final String getName() {
		return name;
	}

	public final Object getValue() {
		return value;
	}

	public String myToString() {
		return "II-name=".concat(getName())
				.concat(", value=").
				concat(getValue().toString());
	}

	public String debug() {
		return myToString();
	}
}
