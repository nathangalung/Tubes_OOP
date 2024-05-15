package entities.plants;
// Parent class plant
public abstract class Plant {
    protected String name;
    protected int cost;
    protected int health;
    protected int attack_damage;
    protected int attack_speed;
    protected int range;
    protected int cooldown;

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }   

    public int getHealth() {
        return this.health;
    }   

    public int getAttackDamage() {
        return this.attack_damage;
    }

    public int getAttackSpeed() {
        return this.attack_speed;
    }

    public int getRange() {
        return this.range;
    }

    public int getCooldown() {
        return this.cooldown;
    }
}
