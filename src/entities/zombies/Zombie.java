package src.entities.zombies;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics2D;

import src.assets.ImageLoader;
import src.entities.Entity;
import src.entities.handlers.CollisionHandler;
import src.entities.handlers.InteractionHandler;
import src.entities.plants.Plant;
import src.items.Item;
import src.mains.Consts;
import src.maps.Map;

// Parent class Zombie
public abstract class Zombie extends Entity implements Item {
    // Attributes
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private boolean isAquatic;

    // Supporting Attributes
    private int speed;
    private boolean isMoving;
    private boolean isAttacking;
    protected boolean occupied;
    private Rectangle bounds;
    private List<Zombie> zombiesList = new ArrayList<Zombie>();

    // Attributes to indentify tiles map easier
    private Map currentMap;

    private BufferedImage[] images = new BufferedImage[10];

    // Collision and interactions
    private CollisionHandler collisionHandler;
    private InteractionHandler interactionHandler;

    public Zombie(int x, int y, int width, int height, int index, String name, int health, int attackDamage, int attackSpeed, boolean isAquatic) {
        super(x, y, width, height, 3);
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
        this.speed = 10;
        this.isMoving = true;
        this.isAttacking = false;
        this.bounds = new Rectangle(x, y, width, height);


        images = ImageLoader.loadZombies();
        interactionHandler = new InteractionHandler(this, currentMap);
        collisionHandler = new CollisionHandler(this, currentMap);
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

    public int getSpeed() {
        return this.speed;
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public boolean isAttacking() {
        return this.isAttacking;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public List<Zombie> getZombiesList() {
        return this.zombiesList;
    }

    public Map getCurrentMap() {
        return this.currentMap;
    }

    public InteractionHandler getInteractionHandler() {
        return this.interactionHandler;
    }

    public CollisionHandler getCollisionHandler() {
        return this.collisionHandler;
    }

    // SETTERS
    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setIsMoving() {
        this.isMoving = !this.isMoving;
    }

    public void setIsAttacking() {
        this.isAttacking = !this.isAttacking;
    }
    
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds.setLocation(getX(), getY());
    }

    public void setCurrentMap(Map map) {
        this.currentMap = map;
        this.currentMap.addZombie(this);
        collisionHandler = new CollisionHandler(this, map);
        interactionHandler = new InteractionHandler(this, map);
    }

    public void setBounds() {
        this.bounds.setLocation(getX(), getY());
    }

    public void update() {
        if (health <= 0) {
            currentMap.removeZombie(this);
            zombiesList.remove(this);
        }
        
        if (isAttacking()) {
            attack(collisionHandler, interactionHandler);
        }

        if (isMoving()) {
            move(collisionHandler, interactionHandler);
        }
    }

    public void move(CollisionHandler collisionHandler, InteractionHandler interactionHandler) {
        if (collisionHandler.checkCollision()) {
            setX(getX() - speed);
        } else {
            setX(getX() - speed);
        }
    }

    public void attack(CollisionHandler collisionHandler, InteractionHandler interactionHandler) {
        if (collisionHandler.checkCollision()) {
            Plant plant = interactionHandler.getPlant();
            plant.setHealth(plant.getHealth() - attackDamage);
        }
    }

    public abstract BufferedImage getIcon();
    public abstract BufferedImage getImage();
    public abstract void interact(Zombie zombie);

    public <T extends Zombie> void draw(Graphics2D g, T zombie) {
        BufferedImage image = getImage();
        if (image != null) {
            g.drawImage(image, getX(), getY(), null);
        }
    }

    // Only For Debugging
    public void drawCollisionBox(Graphics2D g) {
        g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
        g.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    public void drawInteractionRange(Graphics2D g) {
        // Draw the interaction range as a yellow rectangle
        g.setColor(new Color(255, 255, 0, 128)); // Transparent yellow color
        g.fillRect(interactionHandler.getX(), interactionHandler.getY(), interactionHandler.getWidth(), interactionHandler.getHeight());
    }
}
