package plants;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Peashooter extends Plant {
    private boolean isReadyToAttack;
    private ScheduledExecutorService scheduler;

    public Peashooter(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(0, 0, 1, 1, 1, "Peashooter", 100, 100, 25, 4, -1, 10);
        this.isReadyToAttack = true; // set awal ready to attack
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    } 

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attack_damage;
    }
    
    public int getAttackSpeed() {
        return attack_speed;
    }
    
    public int getRange() {
        return range;
    }

    public int getCooldown() {
        return cooldown;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    
    public boolean isReadyToAttack() {
        return isReadyToAttack;
    }
}
