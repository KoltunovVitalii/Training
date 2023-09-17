package ru.mfti.koltunov.weapon;

import ru.mfti.koltunov.weapon.Weapon;

public class Shooter {
    private String name;
    Weapon weapon;

    public Shooter(String name) {
        setName(name);
    }

    public Shooter(String name, Weapon weapon) {
        this(name);
        setWeapon(weapon);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shot() {
        if (this.weapon != null) {
            weapon.shot();
        } else {
            System.out.println("Не могу участвовать в перестрелке");
        }
    }
}
