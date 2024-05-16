package src.entities.zombies;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

import src.entities.Entity;
import src.entities.Item;
import src.entities.plants.Plant;
import src.mains.Consts;

// Parent class Zombie
public abstract class Zombie extends Entity implements Item {
    private int direction = 1; // 0 = right, 1 = left
    private float speed = (float) (Consts.SCALED_TILE / 4.7);
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private boolean isAquatic;
    protected boolean occupied;
    private Rectangle bounds;

    public Zombie(int x, int y, int width, int height, String name, int health, int attackDamage, int attackSpeed, boolean isAquatic) {
        super(x, y, width, height, (float) (Consts.SCALED_TILE / 4.7), 3);
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
    }

    // GETTERS
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

    public boolean isOccupied() {
        return this.occupied;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    // SETTERS
    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds.setLocation(getX(), getY());
    }

    public <T extends Zombie> void draw(Graphics2D g, T zombie) {
        g.drawImage(zombie.getImage(), zombie.getX(), zombie.getY(), null);
    }

    public abstract BufferedImage getIcon();
    public abstract BufferedImage getImage();
    public abstract void interact(Plant plant);

    // Only For Debugging
    public void drawCollisionBox(Graphics2D g) {
        g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
        g.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
