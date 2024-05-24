package src.entities.zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;

public class Normal extends Zombie {
    private ImageIcon[] gifs;
    
    public Normal(int x, int y) {
        super(x, y, 1, 1, 10, -1, false,100 , 1, 125);
        this.setGif(GifLoader.loadNormal());
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }

    // public void draw(Graphics g2){
    //     g2.drawImage(getImg(), getX(), getY(), null);
    // }

    // @Override
    // public void loadImage() {
    //     // TODO Auto-generated method stub
    //     super.loadImage();
    // }
}
