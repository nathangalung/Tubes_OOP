package plants;

public class SnowPea extends Plant {
    private  boolean is_readyAttack = true;
    protected boolean is_slow = true;

    public SnowPea(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(0, 0, 1, 1, 3, "Snow Pea", 175, 100, 25, 4, -1, 10);
    }

    public boolean getSlow() {
        return this.is_slow;
    }
}