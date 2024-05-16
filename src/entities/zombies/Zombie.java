package src.entities.zombies;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics2D;

import src.entities.Entity;
import src.entities.items.Item;
import src.entities.plants.Plant;
import src.mains.Consts;

// Parent class Zombie
public abstract class Zombie extends Entity implements Item {
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private boolean isAquatic;
    protected boolean occupied;
    private Rectangle bounds;
    private int direction = 3;
    private float speed = (float) (Consts.SCALED_TILE / 4.7);
    private List<Zombie> zombies = new ArrayList<Zombie>();

    public Zombie(int x, int y, int width, int height, int index, String name, int health, int attackDamage, int attackSpeed, boolean isAquatic) {
        super(x, y, width, height, 3);
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
    }

    // GETTERS
    public String getName() {
        return this.name;
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

    public boolean isAquatic() {
        return this.isAquatic;
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
