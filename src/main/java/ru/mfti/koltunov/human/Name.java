package ru.mfti.koltunov.human;

import java.util.Objects;

public class Name {
    //Фамилия
    private String lastName;
    //Имя
    private String firstName;
    //Отчество
    private String surname;


    public  Name(Name name) {
        this(name.getFirstName(), name.getLastName(), name.getSurname());
    }

    public Name(String lastName, String firstName, String surname) {
        if ((firstName == null || firstName.isBlank())
                && (lastName == null || lastName.isBlank())
                && (surname == null || surname.isBlank())) {
            throw new IllegalArgumentException("Хотя бы одно имя должно быть заполненным");
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, "");
    }

    public Name(String firstName) {
        this("", firstName, "");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        String result = "";

        if (!Objects.equals(lastName, null)) {
            result = result + lastName;
        }
        if (!Objects.equals(firstName, null) && !result.equals("")) {
            result = result + " " + firstName;
        } else if (!Objects.equals(firstName, null)){
            result = result + firstName;
        }
        if (!Objects.equals(surname, null) && !result.equals("")) {
            result = result + " " + surname;
        } else if (!Objects.equals(surname, null)){
            result = result + surname;
        }
        return result;
    }
}
    
