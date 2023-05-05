package pl.wit.lab3.p1;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

/**
 * Klasa pochodna przechowująca dane Programisty
 *
 * @author Łukasz
 */
public class Programmer1 extends Employee1 {
    //Mapa znanych języków z oceną umiejęstności
    private Map<String, Short> mapProgrammingLanguages = null;

    public Programmer1(String firstName, String lastName, Date dateOfBirth, Date employmentDate, BigDecimal sallary) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setEmploymentDate(employmentDate);
        setSalary(sallary);
        this.mapProgrammingLanguages = new HashMap<String, Short>();
    }

    /**
     * Metoda dodająca kolejny język
     *
     * @param language
     */
    public void addProgrammingLanguage(String language, Short mark) {
        if (mark != null && mark.compareTo((short) 0) > 0 && mark.compareTo((short) 6) <= 0)
            mapProgrammingLanguages.put(language, mark);
    }

    /**
     * Metoda zwraqcająca posortowaną tablice języków obcych
     *
     * @return
     */
    public String getProgrammingLanguageInfo(String language) {
        if (!mapProgrammingLanguages.containsKey(language)) {
            Locale locale = new Locale("pl", "PL");
            ResourceBundle exampleBundle = ResourceBundle.getBundle("resources", locale);
            String textPattern = exampleBundle.getString("no_programming.languages");
            return MessageFormat.format(textPattern, language);

        } else {
            String result = language.concat(" ").concat(mapProgrammingLanguages.get(language).toString());
            return result;
        }
    }

    public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Date employmentFrom, Date employmentTo, BigDecimal salaryFrom, BigDecimal salaryTo, Map<String, Short> mapProgrammingLanguages) {
        boolean match = false;
        boolean mapProgrammingLanguagesMatches = false;
        Short value;

        if (mapProgrammingLanguages != null) {
            for (String language : mapProgrammingLanguages.keySet()) {
                if (getProgrammingLanguageInfo(language).length() <= 3) {
                    value = Short.valueOf(getProgrammingLanguageInfo(language));
                } else {
                    value = -1;
                }

                if (mapProgrammingLanguages.get(language) >= value) {
                    mapProgrammingLanguagesMatches = true;
                } else {
                    mapProgrammingLanguagesMatches = false;
                }
            }
        }

        if (super.matches(firstName, lastName, birthFrom, birthTo, employmentFrom, employmentTo, salaryFrom, salaryTo) && mapProgrammingLanguagesMatches) {
            match = true;
        }

        if (super.matches(firstName, lastName, birthFrom, birthTo, employmentFrom, employmentTo, salaryFrom, salaryTo) && mapProgrammingLanguages == null) {
            match = true;
        }

        return match;
    }

    public boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, boolean strict, Date employmentFrom, Date employmentTo, BigDecimal salaryFrom, BigDecimal salaryTo, Map<String, Short> mapProgrammingLanguages) {
        boolean match = false;
        boolean mapProgrammingLanguagesMatches = false;
        Short value;

        if (mapProgrammingLanguages != null) {
            for (String language : mapProgrammingLanguages.keySet()) {
                if (getProgrammingLanguageInfo(language).length() <= 3) {
                    value = Short.valueOf(getProgrammingLanguageInfo(language));
                } else {
                    value = -1;
                }

                if (mapProgrammingLanguages.get(language) >= value) {
                    mapProgrammingLanguagesMatches = true;
                } else {
                    mapProgrammingLanguagesMatches = false;
                }
            }
        }

        if (super.matches(firstName, lastName, birthFrom, birthTo, strict, employmentFrom, employmentTo, salaryFrom, salaryTo) && mapProgrammingLanguagesMatches) {
            match = true;
        }

        if (super.matches(firstName, lastName, birthFrom, birthTo, strict, employmentFrom, employmentTo, salaryFrom, salaryTo) && mapProgrammingLanguages == null) {
            match = true;
        }

        return match;
    }
}
