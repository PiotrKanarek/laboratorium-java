package pl.wit.lab2;

/**
 * 
 * @author 
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
	private String visitedPlaces[];
	
	public Presentation(String firstName,String lastName) {
		//inicjalizacja imienia i nazwiska
	}
	
	public Presentation(String firstName,String lastName,int birthdayDay,int birthdayMonth,int birthdayYear) {
		this(firstName,lastName);
		//dalsza inicjalizacja
	}
	
	public String getFullName() {
		//Zwrócenie połączonej wartości imienia i nazwiska ze spacją pomiędzy
		return null;
	}
	
	public String getBirthdayDateAsString() {
		//Ręczne zbudowanie Daty w formacie dd.MM.yy (rok wyjątkowo na 2 pozycjach ;) )
		return null;
	}
	
	public byte getAge() {
		//LocalDate now = LocalDate.now();  
		//now.getYear();
		//Obliczenie aktualnego wieku
		return 0;
	}
	
	public String getPresentationStory() {
	
		return null;
	}
	
	
	////////////////////////////////////////////
	// gettery i settery
	////////////////////////////////////////////
}
