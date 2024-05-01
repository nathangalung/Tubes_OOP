package zombie;

public class PoleVaulting extends Zombie {
    private boolean is_jump;

    public PoleVaulting(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name, health, attack_damage, attack_speed, is_aquatic);
        this.is_jump = true;
    }

    public boolean getJump() {
        return this.is_jump;
    }

    public void setJump(boolean is_jump) {
        this.is_jump = false;
    }
}
