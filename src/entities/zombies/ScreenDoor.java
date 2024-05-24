package src.entities.zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;

public class ScreenDoor extends Zombie {
    private boolean isShield = true;
    private ImageIcon[] gifs;

    public ScreenDoor(int x, int y) {
        super(x, y, 1, 1, 10, -1,false, 1500, 0, 300 );
        this.setGif(GifLoader.loadScreenDoor());

    }

    public void setShield(){
        isShield = false;
    }

    public boolean getShield(){
        return isShield;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }

}

