package src.entities;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import src.mains.panels.GamePanel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public class Entity2 {
    
    private GamePanel gamePanel;

    public int x, y;
    public String name;
    public int health;
    public int attack_damage;
    public int attack_speed;
    public boolean status = false;

    public Entity2(int x, int y, String name, int health, int attack_damage, int attack_speed){
        this.x = x;
        this.y = y;
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
    }

    
    public String getName(){
        return name;
    }
    
    public int getHealth(){
        return health;
    }

    public int getAttackDamage(){
        return attack_damage;
    }

    public int getAttackSpeed(){
        return attack_speed;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public Boolean getStatus(){
        return status;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setStatus(int health){
        if(health <= 0){
            status = true;
        }
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setAttackD(int attack_damage){
        this.attack_damage = attack_damage;
    }

    public void setAttackS(int attack_speed){
        this.attack_speed = attack_speed;
    }

    public void update(){

    }

    // public void draw(Graphics2D g2){
    //     BufferedImage img = null;

    // }

    // public BufferedImage setImage(String path){
    //     File image = new File(path);
    //     BufferedImage img = null;
    //     try {
    //         img = ImageIO.read(image);
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }
    //     return img;
    // }


}


