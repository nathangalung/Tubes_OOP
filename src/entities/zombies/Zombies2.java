package zombies;

import javax.swing.text.Position;

import entities.Entity2;
import src.mains.panels.GamePanel;
import java.awt.Point;

public class Zombies2 extends Entity2 {
    private Boolean isWalking;
    private Boolean isAquatic;
    private Point position;
    private long lastAttackTime;
    private static int id = 0;
    private int z_id;

    public Zombies2(int x, int y, String name, int health, int attack_damage, int attack_speed, boolean isAquatic){
        super(x, y, name, health, attack_damage, attack_speed);
        this.isAquatic = isAquatic;
        this.isWalking = true;
        this.position = new Point(x,y);
        z_id = this.getID();
        id++;
    }

    public void move(){
        if(!isWalking){
            return;
        }

        int newX = this.position.x - 1;

        this.position.x = newX;
        if(newX == 0){
            stopWalk();
        }
    }

    public void attack(Plant plant){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= this.getAttackS() * 1000) {
            plant.setHealth(plant.getHealth() - this.getAttackD());
            lastAttackTime = currentTime;
            System.out.println(String.format("Plant %s attacked by Zombie %s", plant.getName(), this.getName()));
        }   
    }

    public int getID(){
        return id;
    }

    public void walk(){
        isWalking = true;
    }

    public void stopWalk(){
        isWalking = false;
    }

    public void hurt(int attack_damage){
        super.setHealth(getHealth() - attack_damage);
    }

    public void update(){

    }
}
