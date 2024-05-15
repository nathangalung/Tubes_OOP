package entities.zombies.zombies;

public class DolphinRider extends Zombie {
    protected boolean is_pool = false;
    private boolean is_jump;
    
    public DolphinRider(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super("Dolphin Rider Zombie", 175, 100, 1, true);
        is_jump = false;
    }

    public boolean getPool(boolean is_pool) {
        return this.is_pool;
    }

    public void setPool(boolean is_pool) {
        this.is_pool = !is_pool;
    }

    public boolean getJump() {
        return this.is_jump;
    }

    public void setJump(boolean is_jump) {
        this.is_jump = true;
    }
}
