package zombies;

import zombiest.Zombie;

public class Buckethead extends Zombie {
    private boolean isBucket;

    public Buckethead(String name, int health, int attack_damage, int attack_speed, boolean isAquatic) {
        super(0, 0, 1, 1, 3, "Buckethead Zombie", 300, 100, 1, false);
        this.isBucket = true;
    }

    public boolean getIsBucket() {
        return this.isBucket;
    }

    public void setIsBucket(boolean is_cone) {
        this.isBucket = false;
    }
}