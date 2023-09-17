package ru.mfti.koltunov.weapon;

public class Gun extends Weapon{
//    int countBullets;
    private int maxCountBullets;

    public Gun(int ammo, int maxCountBullets) {
        super(ammo);
//        this.countBullets = countBullets;
        this.maxCountBullets = maxCountBullets;
    }

    @Override
    void shot() {
        System.out.println("БАХ!!");
        getAmmo();
    }

    public int getMaxCountBullets() {
        return maxCountBullets;
    }

//    public int getCountBullets() {
//        return countBullets;
//    }

    public void shot(int countShot) {
        int a = countShot - ammo();
        if (ammo() >= countShot) {
            for (int i = 0; i < countShot; i++) {
                System.out.println("БАХ!");
            }
        }
        else {
            for (int i = 0; i < ammo(); i++) {
                System.out.println("БАХ!");
            }
            for (int i = 0; i < a; i++) {
                System.out.println("Клац!");
            }
        }
    }


    public String recharge(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное число патронов :-)");
        }
        if (x + ammo > maxCountBullets) {
            int y = (maxCountBullets - ammo - x)*(-1);
            ammo = maxCountBullets;
            return "Пистолет заряжен. " + y + " паторонов лишние";
        }
        ammo = ammo + x;
        return "Пистолет заряжен. " + "Патронов в пистолете: " + ammo;
    }

    public String discharge(){
        if (ammo > 0) {
            int res = ammo;
            ammo = 0;
            return "Пистолет разряжен, возвращено паторонов: " + res;
        }
        return "Пистолет не заряжен";
    }

    public String charge() {
        if (ammo > 0) {
            return "Пистолет заряжен, паторонов: " + ammo;
        }
        return "Пистолет не заряжен";
    }
}

