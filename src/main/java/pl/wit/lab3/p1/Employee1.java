package pl.wit.lab3.p1;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Klasa pochodna dla przetwrzania danych pracownika
 *
 * @author Łukasz
 */
public class Employee1 extends Person1 {
    //Data zatrudnienia
    private Date employmentDate = null;
    //Wyngrodzenie
    private BigDecimal salary = null;

    public boolean matches(
            String firstName,
            String lastName,
            Date birthFrom,
            Date birthTo,
            Date employmentFrom,
            Date employmentTo,
            BigDecimal salaryFrom,
            BigDecimal salaryTo) {

        boolean match = false;
        boolean employmentFromMatches = false;
        boolean employmentToMatches = false;
        boolean salaryFromMatches = false;
        boolean salaryToMatches = false;

        if (employmentFrom != null) {
            if (getEmploymentDate().after(employmentFrom) || getEmploymentDate().equals(employmentFrom)) {
                employmentFromMatches = true;
            }
        }

        if (employmentTo != null) {
            if (getEmploymentDate().before(employmentTo) || getEmploymentDate().equals(employmentTo)) {
                employmentToMatches = true;
            }
        }

        if (salaryFrom != null && getSalary().compareTo(salaryFrom) >= 0) {
            salaryFromMatches = true;
        }

        if (salaryTo != null && getSalary().compareTo(salaryTo) <= 0) {
            salaryToMatches = true;
        }

        if (
                super.matches(firstName, lastName, birthFrom, birthTo) &&
                        employmentFromMatches &&
                        employmentToMatches &&
                        salaryFromMatches &&
                        salaryToMatches
        ) {
            match = true;
        }

        if (
                super.matches(firstName, lastName, birthFrom, birthTo) &&
                        employmentFrom == null &&
                        employmentTo == null &&
                        salaryFrom == null &&
                        salaryTo == null
        ) {
            match = true;
        }

        return match;
    }

    public boolean matches(
            String firstName,
            String lastName,
            Date birthFrom,
            Date birthTo,
            boolean strict,
            Date employmentFrom,
            Date employmentTo,
            BigDecimal salaryFrom,
            BigDecimal salaryTo
    ) {

        boolean match = false;
        boolean employmentFromMatches = false;
        boolean employmentToMatches = false;
        boolean salaryFromMatches = false;
        boolean salaryToMatches = false;

        if (employmentFrom != null) {
            if (getEmploymentDate().after(employmentFrom) || getEmploymentDate().equals(employmentFrom)) {
                employmentFromMatches = true;
            }
        }

        if (employmentTo != null) {
            if (getEmploymentDate().before(employmentTo) || getEmploymentDate().equals(employmentTo)) {
                employmentToMatches = true;
            }
        }

        if (salaryFrom != null && getSalary().compareTo(salaryFrom) >= 0) {
            salaryFromMatches = true;
        }

        if (salaryTo != null && getSalary().compareTo(salaryTo) <= 0) {
            salaryToMatches = true;
        }

        if (super.matches(firstName, lastName, birthFrom, birthTo, strict) && employmentFromMatches && employmentToMatches && salaryFromMatches && salaryToMatches) {
            match = true;
        }

        if (super.matches(firstName, lastName, birthFrom, birthTo, strict) && employmentFrom == null && employmentTo == null && salaryFrom == null && salaryTo == null) {
            match = true;
        }

        return match;
    }

    ///////////////////////////////////
    // getters and setters
    ///////////////////////////////////

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
