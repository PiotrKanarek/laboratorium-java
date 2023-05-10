package pl.wit.lab4.p1;

/**
 * Klasa pochodna - Student
 *
 * @author Łukasz
 */
public class StudentDemo extends AbstractDemo {
	public StudentDemo(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	protected String getPersonType() {
		return "student";
	}
}
