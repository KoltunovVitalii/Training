package ru.mfti.koltunov.human;

import java.util.Objects;

public class Man {
    private Name name;
    private String firstName;
    private Integer height;
    private Man father;

    public Man(String firstName, Integer height) {
        this.firstName = firstName;
        setHeight(height);
    }

    public Man(String firstName, Integer height, Man father) {
        this(firstName, height);
        this.father = father;
    }

    public Man(Name name, Integer height) {
        this.name = name;
        setHeight(height);
    }

    public Man(Name name, Integer height, Man father) {
        this(name, height);
        this.father = father;
    }

    public Name getName() {
        return name;
    }

    public Man getFather() {
        return father;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        if (height < 0) {
            throw new IllegalArgumentException("Рост не может быть отрицательным");
        }
        if (height > 500) {
            throw new IllegalArgumentException("Рост не может быть > 500");
        }
        else
        this.height = height;
    }

    @Override
    public String toString() {
        String result = "";
        if (name != null) {
            if (father != null) {
                if (Objects.equals(name.getLastName(), "")) {
                    if (!Objects.equals(father.name.getLastName(), "")) {
                        name.setLastName("" + father.name.getLastName());
                    }
                }
                if (Objects.equals(name.getSurname(), "")) {
                    if (!Objects.equals(father.name.getFirstName(), "")) {
                        name.setSurname("" + father.name.getFirstName() + "ович");
                    }
                }
            }
            result = result + "Человек. " + "Имя: " + name;
        }
        if (firstName != null) {
            Name name = new Name("", this.firstName, "");

            if (father != null) {
                if (!Objects.equals(father.name.getLastName(), "")) {
                    name.setLastName(father.name.getLastName());
                }
                if (!Objects.equals(father.name.getFirstName(), "")) {
                    name.setSurname(father.name.getFirstName() + "ович");
                }
            }
            result = result + "Человек. " + "Имя: " + name;
        }

        if (height != null) {
            result = result + " Рост: " + height;
        }

        if (father != null) {
            result = result + " Отец: " + father;
        }
        return result;
    }
}
