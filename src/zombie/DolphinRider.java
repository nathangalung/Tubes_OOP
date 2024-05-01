package zombie;

public class DolphinRider extends Zombie {
    protected boolean is_pool = true;
    private boolean is_jump;
    
    public DolphinRider(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name, health, attack_damage, attack_speed, is_aquatic);
        is_jump = false;
    }

    public boolean getPool(boolean is_pool) {
        return this.is_pool;
    }

    public boolean getJump() {
        return this.is_jump;
    }

    public void setJump(boolean is_jump) {
        this.is_jump = true;
    }
}
