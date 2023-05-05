package pl.wit.lab3.p1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Programmer1Test {

    @Test
    public void matchesTest() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateOfBirthFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateOfBirthTo = new Date(2000, Calendar.FEBRUARY, 15);

        Date employmentDate = new Date(2020, Calendar.MAY, 10);
        Date employmentDateFrom = new Date(2020, Calendar.MAY, 1);
        Date employmentDateTo = new Date(2020, Calendar.MAY, 15);

        Map<String, Short> subsetProgrammingLanguage = new HashMap<>();
        subsetProgrammingLanguage.put("Java", Short.valueOf("4"));
        subsetProgrammingLanguage.put("Python", Short.valueOf("3"));

        Programmer1 programmer = new Programmer1(
                "Jakub",
                "Nowak",
                dateOfBirth,
                employmentDate,
                BigDecimal.valueOf(6000)
        );

        programmer.addProgrammingLanguage("Java", Short.valueOf("5"));
        programmer.addProgrammingLanguage("Python", Short.valueOf("7"));
        programmer.addProgrammingLanguage("C++", Short.valueOf("2"));
        programmer.addProgrammingLanguage("C#", Short.valueOf("5"));

        boolean result = programmer.matches(
                "Jak",
                "Now",
                dateOfBirthFrom,
                dateOfBirthTo,
                employmentDateFrom,
                employmentDateTo,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(7000),
                subsetProgrammingLanguage
        );

        Assert.assertTrue(result);
    }

    @Test
    public void matchesStrictTest() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateOfBirthFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateOfBirthTo = new Date(2000, Calendar.FEBRUARY, 15);

        Date employmentDate = new Date(2020, Calendar.MAY, 10);
        Date employmentDateFrom = new Date(2020, Calendar.MAY, 1);
        Date employmentDateTo = new Date(2020, Calendar.MAY, 15);

        Map<String, Short> subsetProgrammingLanguage = new HashMap<>();
        subsetProgrammingLanguage.put("Java", Short.valueOf("4"));
        subsetProgrammingLanguage.put("Python", Short.valueOf("3"));

        Programmer1 programmer = new Programmer1(
                "Jakub",
                "Nowak",
                dateOfBirth,
                employmentDate,
                BigDecimal.valueOf(6000)
        );

        programmer.addProgrammingLanguage("Java", Short.valueOf("5"));
        programmer.addProgrammingLanguage("Python", Short.valueOf("7"));
        programmer.addProgrammingLanguage("C++", Short.valueOf("2"));
        programmer.addProgrammingLanguage("C#", Short.valueOf("5"));

        boolean result = programmer.matches(
                "Jakub",
                "Nowak",
                dateOfBirthFrom,
                dateOfBirthTo,
                true,
                employmentDateFrom,
                employmentDateTo,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(7000),
                subsetProgrammingLanguage
        );

        Assert.assertTrue(result);
    }
}
