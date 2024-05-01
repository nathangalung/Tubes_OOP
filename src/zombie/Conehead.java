package zombie;

public class Conehead extends Zombie {
    private boolean is_cone;

    public Conehead(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name, health, attack_damage, attack_speed, is_aquatic);
        this.is_cone = true;
    }

    public boolean getCone() {
        return this.is_cone;
    }

    public void setCone(boolean is_cone) {
        this.is_cone = false;
    }
}
