package plant;

public class Squash extends Plant {
    private boolean is_instantKill = false;

    public Squash(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(name, cost, health, attack_damage, attack_speed, range, cooldown);
    }   

    public boolean getIsInstantKill() {
        return is_instantKill;
    }
}
