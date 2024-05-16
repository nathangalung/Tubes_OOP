package src.entities.zombies;

public class Newspaper extends Zombie {
    public Newspaper(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(0, 0, 1, 1, 9, "Newspaper Zombie", health, attack_damage, attack_speed, is_aquatic);
    }
}
