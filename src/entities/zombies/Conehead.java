package zombies;

import zombiest.Zombie;

public class Conehead extends Zombie {
    private boolean isCone;

    public Conehead(String name, int health, int attack_damage, int attack_speed, boolean isAquatic) {
        super(0, 0, 1, 1, 1, "Conehead Zombie", 250, 100, 1, false);
        this.isCone = true;
    }

    public boolean getCone() {
        return this.isCone;
    }

    public void setCone(boolean isCone) {
        this.isCone = false;
    }
}
