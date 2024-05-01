package plant;

public class SnowPea extends Plant {
    protected boolean is_slow = true;

    public SnowPea(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(name, cost, health, attack_damage, attack_speed, range, cooldown);
    }

    public boolean getSlow() {
        return this.is_slow;
    }
}