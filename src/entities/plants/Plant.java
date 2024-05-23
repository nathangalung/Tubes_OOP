// package src.entities.plants;

// import java.awt.Rectangle;
// import java.awt.image.BufferedImage;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// import src.entities.handlers.InteractionHandler;
// import src.entities.handlers.CollisionHandler;

// import java.awt.Color;
// import java.awt.Graphics2D;

// import src.assets.ImageLoader;
// import src.entities.Entity;
// import src.items.Item;
// import src.entities.zombies.Zombie;


// // Parent class plant
// public abstract class Plant extends Entity implements Item {
//     // Attributes
//     private String name;
//     private int cost;
//     private int health;
//     private int attackDamage;
//     private int attackSpeed;
//     private int range;
//     private int cooldown;

//     // Supporting Attributes
//     private boolean isCooldown;
//     private boolean isAttack;
//     protected boolean occupied;
//     private Rectangle bounds;
//     private List<Plant> plantsList = new ArrayList<Plant>();

//     // Attributes to indentify tiles map easier
//     private Map currentTiles;

//     private BufferedImage[] images = new BufferedImage[10];

//     // Collision and interactions
//     private CollisionHandler collisionHandler;
//     private InteractionHandler interactionHandler;

//     public Plant(int x, int y, int width, int height, int index, String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown) {
//         super(x, y, width, height, 1);
//         this.name = name;
//         this.cost = cost;
//         this.health = health;
//         this.attackDamage = attackDamage;
//         this.attackSpeed = attackSpeed;
//         this.range = range;
//         this.cooldown = cooldown;
//         this.occupied = false;
//         this.bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());

//         images = ImageLoader.loadPlants();
//         interactionHandler = new InteractionHandler(this, currentTiles);
//         collisionHandler = new CollisionHandler(this, currentTiles);
//     }

//     // GETTERS
//     public String getName() {
//         return this.name;
//     }

//     public int getCost() {
//         return this.cost;
//     }   

//     public int getHealth() {
//         return this.health;
//     }   

//     public int getAttackDamage() {
//         return this.attackDamage;
//     }

//     public int getAttackSpeed() {
//         return this.attackSpeed;
//     }

//     public int getRange() {
//         return this.range;
//     }

//     public int getCooldown() {
//         return this.cooldown;
//     }

//     public boolean isCooldown() {
//         return this.isCooldown;
//     }

//     public boolean isAttacking() {
//         return this.isAttack;
//     }

//     public boolean isOccupied() {
//         return this.occupied;
//     }

//     public Rectangle getBounds() {
//         return this.bounds;
//     }

//     public Map getCurrentTiles() {
//         return this.currentTiles;
//     }

//     public InteractionHandler getInteractionHandler() {
//         return this.interactionHandler;
//     }

//     public CollisionHandler getCollisionHandler() {
//         return this.collisionHandler;
//     }

//     // SETTERS
//     public void setHealth(int health) {
//         this.health = health;
//     }

//     public void setOccupied(boolean occupied) {
//         this.occupied = occupied;
//     }

//     public void setBounds(Rectangle bounds) {
//         this.bounds.setLocation(getX(), getY());
//     }

//     public void setCooldownDuration(int cooldown) {
//         this.cooldown = cooldown;
//     }

//     public void setCurrentTiles(Map currentTiles) {
//         if (currentTiles != null) {
//             this.currentTiles.removePlant(this);
//         }

//         this.currentTiles = currentTiles;
//         this.currentTiles.addPlant(this);
//         collisionHandler = new CollisionHandler(this, currentTiles);
//         interactionHandler.new InteractionHandler(this, currentTiles);
//     }

//     public void updateBounds() {
//         this.bounds.setLocation(getX(), getY());
//     }

//     public void update() {
//         if (health <= 0) {
//             currentTiles.removePlant(this);
//             plantsList.remove(this);
//         }
//         if (isAttacking()) {
//             attack(collisionHandler, interactionHandler, zombie);
//         }
//     }

//     public abstract BufferedImage getIcon();
//     public abstract BufferedImage getImage();
//     public abstract void interact(Zombie zombie);

//     public <T extends Plant> void draw(Graphics2D g, T plant) {
//         if (isAttacking()) g.drawImage(plant.getImage(), plant.getX(), plant.getY(), null);
//         else g.drawImage(plant.getIcon(), plant.getX(), plant.getY(), null);
//     }


//     // Only For Debugging
//     public void drawCollisionBox(Graphics2D g) {
//         g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
//         g.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
//     }


//     public void drawInteractionRange(Graphics2D g) {
//         g.setColor(new Color(255, 255, 0, 64)); // Transparent yellow color
//         g.fillRect(interactionHandler.getX(), interactionHandler.getY(), interactionHandler.getWidth(), interactionHandler.getHeight());
//     }
// }
