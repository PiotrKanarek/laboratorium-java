package pl.wit.lab4.p7;

import java.util.Arrays;

/**
 * Klasa bazy danych osób
 *
 * @author Łukasz
 */
public class DbPersons {
	private AbstractPerson4 persons[] = null;

	public DbPersons() {
		this.persons = new AbstractPerson4[0];
	}

	public void addPerson(AbstractPerson4 person) {
		persons = Arrays.copyOf(persons, persons.length + 1);
		persons[persons.length - 1] = person;
	}


}
