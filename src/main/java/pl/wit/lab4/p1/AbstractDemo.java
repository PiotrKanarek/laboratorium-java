package pl.wit.lab4.p1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.wit.lab4.p2.IDemoLogger;

/**
 * Klasa abstrakcyjna demonstracyjna
 *
 * @author Łukasz
 */
public abstract class AbstractDemo implements IDemoLogger {
	protected static final Logger log = LogManager.getLogger(AbstractDemo.class.getName());
	//imię
	private String firstName = null;
	//nazwisko
	private String lastName = null;

	/**
	 * Typ osoby
	 *
	 * @return
	 */
	protected abstract EnPersonType getPersonType();

	public AbstractDemo(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void printData() {
		EnPersonType personType = getPersonType();

		log.info((firstName != null ? firstName : "")
				.concat(" ")
				.concat(lastName != null ? lastName : "")
				.concat(" - ")
				.concat(personType != null ? String.valueOf(personType) : ""));
	}

	public Logger getLogger() {
		return log;
	}

	@Override
	public String getAdditionalInfo() {
		if (getPersonType() != null) {
			return getFullName() + " " + getPersonType();
		} else return "";
	}

	public String getFullName() {
		if (firstName != null && lastName != null) {
			return firstName + " " + lastName;
		} else {
			return "";
		}
	}
}
