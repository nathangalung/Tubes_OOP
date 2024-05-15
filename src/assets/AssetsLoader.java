package assets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import java.io.IOException;
import java.io.File;

import java.util.List;
import java.util.ArrayList;

import src.entities.sim.Sim;
import src.main.Consts;

public class AssetsLoader {
    private static BufferedImage scaleImage(BufferedImage image, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(Consts.SCALED_TILE * width, Consts.SCALED_TILE * height, image.getType());
        Graphics2D g = scaledImage.createGraphics();

        g.drawImage(image, 0, 0, Consts.SCALED_TILE * width, Consts.SCALED_TILE * height, null);
        g.dispose();
        return scaledImage;
    }

    public static BufferedImage readImage(String folder, String fileName, int width, int height, boolean scaled) {
        BufferedImage image;

        try {
            image = ImageIO.read(new File("./src/assets/" + folder + "/" + fileName + ".png"));
            if (scaled) {
                image = scaleImage(image, width, height);
            }
            return image;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<BufferedImage> readGif(String folder, String fileName, int width, int height, boolean scaled) {
        try {
            ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
            ImageInputStream stream = ImageIO.createImageInputStream(new File("./src/assets/" + folder + "/" + fileName + ".gif"));
            reader.setInput(stream);

            int count = reader.getNumImages(true);
            List<BufferedImage> images = new ArrayList<>(count);

            for (int i = 0; i < count; i++) {
                BufferedImage image = reader.read(i);
                if (scaled) {
                    image = scaleImage(image, width, height);
                    images.add(image);
                }
            }

            return images;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static BufferedImage rotate90Clockwise(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage rotated = new BufferedImage(height, width, image.getType());
    
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                rotated.setRGB(height - 1 - y, x, image.getRGB(x, y));
            }
        }
        return rotated;
    }

    public static BufferedImage flipHorizontally(BufferedImage image) {
        AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
        transform.translate(-image.getWidth(null), 0);
        AffineTransformOp operation = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return operation.filter(image, null);
    }

    public static BufferedImage[] loadMainMenu() {
        BufferedImage[] images = new BufferedImage[15];

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

    public static BufferedImage[] loadInventory() {
        BufferedImage[] images = new BufferedImage[15];

        images[0] = readImage("menus/world_menu", "sim_preview_box", 1, 1, false);
        images[1] = readImage("menus/world_menu", "house_info_box", 1, 1, false);
        images[2] = readImage("menus/world_menu", "help_box", 1, 1, false);
        images[3] = readImage("menus/world_menu", "world_help", 1, 1, false);

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

    public static BufferedImage simColorSelector(int selectedColor) {
        BufferedImage newImage = readImage("entities/sim", "sim_down", 1, 1, false);
        Color oldShirtColor = new Color(215, 0, 20); // red color
        Color newShirtColor = setColor(selectedColor);

        float[] oldShirtColorHsb = new float[3];
        float[] newShirtColorHsb = new float[3];
        float hueDiff;

        Color.RGBtoHSB(oldShirtColor.getRed(), oldShirtColor.getGreen(), oldShirtColor.getBlue(), oldShirtColorHsb);
        Color.RGBtoHSB(newShirtColor.getRed(), newShirtColor.getGreen(), newShirtColor.getBlue(), newShirtColorHsb);
    
        // to change the shirt color
        for (int x = 0; x < newImage.getWidth(); x++) {
            for (int y = 0; y < newImage.getHeight(); y++) {
                int rgb = newImage.getRGB(x, y);
                if ((rgb >> 24) == 0x00) continue; // if pixel is transparent, skip color transformation

                Color pixelColor = new Color(rgb);
    
                // Check if the pixel color is within the range of hues
                float[] pixelHsb = new float[3];
                Color.RGBtoHSB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelHsb);
                hueDiff = Math.abs(pixelHsb[0] - oldShirtColorHsb[0]);

                if (hueDiff <= 0.1 || hueDiff >= 0.9) {
                    // Keep the saturation and brightness values of the pixel, but change its hue to the new hue
                    newShirtColorHsb[1] = pixelHsb[1]; // keep saturation value
                    newShirtColorHsb[2] = pixelHsb[2]; // keep brightness value
                    Color newPixelColor = new Color(Color.HSBtoRGB(newShirtColorHsb[0], newShirtColorHsb[1], newShirtColorHsb[2]));
    
                    newImage.setRGB(x, y, newPixelColor.getRGB());
                }
            }
        }
        return newImage;
    }

    public static BufferedImage changeSimColor(BufferedImage simImage, Sim sim) {
        Color oldShirtColor = new Color(215, 0, 20); // red color
        Color newShirtColor = sim.getShirtColor();

        float[] oldShirtColorHsb = new float[3];
        float[] newShirtColorHsb = new float[3];
        float hueDiff;

        Color.RGBtoHSB(oldShirtColor.getRed(), oldShirtColor.getGreen(), oldShirtColor.getBlue(), oldShirtColorHsb);
        Color.RGBtoHSB(newShirtColor.getRed(), newShirtColor.getGreen(), newShirtColor.getBlue(), newShirtColorHsb);
    
        // to change the shirt color
        for (int x = 0; x < simImage.getWidth(); x++) {
            for (int y = 0; y < simImage.getHeight(); y++) {
                int rgb = simImage.getRGB(x, y);
                if ((rgb >> 24) == 0x00) continue; // if pixel is transparent, skip color transformation

                Color pixelColor = new Color(rgb);
    
                // Check if the pixel color is within the range of hues
                float[] pixelHsb = new float[3];
                Color.RGBtoHSB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelHsb);
                hueDiff = Math.abs(pixelHsb[0] - oldShirtColorHsb[0]);

                if (hueDiff <= 0.05 || hueDiff >= 0.95) {
                    // Keep the saturation and brightness values of the pixel, but change its hue to the new hue
                    newShirtColorHsb[1] = pixelHsb[1]; // keep saturation value
                    newShirtColorHsb[2] = pixelHsb[2]; // keep brightness value
                    Color newPixelColor = new Color(Color.HSBtoRGB(newShirtColorHsb[0], newShirtColorHsb[1], newShirtColorHsb[2]));
    
                    simImage.setRGB(x, y, newPixelColor.getRGB());
                }
            }
        }
        return simImage;
    }

    public static BufferedImage showSimPreview(Sim sim) {
        BufferedImage newImage = readImage("entities/sim", "sim_down", 1, 1, false);

        newImage = changeSimColor(newImage, sim);

        return newImage;
    }
}