package zombiest;

public class PoleVaulting extends Zombie {
    private boolean is_jump;

    public PoleVaulting(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super("Pole Vaulting Zombie", 175, 100, 1, false);
        this.is_jump = true;
    }

    public boolean getJump() {
        return this.is_jump;
    }

    public void setJump(boolean is_jump) {
        this.is_jump = false;
    }
}
