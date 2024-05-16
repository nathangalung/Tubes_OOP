package src.assets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

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
    public static ImageIcon readImage(String folder, String fileName, int width, int height, boolean scaled) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon("././src/assets/" + folder + "/" + fileName + ".png");
            if (scaled) {
                Image image = icon.getImage().getScaledInstance(Consts.SCALED_TILE * width, Consts.SCALED_TILE * height, Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }

    public static Map<String, List<Image>> extractMultipleGifFrames(String filePaths) throws IOException {
        Map<String, List<Image>> gifFramesMap = new HashMap<>();

        List<Image> frames = new ArrayList<>();
        ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
        ImageInputStream stream = ImageIO.createImageInputStream(new File(filePaths));
        reader.setInput(stream);

        int numFrames = reader.getNumImages(true);
        for (int i = 0; i < numFrames; i++) {
            frames.add(reader.read(i));
        }
        gifFramesMap.put(filePaths, frames);

        return gifFramesMap;
    }

    private static void updateGif(Map<String, List<Image>> gifFramesMap, Map<String, Integer> indexFramesMap, String gifPaths) {
        int currentFrame = indexFramesMap.get(gifPaths);
        currentFrame = (currentFrame + 1) % gifFramesMap.get(gifPaths).size();
        indexFramesMap.put(gifPaths, currentFrame);
    }

    public static void readGifFrame(Map<String, List<Image>> gifFramesMap, String gifPaths) throws IOException {
        List<Image> frames = new ArrayList<>();
        ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
        ImageInputStream stream = ImageIO.createImageInputStream(new File(gifPaths));
        reader.setInput(stream);

        int numFrames = reader.getNumImages(true);
        for (int i = 0; i < numFrames; i++) {
            frames.add(reader.read(i));
        }
        gifFramesMap.put(gifPaths, frames);
    }
    
    public static void readGif(Map<String, List<Image>> gifFramesMap, Map<String, Integer> indexFramesMap, String gifPaths) throws IOException {
        List<Image> frames = new ArrayList<>();
        ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
        ImageInputStream stream = ImageIO.createImageInputStream(new File(gifPaths));
        reader.setInput(stream);

        int numFrames = reader.getNumImages(true);
        for (int i = 0; i < numFrames; i++) {
            frames.add(reader.read(i));
        }
        gifFramesMap.put(gifPaths, frames);

        Timer gifTimer;
        try {
            indexFramesMap.put(gifPaths, 0);
            int frameDelay = 100; // Delay in milliseconds for frame update
            gifTimer = new Timer(frameDelay, e -> updateGif(gifFramesMap, indexFramesMap, gifPaths));
            gifTimer.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon[] loadImageMainMenu() {
        ImageIcon[] images = new ImageIcon[14];

        images[0] = readImage("panels/main_menu_panel", "background", 1, 1, false);
        images[1] = readImage("panels/main_menu_panel", "game_title", 1, 1, false);
        images[2] = readImage("panels/main_menu_panel", "start_button", 1, 1, false);
        images[3] = readImage("panels/main_menu_panel", "load_button", 1, 1, false);
        images[4] = readImage("panels/main_menu_panel", "about_button", 1, 1, false);
        images[5] = readImage("panels/main_menu_panel", "exit_button", 1, 1, false);
        images[6] = readImage("panels/main_menu_panel", "exit_button", 1, 1, false);
        images[7] = readImage("panels/main_menu_panel", "exit_button", 1, 1, false);
        images[8] = readImage("panels/main_menu_panel", "start_highlight", 1, 1, false);
        images[9] = readImage("panels/main_menu_panel", "load_highlight_red", 1, 1, false);
        images[10] = readImage("panels/main_menu_panel", "about_highlight", 1, 1, false);
        images[11] = readImage("panels/main_menu_panel", "exit_highlight", 1, 1, false);
        images[12] = readImage("panels/main_menu_panel", "exit_highlight", 1, 1, false);
        images[13] = readImage("panels/main_menu_panel", "exit_highlight", 1, 1, false);

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

    public static ImageIcon[] loadListPlantsMenu() {
        ImageIcon[] images = new ImageIcon[15];

        images[0] = readImage("panels/about_panel", "page_1", 1, 1, false);
        images[1] = readImage("panels/about_panel", "page_2", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadListZombiesMenu() {
        ImageIcon[] images = new ImageIcon[15];

        images[0] = readImage("panels/about_panel", "page_1", 1, 1, false);
        images[1] = readImage("panels/about_panel", "page_2", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadHelpMenu() {
        ImageIcon[] images = new ImageIcon[2];

        images[0] = readImage("panels/about_panel", "page_1", 1, 1, false);
        images[1] = readImage("panels/about_panel", "page_2", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadInventory() {
        ImageIcon[] images = new ImageIcon[15];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadMap() {
        ImageIcon[] images = new ImageIcon[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadDeck() {
        ImageIcon[] images = new ImageIcon[6];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadPlants() {
        ImageIcon[] images = new ImageIcon[6];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadZombies() {
        ImageIcon[] images = new ImageIcon[10];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadPauseMenu() {
        ImageIcon[] images = new ImageIcon[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadSunTab() {
        ImageIcon[] images = new ImageIcon[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

        return images;
    }

    public static ImageIcon[] loadWaveTab() {
        ImageIcon[] images = new ImageIcon[4];

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