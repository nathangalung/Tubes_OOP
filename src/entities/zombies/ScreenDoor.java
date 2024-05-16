package src.entities.zombies;

public class ScreenDoor extends Zombie {
    public ScreenDoor(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(0, 0, 1, 1, 7, "Screen Door Zombie", health, attack_damage, attack_speed, is_aquatic);
    }
}
