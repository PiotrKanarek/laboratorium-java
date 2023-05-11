package pl.wit.lab4.p1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Klasa pochodna - Student
 *
 * @author Łukasz
 */
public class StudentDemo extends AbstractDemo {

	private Map<String, Byte> mapPoints = null;

	public StudentDemo(String firstName, String lastName, LinkedHashMap<String, Byte> mapPoints) {
		super(firstName, lastName);
		this.mapPoints = mapPoints;
	}

	protected final Logger log = LogManager.getLogger(StudentDemo.class.getName());

	protected final Logger log1 = LogManager.getLogger(TeacherDemo.class.getName());

	/**
	 * @param criterion      kryetrium oceny
	 * @param numberOfPoints liczba puntków
	 * @throws PersonException jeśli liczba puntków jest ujemna lub kryterium oceny jest puste.
	 */
	public void addPoints(String criterion, byte numberOfPoints) throws PersonException {
		if (criterion == null || criterion.isEmpty()) {
			throw new PersonException("KRYTERIUM OCENY NIE MOżE BYĆ PUSTE!");
		}

		if (numberOfPoints < 0) {
			throw new PersonException("LICZBA PUNTKÓW NIE MOŻE BYĆ UJEMNA");
		}

		mapPoints.put(criterion, numberOfPoints);

		logDebug(getAdditionalInfo());
	}

	@Override
	protected EnPersonType getPersonType() {
		return EnPersonType.student;
	}

	public Map<String, Byte> getMapPoints() {
		return mapPoints;
	}
}
