package pl.wit.lab2;

import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author piotrkanarek
 *
 */
public class Presentation {

	//
	private String firstName;
	//
	private String lastName;
	//
	private byte birthdayDay, birthdayMonth, birthdayYear;
	//
	private String placeOfBirth;
	//
	private short facebookFriendsQuantity;
	//
	private String[] visitedPlaces;

	public Presentation(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Presentation(String firstName,String lastName,int birthdayDay,int birthdayMonth,int birthdayYear) {
		this(firstName,lastName);
		this.birthdayDay = (byte) birthdayDay;
		this.birthdayMonth = (byte) birthdayMonth;
		this.birthdayYear = (byte) birthdayYear;
	}

	public String getFullName() {
		StringBuilder fullName = new StringBuilder();
		fullName.append(firstName).append(" ").append(lastName);
		return fullName.toString();
	}

	public String getBirthdayDateAsString() {
		//Ręczne zbudowanie Daty w formacie dd.MM.yy (rok wyjątkowo na 2 pozycjach ;) )
		StringBuilder day = new StringBuilder(birthdayDay);
		StringBuilder month = new StringBuilder(birthdayMonth);
		StringBuilder year = new StringBuilder(birthdayYear);
		StringBuilder birthdayDate = new StringBuilder();

		if(day.length() == 1){
			day.insert(0, "0");
		} else if(month.length() == 1){
			month.insert(0, "0");
		}

		if (year.length() == 4) {
			year.delete(0,1);
		}

		birthdayDate.append(day).append(".").append(month).append(".").append(year);

		return birthdayDate.toString();
	}

	public byte getAge() {
		LocalDate now = LocalDate.now();
		return (byte) (now.getYear() - birthdayYear);
	}

	public void addVisitedPlaces(String[] newVisitedPlaces) {
		for (String place : newVisitedPlaces) {
			visitedPlaces = Arrays.copyOf(visitedPlaces, visitedPlaces.length + 1);
			visitedPlaces[visitedPlaces.length - 1] = place;
		}
	}

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

		for (String place : visitedPlaces) {
			if (visitedPlaces == null) {
			} else {
				visitedPlacesStory.append("Do tej pory odwiedziłem : ");
				for (String el : visitedPlaces) {
					visitedPlacesStory.append(", ").append(el);
				}
			}
		}

		switch (placeOfBirth.toUpperCase()) {
			case "WARSZAWA":
				bornInCapitalCity = ", stolica Polski";
				break;

			case "KRAKÓW":
				bornInCapitalCity = ", poprzednia stolica Polski";
				break;
			case "GNIEZNO":
				bornInCapitalCity = ", pierwsza stolica Polski";
				break;
			default:
				bornInCapitalCity = "";
				break;
		}

		personPresentation
				.append("Cześć,\n nazywam się ")
				.append(getFullName())
				.append(".\n Moja data narodzin to ")
				.append(getBirthdayDateAsString())
				.append(". Mam")
				.append(getAge())
				.append("lat.\n")
				.append("Moje miejsce urodzenia to ")
				.append(placeOfBirth)
				.append(bornInCapitalCity)
				.append("\n")
				.append(visitedPlacesStory)
				.append("\n")
				.append(facebookFriendsStory);

		return personPresentation.toString();
	}


	////////////////////////////////////////////
	// gettery i settery
	////////////////////////////////////////////
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public short getFacebookFriendsQuantity() {
		return facebookFriendsQuantity;
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
