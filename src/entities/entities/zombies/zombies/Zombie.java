package entities.zombies.zombies;

import entities.Entity;

// Parent class Zombie
public class Zombie extends Entity {
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private boolean isAquatic;

    public Zombie(String name, int health, int attackDamage, int attackSpeed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public boolean isAquatic() {
        return isAquatic;
    }
}
