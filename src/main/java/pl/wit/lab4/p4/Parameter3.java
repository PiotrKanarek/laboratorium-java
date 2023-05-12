package pl.wit.lab4.p4;

public class Parameter3 {
    //Zmienna zadeklarowana jako final
    private final String name;
    private Object value = null;

    public Parameter3(String name, Object value) {
        //Tylko raz można ją zainicjować
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public boolean equals(final String name) {
        return this.name.equals(name);
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
