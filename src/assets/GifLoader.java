package src.assets;

import javax.swing.ImageIcon;

public class GifLoader {
    public static ImageIcon readGif(String folder, String fileName) {
        ImageIcon gif;

        try {
            gif = new ImageIcon("./src/assets/" + folder + "/" + fileName + ".gif");
            return gif;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ImageIcon[] loadPlantsList() {
        ImageIcon[] gifs = new ImageIcon[10];

        gifs[0] = readGif("panels/plantsListPanel/motions", "Sunflower");
        gifs[1] = readGif("panels/plantsListPanel/motions", "Peashooter");
        gifs[2] = readGif("panels/plantsListPanel/motions", "WallNut");
        gifs[3] = readGif("panels/plantsListPanel/motions", "SnowPea");
        gifs[4] = readGif("panels/plantsListPanel/motions", "Squash");
        gifs[5] = readGif("panels/plantsListPanel/motions", "Lilypad");
        gifs[6] = readGif("panels/plantsListPanel/motions", "TangleKelp");
        gifs[7] = readGif("panels/plantsListPanel/motions", "Cactus");
        gifs[8] = readGif("panels/plantsListPanel/motions", "CherryBomb");
        gifs[9] = readGif("panels/plantsListPanel/motions", "Jalapeno");

        return gifs;
    }

    public static ImageIcon[] loadZombiesList() {
        ImageIcon[] gifs = new ImageIcon[10];

        gifs[0] = readGif("panels/zombiesListPanel/motions", "Normal");
        gifs[1] = readGif("panels/zombiesListPanel/motions", "Conehead");
        gifs[2] = readGif("panels/zombiesListPanel/motions", "PoleVaulting");
        gifs[3] = readGif("panels/zombiesListPanel/motions", "Buckethead");
        gifs[4] = readGif("panels/zombiesListPanel/motions", "DuckyTube");
        gifs[5] = readGif("panels/zombiesListPanel/motions", "DolphinRider");
        gifs[6] = readGif("panels/zombiesListPanel/motions", "JackInTheBox");
        gifs[7] = readGif("panels/zombiesListPanel/motions", "ScreenDoor");
        gifs[8] = readGif("panels/zombiesListPanel/motions", "Football");
        gifs[9] = readGif("panels/zombiesListPanel/motions", "Newspaper");

        return gifs;
    }

    public static ImageIcon[] loadSunflower() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/sunflower", "Base");

        return gifs;
    }

    public static ImageIcon[] loadPeashooter() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/peashooter", "Base");

        return gifs;
    }

    public static ImageIcon[] loadWallNut() {
        ImageIcon[] gifs = new ImageIcon[3];
        gifs[0] = readGif("entities/plants/wallnut", "Base1");

        return gifs;
    }

    public static ImageIcon[] loadSnowPea() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/snowpea", "Base");

        return gifs;
    }

    public static ImageIcon[] loadSquash() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/squash", "Base");

        return gifs;
    }

    public static ImageIcon[] loadLilypad() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/lilypad", "Base");

        return gifs;
    }

    public static ImageIcon[] loadTangleKelp() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/tanglekelp", "Base");

        return gifs;
    }

    public static ImageIcon[] loadCactus() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/cactus", "Base");

        return gifs;
    }

    public static ImageIcon[] loadCherryBomb() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/cherrybomb", "Base");

        return gifs;
    }

    public static ImageIcon[] loadJalapeno() {
        ImageIcon[] gifs = new ImageIcon[1];
        gifs[0] = readGif("entities/plants/jalapeno", "Base");

        return gifs;
    }

    
}