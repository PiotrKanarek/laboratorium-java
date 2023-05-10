package pl.wit.lab4.p1;

/**
 * Klasa pochodna - nauczyciel
 *
 * @author Łukasz
 */
public class TeacherDemo extends AbstractDemo {
	public TeacherDemo(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
    protected EnPersonType getPersonType() {
        return EnPersonType.teacher;
    }
}
