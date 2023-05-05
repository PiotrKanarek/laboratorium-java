package pl.wit.lab3.p1;

import java.util.Date;

/**
 * Klasa bazowa przetwarzająca podstawowe dane osobowe
 *
 * @author Łukasz
 */
public class Person1 {
    // Imię
    private String firstName = null;
    // Nazwisko
    private String lastName = null;
    // Data urodzenia
    private Date dateOfBirth = null;

    public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo) {
        boolean match = false;
        boolean firstNameMatches = false;
        boolean lastNameMatches = false;
        boolean birthFromMatches = false;
        boolean birthToMatches = false;

        if (firstName != null && !firstName.isEmpty() && getFirstName().indexOf(firstName) == 0) {
            firstNameMatches = true;
        }

        if (lastName != null && !lastName.isEmpty() && getLastName().indexOf(lastName) == 0) {
            lastNameMatches = true;
        }

        if (birthFrom != null) {
            if (getDateOfBirth().after(birthFrom) || getDateOfBirth().equals(birthFrom)) {
                birthFromMatches = true;
            }
        }

        if (birthTo != null) {
            if (getDateOfBirth().after(birthTo) || getDateOfBirth().equals(birthTo)) {
                birthToMatches = true;
            }
        }

        if (firstNameMatches && lastNameMatches && birthFromMatches && birthToMatches) {
            match = true;
        }

        if (firstName == null && lastName == null && birthFrom == null && birthTo == null) {
            match = true;
        }

        return match;
    }

    public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, boolean strict) {
        boolean match = false;
        boolean firstNameMatches = false;
        boolean lastNameMatches = false;
        boolean birthFromMatches = false;
        boolean birthToMatches = false;

        if (firstName != null && !firstName.isEmpty()) {
            if (strict) {
                firstNameMatches = getFirstName().equals(firstName);
            } else {
                firstNameMatches = getFirstName().indexOf(firstName) == 0;
            }
        }

        if (lastName != null && !lastName.isEmpty()) {
            if (strict) {
                lastNameMatches = getLastName().equals(lastName);
            } else {
                lastNameMatches = getLastName().indexOf(lastName) == 0;
            }
        }

        if (birthFrom != null) {
            if (getDateOfBirth().after(birthFrom) || getDateOfBirth().equals(birthFrom)) {
                birthFromMatches = true;
            }
        }

        if (birthTo != null) {
            if (getDateOfBirth().after(birthTo) || getDateOfBirth().equals(birthTo)) {
                birthToMatches = true;
            }
        }

        if (firstNameMatches && lastNameMatches && birthFromMatches && birthToMatches) {
            match = true;
        }

        if (firstName == null && lastName == null && birthFrom == null && birthTo == null) {
            match = true;
        }

        return match;
    }

    /////////////////////////////////
    // getters and setters
    /////////////////////////////////
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
