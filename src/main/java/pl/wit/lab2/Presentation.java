package pl.wit.lab2;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author piotrkanarek
 * <p>
 * Klasa zawiera metody do utworzenia obiektu osoby, nadania jej odpowiednich parametrów oraz metody potrzebne do
 * odczytywania i modyfikowania ich.
 */
public class Presentation {

	// imię osoby
	private final String firstName;
	// nazwisko osoby
	private final String lastName;
	// dzień urodzenia, miesiąc urodzenia, rok urodzenia
	private byte birthdayDay, birthdayMonth, birthdayYear;
	// miejsce urodzenia
	private String placeOfBirth;
	// ilość znajomych na Facebooku
	private short facebookFriendsQuantity;
	// odwiedzone miejsca
	private String[] visitedPlaces;

	public Presentation(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Presentation(String firstName, String lastName, int birthdayDay, int birthdayMonth, int birthdayYear) {
		this(firstName, lastName);
		this.birthdayDay = (byte) birthdayDay;
		this.birthdayMonth = (byte) birthdayMonth;
		this.birthdayYear = (byte) birthdayYear;
	}

	/**
	 * Metoda zwraca imię oraz nazwisko jako jeden String.
	 *
	 * @return String zawierający imię i nazwisko oddzielone spacją.
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * Metoda zamienia poszczególne składowe daty urodzenia na jeden String.
	 *
	 * @return String z datą urodzenia w formacie dd.mm.yy
	 */
	public String getBirthdayDateAsString() {
		//Ręczne zbudowanie Daty w formacie dd.MM.yy (rok wyjątkowo na 2 pozycjach ;) )
		String day = "" + birthdayDay;
		String month = "" + birthdayMonth;
		String year = "" + birthdayYear;
		StringBuilder birthdayDate = new StringBuilder();

		if (day.length() == 1) {
			day = "0" + day;
		}

		if (month.length() == 1) {
			month = "0" + month;
		}

		if (year.length() == 4) {
			year = year.substring(2);
		}

		birthdayDate.append(day).append(".").append(month).append(".").append(year);

		return birthdayDate.toString();
	}

	/**
	 * Metoda liczby aktualny wiek osoby.
	 *
	 * @return wiek osoby
	 */
	public byte getAge() {
		LocalDate now = LocalDate.now();
		String tmp = String.valueOf(now.getYear());
		int currentYear = Integer.parseInt(tmp.substring(2));
		int age = currentYear - birthdayYear;

		if (age <= 0) {
			int yearsToMillennium = 100 - birthdayYear;
			age = currentYear + yearsToMillennium;
		}

		return (byte) age;
	}

	/**
	 * Metoda dodaje odwiedzone miejsca.
	 *
	 * @param newVisitedPlaces tablica typu String zawierająca odwiedzone miejsca do dodania.
	 */
	public void addVisitedPlaces(String[] newVisitedPlaces) {
		for (String place : newVisitedPlaces) {
			visitedPlaces = Arrays.copyOf(visitedPlaces, visitedPlaces.length + 1);
			visitedPlaces[visitedPlaces.length - 1] = place;
		}
	}

	/**
	 * Metoda tworzy historię na podstawię podanych parametrów utworzonego obiektu osoby.
	 *
	 * @return String z historią utworzonej osoby.
	 */
	public String getPresentationStory() {
		String facebookFriendsStory = null;
		String bornInCapitalCity;
		StringBuilder visitedPlacesStory = new StringBuilder();
		StringBuilder personPresentation = new StringBuilder();

		if (facebookFriendsQuantity == 0) {
			facebookFriendsStory = "Nie mam znajomych na Facebooku";
		} else if (facebookFriendsQuantity > 0 && facebookFriendsQuantity <= 100) {
			facebookFriendsStory = "Mam małe grono znajomych na Facebooku";
		} else if (facebookFriendsQuantity > 100 && facebookFriendsQuantity <= 500) {
			facebookFriendsStory = "Mam średnie grono znajomych na Facebooku";
		} else if (facebookFriendsQuantity > 500 && facebookFriendsQuantity <= 1000) {
			facebookFriendsStory = "Mam spore grono znajomych na Facebooku";
		} else if (facebookFriendsQuantity > 1000 && facebookFriendsQuantity <= 5000) {
			facebookFriendsStory = "Mam duże grono znajomych na facebooku";
		} else if (facebookFriendsQuantity > 5000) {
			facebookFriendsStory = "Mam ogromne grono znajomych na facebooku";
		}

		if (visitedPlaces == null) {
		} else {
			boolean firstIteration = true;
			visitedPlacesStory.append("Odwiedzone przeze mnie miejsca to : ");
			for (String el : visitedPlaces) {
				if (firstIteration) {
					visitedPlacesStory.append(el);
				} else
					visitedPlacesStory.append(", ").append(el);
				firstIteration = false;
			}
		}

		switch (placeOfBirth.toUpperCase()) {
			case "WARSZAWA":
				bornInCapitalCity = ", stolica Polski.";
				break;

			case "KRAKÓW":
				bornInCapitalCity = ", poprzednia stolica Polski.";
				break;
			case "GNIEZNO":
				bornInCapitalCity = ", pierwsza stolica Polski.";
				break;
			default:
				bornInCapitalCity = "";
				break;
		}

		personPresentation
				.append("Cześć, nazywam się ")
				.append(getFullName())
				.append(".\nMoja data narodzin to ")
				.append(getBirthdayDateAsString())
				.append(". Mam ")
				.append(getAge())
				.append(" lat.\n")
				.append("Moje miejsce urodzenia to ")
				.append(placeOfBirth)
				.append(bornInCapitalCity)
				.append("\n")
				.append(visitedPlacesStory)
				.append(".\n")
				.append(facebookFriendsStory)
				.append(" - ")
				.append(facebookFriendsQuantity)
				.append(" osób.");

		return personPresentation.toString();
	}


	////////////////////////////////////////////
	// gettery i settery
	////////////////////////////////////////////
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public void setFacebookFriendsQuantity(short facebookFriendsQuantity) {
		this.facebookFriendsQuantity = facebookFriendsQuantity;
	}

	public String[] getVisitedPlaces() {
		return visitedPlaces;
	}

	public void setVisitedPlaces(String[] visitedPlaces) {
		this.visitedPlaces = visitedPlaces;
	}
}
