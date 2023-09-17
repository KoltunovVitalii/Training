package ru.mfti.koltunov.weapon;

public class MachineGun extends Gun {
    int firingRate;


    public MachineGun(int ammo, int maxCountBullets, int firingRate) {
        super(ammo, maxCountBullets);
        this.firingRate = firingRate;
    }

    public int getFiringRate() {
        return firingRate;
    }

    public void setFiringRate(int firingRate) {
        if (firingRate > 0) {
            this.firingRate = firingRate;
        }
    }

    public void shot(int countShot) {
        super.shot(firingRate);
    }

    public void shotTime(int shotTime) {
        super.shot(firingRate * shotTime);
    }
}
