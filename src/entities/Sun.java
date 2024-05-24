package src.entities;


import javax.swing.ImageIcon;

import src.mains.times.GameTime;

public class Sun extends Entity implements Item {
    private static int x = (int) (Math.random() * (910 - 160 + 1)) + 160;
    private static int speed = 5;
    public static int sum = 50;

    private ImageIcon[] gifs;

    public Sun() {
        super(x, 0, 1, 1, speed, 2);
    }


    public int getX() {
        return x;
    }

    public ImageIcon[] getGif() {
        return gifs;
    }

    public void setGif(ImageIcon[] gifs) {
        this.gifs = gifs;
    }
}
