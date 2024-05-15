package maps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TileManager {
    public Tile Grass, Water, Home, Spawn, Deck;
    public BufferedImage tileImg;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager(){

    }

    public void loadTile(){

    }

    public void createTile(){
        tiles.add(Grass = new Tile(setImage("../res/grass.png")));
        tiles.add(Water = new Tile(setImage("../res/water.png")));
        tiles.add(Home = new Tile(setImage(null)));
        tiles.add(Spawn = new Tile(setImage(null)));
        tiles.add(Deck = new Tile(setImage(null)));
    }

    public BufferedImage setImage(String path) {
        File file = new File(path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
