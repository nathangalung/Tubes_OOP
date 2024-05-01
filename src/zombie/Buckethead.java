package zombie;

public class Buckethead extends Zombie {
    private boolean is_bucket;

    public Buckethead(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name, health, attack_damage, attack_speed, is_aquatic);
        this.is_bucket = true;
    }

    public boolean getIsBucket() {
        return this.is_bucket;
    }

    public void setIsBucket(boolean is_cone) {
        this.is_bucket = false;
    }
}