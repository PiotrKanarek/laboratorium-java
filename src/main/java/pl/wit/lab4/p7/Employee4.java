package pl.wit.lab4.p7;

import java.math.BigDecimal;
import java.util.Date;


public class Employee4 extends Person4 {
    // Data zatrudnienia
    private Date employmentDate = null;
    // Wyngrodzenie
    private BigDecimal sallary = null;

    public Employee4(String firstName, String lastName, Date dateOfBirth, Date employmentDate, BigDecimal sallary) {
        super(firstName, lastName, dateOfBirth);
        this.employmentDate = employmentDate;
        this.sallary = sallary;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("employmentDate=").append(employmentDate.toString()).append("\n");
        sb.append("sallary=").append(sallary.toString()).append("\n");
        return sb.toString();
    }

    protected boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Date employmentFrom, Date employmentTo, BigDecimal sallaryFrom, BigDecimal sallaryTo) {
        return super.matches(firstName, lastName, birthFrom, birthTo)
                && matchesEmployment(employmentFrom, employmentTo)
                && matchesSallary(sallaryFrom, sallaryTo);
    }

    protected boolean matches(String firstName, String lastName, Date birthFrom, Date birthTo, Date employmentFrom, Date employmentTo, BigDecimal sallaryFrom, BigDecimal sallaryTo, boolean strict) {
        return super.matches(firstName, lastName, birthFrom, birthTo, strict)
                && matchesEmployment(employmentFrom, employmentTo)
                && matchesSallary(sallaryFrom, sallaryTo);
    }

    private boolean matchesEmployment(Date employmentFrom, Date employmentTo) {
        if (employmentFrom != null) {
            if (this.employmentDate != null) {
                return (this.employmentDate.after(employmentFrom) || this.employmentDate.equals(employmentFrom));
            } else
                return false;
        }
        if (employmentTo != null) {
            if (this.employmentDate != null) {
                return (this.employmentDate.before(employmentTo) || this.employmentDate.equals(employmentTo));
            } else
                return false;
        }

        return true;
    }

    private boolean matchesSallary(BigDecimal sallaryFrom, BigDecimal sallaryTo) {
        if (sallaryFrom != null) {
            if (this.sallary != null) {
                return (this.sallary.compareTo(sallaryFrom) <= 0);
            } else
                return false;
        }
        if (sallaryTo != null) {
            if (this.sallary != null) {
                return (this.sallary.compareTo(sallaryTo) >= 0);
            } else
                return false;
        }

        return true;
    }
    ////////////////////////////////////////
    // getters and setters
    ////////////////////////////////////////

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public BigDecimal getSallary() {
        return sallary;
    }
}