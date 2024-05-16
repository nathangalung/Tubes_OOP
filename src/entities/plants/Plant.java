package src.entities.plants;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

import src.entities.Entity;
import src.entities.Item;
import src.entities.zombies.Zombie;


// Parent class plant
public abstract class Plant extends Entity implements Item {
    private String name;
    private int cost;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private int range;
    private int cooldown;
    protected boolean occupied;
    private Rectangle bounds;
    private int direction = 1;

    public Plant(int x, int y, int width, int height, int index, String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown) {
        super(x, y, width, height, 1);
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.cooldown = cooldown;
        this.occupied = false;
        this.bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    // GETTERS
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
        return this.attackDamage;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getRange() {
        return this.range;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public int getDirection() {
        return this.direction;
    }

    // SETTERS
    public void setHealth(int health) {
        this.health = health;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds.setLocation(getX(), getY());
    }

    public <T extends Plant> void draw(Graphics2D g, T plant) {
        g.drawImage(plant.getImage(), plant.getX(), plant.getY(), null);
    }

    public abstract BufferedImage getIcon();
    public abstract BufferedImage getImage();
    public abstract void interact(Zombie zombie);


    // Only For Debugging
    public void drawCollisionBox(Graphics2D g) {
        g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
        g.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
