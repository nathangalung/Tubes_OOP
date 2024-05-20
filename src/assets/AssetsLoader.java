package src.assets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.io.IOException;
import java.io.File;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import src.entities.sim.Sim;
import src.mains.Consts;

public class AssetsLoader {
    private static BufferedImage scaleImage(BufferedImage image, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(Consts.SCALED_TILE * width, Consts.SCALED_TILE * height, image.getType());
        Graphics2D g = scaledImage.createGraphics();

        g.drawImage(image, 0, 0, Consts.SCALED_TILE * width, Consts.SCALED_TILE * height, null);
        g.dispose();
        return scaledImage;
    }

    public static BufferedImage readImage(String folder, String fileName, int width, int height, boolean scaled) {
        BufferedImage image = null;
        File file = new File("./src/assets/" + folder + "/" + fileName);

        try {
            String extension = getFileExtension(file);
            if ("gif".equalsIgnoreCase(extension)) {
                image = readGif(file);
            } else {
                image = ImageIO.read(file);
            }

            if (scaled && image != null) {
                image = scaleImage(image, width, height);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public static BufferedImage readGif(File file) {
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        BufferedImage image = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        imageIcon.paintIcon(null, g, 0, 0);
        g.dispose();
        return image;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public static BufferedImage[] loadImageMainMenu() {
        BufferedImage[] images = new BufferedImage[5];

        images[0] = readImage("panels/mainMenuPanel", "Background", 1, 1, false);
        images[1] = readImage("panels/mainMenuPanel", "Title", 1, 1, false);
        images[2] = readImage("panels/mainMenuPanel", "StartGame", 1, 1, false);
        images[3] = readImage("panels/mainMenuPanel", "LoadGame", 1, 1, false);
        images[4] = readImage("panels/mainMenuPanel", "PlantsList", 1, 1, false);
        images[5] = readImage("panels/mainMenuPanel", "ZombiesList", 1, 1, false);
        // images[6] = readImage("panels/main_menu_panel", "Help", 1, 1, false);
        // images[7] = readImage("panels/main_menu_panel", "Exit", 1, 1, false);
        // images[8] = readImage("panels/main_menu_panel", "StartGameHighlight", 1, 1, false);
        // images[9] = readImage("panels/main_menu_panel", "LoadGameHighlight", 1, 1, false);
        // images[10] = readImage("panels/main_menu_panel", "PlantsListHighlight", 1, 1, false);
        // images[11] = readImage("panels/main_menu_panel", "ZombiesListHighlight", 1, 1, false);
        // images[12] = readImage("panels/main_menu_panel", "HelpHighlight", 1, 1, false);
        // images[13] = readImage("panels/main_menu_panel", "ExitHighlight", 1, 1, false);

        return images;
    }

    public static void loadGifMainMenu(Map<String, List<Image>> gifFramesMap, Map<String, Integer> indexFramesMap, List<Image>[] gifFrames, int[] indexFrames) throws IOException {
        gifFrames = new List[3];
        indexFrames = new int[3];

        readGif(gifFramesMap, indexFramesMap, "././src/assets/panels/main_menu_panel/Sun.gif");
        gifFrames[0] = gifFramesMap.get("././src/assets/panels/main_menu_panel/Sun.gif");
        indexFrames[0] = indexFramesMap.get("././src/assets/panels/main_menu_panel/Sun.gif");

        readGif(gifFramesMap, indexFramesMap, "././src/assets/panels/main_menu_panel/Swim.gif");
        gifFrames[1] = gifFramesMap.get("././src/assets/panels/main_menu_panel/Swim.gif");
        indexFrames[1] = indexFramesMap.get("././src/assets/panels/main_menu_panel/Swim.gif");

        readGif(gifFramesMap, indexFramesMap, "././src/assets/panels/main_menu_panel/Walk.gif");
        gifFrames[2] = gifFramesMap.get("././src/assets/panels/main_menu_panel/Walk.gif");
        indexFrames[2] = indexFramesMap.get("././src/assets/panels/main_menu_panel/Walk.gif");
    }

    public static BufferedImage[] loadListPlantsMenu() {
        BufferedImage[] images = new BufferedImage[15];

        images[0] = readImage("panels/about_panel", "page_1", 1, 1, false);
        images[1] = readImage("panels/about_panel", "page_2", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadListZombiesMenu() {
        BufferedImage[] images = new BufferedImage[15];

        images[0] = readImage("panels/about_panel", "page_1", 1, 1, false);
        images[1] = readImage("panels/about_panel", "page_2", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadHelpMenu() {
        BufferedImage[] images = new BufferedImage[2];

        images[0] = readImage("panels/about_panel", "page_1", 1, 1, false);
        images[1] = readImage("panels/about_panel", "page_2", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadInventoryMenu() {
        BufferedImage[] images = new BufferedImage[15];

        images[0] = readImage("panels/main_menu_panel", "background", 1280, 720, true);
        images[1] = readImage("panels/main_menu_panel", "exit_button", 1, 1, false);
        images[2] = readImage("panels/main_menu_panel", "start_highlight", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadInventoryCard() {
        BufferedImage[] images = new BufferedImage[10];

        images[0] = readImage("entities/items/inventory", "Sunflower", 1, 1, false);
        images[1] = readImage("entities/items/inventory", "Peashooter", 1, 1, false);
        images[2] = readImage("entities/items/inventory", "WallNut", 1, 1, false);
        images[3] = readImage("entities/items/inventory", "SnowPea", 1, 1, false);
        images[4] = readImage("entities/items/inventory", "Squash", 1, 1, false);
        images[5] = readImage("entities/items/inventory", "LilyPad", 1, 1, false);
        images[6] = readImage("entities/items/inventory", "TangleKelp", 1, 1, false);
        images[7] = readImage("entities/items/inventory", "Cactus", 1, 1, false);
        images[8] = readImage("entities/items/inventory", "CherryBomb", 1, 1, false);
        images[9] = readImage("entities/items/inventory", "Jalapeno", 1, 1, false);
        images[10] = readImage("entities/items/inventory", "PotatoMine", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadMap() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadDeck() {
        BufferedImage[] images = new BufferedImage[6];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadPlants() {
        BufferedImage[] images = new BufferedImage[6];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadZombies() {
        BufferedImage[] images = new BufferedImage[10];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadPauseMenu() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadSunTab() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static BufferedImage[] loadWaveTab() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static Color setColor(int selectedColor) {
        Color color = null;
        if (selectedColor == 0) color = Color.YELLOW;
        if (selectedColor == 1) color = Color.ORANGE;
        if (selectedColor == 2) color = Color.RED; // red color
        if (selectedColor == 3) color = Color.MAGENTA;
        if (selectedColor == 4) color = Color.PINK;
        if (selectedColor == 5) color = Color.BLUE;
        if (selectedColor == 6) color = Color.CYAN;
        if (selectedColor == 7) color = Color.GREEN; // green color

        return color;
    }
}