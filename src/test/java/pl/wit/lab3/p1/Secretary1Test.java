package pl.wit.lab3.p1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Secretary1Test {

    @Test
    public void addLanguageTest() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateOfBirthFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateOfBirthTo = new Date(2000, Calendar.FEBRUARY, 15);

        Date employmentDate = new Date(2020, Calendar.MAY, 10);
        Date employmentDateFrom = new Date(2020, Calendar.MAY, 1);
        Date employmentDateTo = new Date(2020, Calendar.MAY, 15);

        Set<String> subsetLanguages = new HashSet<>();
        subsetLanguages.add("Polski");
        subsetLanguages.add("Angielski");

        Secretary1 secretary = new Secretary1(
                "Jakub",
                "Nowak",
                dateOfBirth,
                employmentDate,
                BigDecimal.valueOf(6000)
        );

        secretary.addLanguage("Polski");
        secretary.addLanguage("Angielski");
        secretary.addLanguage("Niemiecki");

        Assert.assertTrue(secretary.getLanguages().contains("Polski"));
        Assert.assertTrue(secretary.getLanguages().contains("Angielski"));
        Assert.assertTrue(secretary.getLanguages().contains("Niemiecki"));
    }

    @Test
    public void matchesTest() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateOfBirthFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateOfBirthTo = new Date(2000, Calendar.FEBRUARY, 15);

        Date employmentDate = new Date(2020, Calendar.MAY, 10);
        Date employmentDateFrom = new Date(2020, Calendar.MAY, 1);
        Date employmentDateTo = new Date(2020, Calendar.MAY, 15);

        Set<String> subsetLanguages = new HashSet<>();
        subsetLanguages.add("Polski");
        subsetLanguages.add("Angielski");

        Secretary1 secretary = new Secretary1(
                "Jakub",
                "Nowak",
                dateOfBirth,
                employmentDate,
                BigDecimal.valueOf(6000)
        );

        secretary.addLanguage("Polski");
        secretary.addLanguage("Angielski");
        secretary.addLanguage("Niemiecki");

        boolean result = secretary.matches(
                "Jak",
                "Now",
                dateOfBirthFrom,
                dateOfBirthTo,
                employmentDateFrom,
                employmentDateTo,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(7000),
                subsetLanguages);

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

        Set<String> subsetLanguages = new HashSet<>();
        subsetLanguages.add("Polski");
        subsetLanguages.add("Angielski");

        Secretary1 secretary = new Secretary1(
                "Jakub",
                "Nowak",
                dateOfBirth,
                employmentDate,
                BigDecimal.valueOf(6000)
        );

        secretary.addLanguage("Polski");
        secretary.addLanguage("Angielski");
        secretary.addLanguage("Niemiecki");

        boolean result = secretary.matches(
                "Jakub",
                "Nowak",
                dateOfBirthFrom,
                dateOfBirthTo,
                true,
                employmentDateFrom,
                employmentDateTo,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(7000),
                subsetLanguages);

        Assert.assertTrue(result);
    }

}
