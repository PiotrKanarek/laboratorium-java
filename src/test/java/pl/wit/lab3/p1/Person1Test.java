package pl.wit.lab3.p1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class Person1Test {

    @Test
    public void matchesTest() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateTo = new Date(2000, Calendar.FEBRUARY, 15);

        Person1 person = new Person1();
        person.setFirstName("Jakub");
        person.setLastName("Nowak");
        person.setDateOfBirth(dateOfBirth);

        boolean result = person.matches("Jak", "Now", dateFrom, dateTo);
        Assert.assertTrue(result);
    }

    @Test
    public void matchesStrictTest_false() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateTo = new Date(2000, Calendar.FEBRUARY, 15);

        Person1 person = new Person1();
        person.setFirstName("Jakub");
        person.setLastName("Nowak");
        person.setDateOfBirth(dateOfBirth);

        boolean result = person.matches("Jak", "Now", dateFrom, dateTo, true);
        Assert.assertFalse(result);
    }

    @Test
    public void matchesStrictTest_true() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateTo = new Date(2000, Calendar.FEBRUARY, 15);

        Person1 person = new Person1();
        person.setFirstName("Jakub");
        person.setLastName("Nowak");
        person.setDateOfBirth(dateOfBirth);

        boolean result = person.matches("Jakub", "Nowak", dateFrom, dateTo, true);
        Assert.assertTrue(result);
    }
}
