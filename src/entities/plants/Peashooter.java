package entities.plants;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Peashooter extends Plant {
    private boolean isReadyToAttack;
    private ScheduledExecutorService scheduler;

    public Peashooter(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super("Peashooter", 100, 100, 25, 4, -1, 10);
        this.isReadyToAttack = true; // set awal ready to attack
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    } 
}
