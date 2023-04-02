package pl.wit.lab2;

import java.time.LocalDate;

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
		return (byte)(now.getYear() - birthdayYear);
	}

	public Presentation addVisitedPlaces(){

	}

	public String getPresentationStory() {

		return null;
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
