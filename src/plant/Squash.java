package plant;

public class Squash extends Plant {
    private boolean is_instantKill;

    public Squash(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(name, cost, health, attack_damage, attack_speed, range, cooldown);
        this.is_instantKill = true;
    }   

    public boolean getInstantKill() {
        return this.is_instantKill;
    }

    public void setInstantKill(boolean is_instantKill) {
        this.is_instantKill = false;
    }
}