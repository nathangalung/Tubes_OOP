package entities.zombies;

public class Conehead extends Zombie {
    private boolean is_cone;

    public Conehead(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super("Conehead Zombie", 250, 100, 1, false);
        this.is_cone = true;
    }

    public boolean getCone() {
        return this.is_cone;
    }

    public void setCone(boolean is_cone) {
        this.is_cone = false;
    }
}
