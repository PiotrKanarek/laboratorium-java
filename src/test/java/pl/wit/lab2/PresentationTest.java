package pl.wit.lab2;

import org.junit.Assert;
import org.junit.Test;

public class PresentationTest {

    @Test
    public void getFullNameTest() {
        Presentation person = new Presentation("Jan", "Kowalski");
        person.getFullName();
        Assert.assertEquals("Jan Kowalski", person.getFullName());
    }

    @Test
    public void getBirthdayDateAsAStringTest() {
        Presentation person = new Presentation(
                "Jan",
                "Kowalski",
                03,
                10,
                95
        );

        Assert.assertEquals("03.10.95", person.getBirthdayDateAsString());
    }

    @Test
    public void getBirthdayDateSStringWhenDateIsWithout0Test() {
        Presentation person = new Presentation(
                "Jan",
                "Kowalski",
                3,
                8,
                95
        );
        Assert.assertEquals("03.08.95", person.getBirthdayDateAsString());
    }

    @Test
    public void getAgeBeforeMillenniumTest() {
        Presentation person = new Presentation(
                "Jan",
                "Kowalski",
                3,
                8,
                95
        );
        Assert.assertEquals(28, person.getAge());
    }

    @Test
    public void getAgeAfterMillenniumTest() {
        Presentation person = new Presentation(
                "Jan",
                "Kowalski",
                3,
                8,
                03
        );
        Assert.assertEquals(20, person.getAge());
    }

    @Test
    public void addVisitedPlacesTest() {
        Presentation person = new Presentation("Jan", "Kowalski");
        person.setVisitedPlaces(new String[]{"Berlin", "Poznań", "Warszawa"});
        person.addVisitedPlaces(new String[]{"Rzym", "Londyn"});


        String[] expectedArray = {"Berlin", "Poznań", "Warszawa", "Rzym", "Londyn"};
        Assert.assertArrayEquals(expectedArray, person.getVisitedPlaces());
    }

    @Test
    public void getPresentationStoryTest() {
        Presentation person = new Presentation(
                "Jan",
                "Kowalski",
                6,
                4,
                98
        );
        person.setPlaceOfBirth("Warszawa");
        person.setVisitedPlaces(new String[]{"Kraków", "Gdańsk"});
        person.addVisitedPlaces(new String[]{"Rzym", "Berlin"});
        person.setFacebookFriendsQuantity((short) 2000);

        String expectedStory =
                "Cześć, nazywam się Jan Kowalski.\nMoja data narodzin to" +
                        " 06.04.98. Mam 25 lat.\nMoje miejsce urodzenia to Warszawa, stolica Polski.\n" +
                        "Odwiedzone przeze mnie miejsca to : Kraków, Gdańsk, Rzym, Berlin.\n" +
                        "Mam duże grono znajomych na facebooku - 2000 osób.";

        Assert.assertEquals(expectedStory, person.getPresentationStory());
    }
}
