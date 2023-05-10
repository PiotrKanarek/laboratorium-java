package pl.wit.lab4.p1;

public enum EnPersonType {

    student("studnet"), teacher("nauczyciel");

    String personType;

    EnPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }
}

