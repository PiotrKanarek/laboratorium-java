package pl.wit.lab3.p1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Employee1Test {

    @Test
    public void matchesTest() {
        Date dateOfBirth = new Date(2000, Calendar.FEBRUARY, 10);
        Date dateOfBirthFrom = new Date(2000, Calendar.FEBRUARY, 1);
        Date dateOfBirthTo = new Date(2000, Calendar.FEBRUARY, 15);

        Date employmentDate = new Date(2020, Calendar.MAY, 10);
        Date employmentDateFrom = new Date(2020, Calendar.MAY, 1);
        Date employmentDateTo = new Date(2020, Calendar.MAY, 15);


        Employee1 employee = new Employee1();
        employee.setFirstName("Jakub");
        employee.setLastName("Nowak");
        employee.setDateOfBirth(dateOfBirth);
        employee.setEmploymentDate(employmentDate);
        employee.setSalary(BigDecimal.valueOf(6000));

        boolean result = employee.matches(
                "Jak",
                "Now",
                dateOfBirthFrom,
                dateOfBirthTo,
                employmentDateFrom,
                employmentDateTo,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(7000));

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


        Employee1 employee = new Employee1();
        employee.setFirstName("Jakub");
        employee.setLastName("Nowak");
        employee.setDateOfBirth(dateOfBirth);
        employee.setEmploymentDate(employmentDate);
        employee.setSalary(BigDecimal.valueOf(6000));

        boolean result = employee.matches(
                "Jakub",
                "Nowak",
                dateOfBirthFrom,
                dateOfBirthTo,
                true,
                employmentDateFrom,
                employmentDateTo,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(7000));

        Assert.assertTrue(result);
    }


}
