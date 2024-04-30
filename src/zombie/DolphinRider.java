package zombie;

public class DolphinRider extends Zombie {
    private boolean is_jump;
    public DolphinRider(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name, health, attack_damage, attack_speed, is_aquatic);
        is_jump = false;
    }

    public boolean getIsJump() {
        return is_jump;
    }
}
