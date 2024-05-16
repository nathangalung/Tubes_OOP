package plants;

public class Squash extends Plant {
    private boolean is_squash;

    public Squash(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(0, 0, 1, 1, 4, "Squash", 50, 100, 5000, 1, 1, 20);
        is_squash = false;
    }

    public boolean getSquash() {
        return this.is_squash;
    }

    public void setSquash(boolean is_squash) {
        this.is_squash = true;
    }
}