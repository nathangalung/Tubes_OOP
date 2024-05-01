package zombie;

public class DuckyTube extends Zombie {
    protected boolean is_pool = true;

    public DuckyTube(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name,health,attack_damage,attack_speed,is_aquatic);
    }

    public boolean getPool(boolean is_pool) {
        return this.is_pool;
    }
}
