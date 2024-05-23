package src.assets;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.File;

public class ImageLoader {
    public static BufferedImage readImage(String folder, String fileName) {
        BufferedImage image;

        try {
            image = ImageIO.read(new File("./src/assets/" + folder + "/" + fileName + ".png"));
            return image;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage[] loadMainMenu() {
        BufferedImage[] images = new BufferedImage[14];

        images[0] = readImage("panels/mainMenuPanel", "Background");
        images[1] = readImage("panels/mainMenuPanel", "Title");
        images[2] = readImage("panels/mainMenuPanel", "StartGame");
        images[3] = readImage("panels/mainMenuPanel", "LoadGame");
        images[4] = readImage("panels/mainMenuPanel", "PlantsList");
        images[5] = readImage("panels/mainMenuPanel", "ZombiesList");
        images[6] = readImage("panels/mainMenuPanel", "Help");
        images[7] = readImage("panels/mainMenuPanel", "ExitGame");
        images[8] = readImage("panels/mainMenuPanel", "StartGameHighlight");
        images[9] = readImage("panels/mainMenuPanel", "LoadGameHighlight");
        images[10] = readImage("panels/mainMenuPanel", "PlantsListHighlight");
        images[11] = readImage("panels/mainMenuPanel", "ZombiesListHighlight");
        images[12] = readImage("panels/mainMenuPanel", "HelpHighlight");
        images[13] = readImage("panels/mainMenuPanel", "ExitGameHighlight");

        return images;
    }

    public static BufferedImage[] loadInventory() {
        BufferedImage[] images = new BufferedImage[52];

        images[0] = readImage("panels/inventoryPanel", "Background");
        images[1] = readImage("panels/inventoryPanel", "Border");
        images[2] = readImage("panels/inventoryPanel", "Clear");
        images[3] = readImage("panels/inventoryPanel", "Start");
        images[4] = readImage("panels/inventoryPanel", "Help");
        images[5] = readImage("panels/inventoryPanel", "Menu");
        images[6] = readImage("panels/inventoryPanel", "ClearHighlight");
        images[7] = readImage("panels/inventoryPanel", "StartHighlight");
        images[8] = readImage("panels/inventoryPanel", "HelpHighlight");
        images[9] = readImage("panels/inventoryPanel", "MenuHighlight");
        images[10] = readImage("panels/inventoryPanel", "Empty");
        images[11] = readImage("panels/inventoryPanel", "EmptyHighlight");
        images[12] = readImage("panels/inventoryPanel/cardsColor", "Sunflower");
        images[13] = readImage("panels/inventoryPanel/cardsColor", "Peashooter");
        images[14] = readImage("panels/inventoryPanel/cardsColor", "WallNut");
        images[15] = readImage("panels/inventoryPanel/cardsColor", "SnowPea");
        images[16] = readImage("panels/inventoryPanel/cardsColor", "Squash");
        images[17] = readImage("panels/inventoryPanel/cardsColor", "Lilypad");
        images[18] = readImage("panels/inventoryPanel/cardsColor", "TangleKelp");
        images[19] = readImage("panels/inventoryPanel/cardsColor", "Cactus");
        images[20] = readImage("panels/inventoryPanel/cardsColor", "CherryBomb");
        images[21] = readImage("panels/inventoryPanel/cardsColor", "Jalapeno");
        images[22] = readImage("panels/inventoryPanel/cardsBW", "Sunflower");
        images[23] = readImage("panels/inventoryPanel/cardsBW", "Peashooter");
        images[24] = readImage("panels/inventoryPanel/cardsBW", "WallNut");
        images[25] = readImage("panels/inventoryPanel/cardsBW", "SnowPea");
        images[26] = readImage("panels/inventoryPanel/cardsBW", "Squash");
        images[27] = readImage("panels/inventoryPanel/cardsBW", "Lilypad");
        images[28] = readImage("panels/inventoryPanel/cardsBW", "TangleKelp");
        images[29] = readImage("panels/inventoryPanel/cardsBW", "Cactus");
        images[30] = readImage("panels/inventoryPanel/cardsBW", "CherryBomb");
        images[31] = readImage("panels/inventoryPanel/cardsBW", "Jalapeno");
        images[32] = readImage("panels/inventoryPanel/highlightsColor", "Sunflower");
        images[33] = readImage("panels/inventoryPanel/highlightsColor", "Peashooter");
        images[34] = readImage("panels/inventoryPanel/highlightsColor", "WallNut");
        images[35] = readImage("panels/inventoryPanel/highlightsColor", "SnowPea");
        images[36] = readImage("panels/inventoryPanel/highlightsColor", "Squash");
        images[37] = readImage("panels/inventoryPanel/highlightsColor", "Lilypad");
        images[38] = readImage("panels/inventoryPanel/highlightsColor", "TangleKelp");
        images[39] = readImage("panels/inventoryPanel/highlightsColor", "Cactus");
        images[40] = readImage("panels/inventoryPanel/highlightsColor", "CherryBomb");
        images[41] = readImage("panels/inventoryPanel/highlightsColor", "Jalapeno");
        images[42] = readImage("panels/inventoryPanel/highlightsBW", "Sunflower");
        images[43] = readImage("panels/inventoryPanel/highlightsBW", "Peashooter");
        images[44] = readImage("panels/inventoryPanel/highlightsBW", "WallNut");
        images[45] = readImage("panels/inventoryPanel/highlightsBW", "SnowPea");
        images[46] = readImage("panels/inventoryPanel/highlightsBW", "Squash");
        images[47] = readImage("panels/inventoryPanel/highlightsBW", "Lilypad");
        images[48] = readImage("panels/inventoryPanel/highlightsBW", "TangleKelp");
        images[49] = readImage("panels/inventoryPanel/highlightsBW", "Cactus");
        images[50] = readImage("panels/inventoryPanel/highlightsBW", "CherryBomb");
        images[51] = readImage("panels/inventoryPanel/highlightsBW", "Jalapeno");
        

        return images;
    }

    public static BufferedImage[] loadPlantsList() {
        BufferedImage[] images = new BufferedImage[36];

        images[0] = readImage("panels/plantsListPanel", "Background");
        images[1] = readImage("panels/plantsListPanel", "Almanac");
        images[2] = readImage("panels/plantsListPanel", "Help");
        images[3] = readImage("panels/plantsListPanel", "Menu");
        images[4] = readImage("panels/plantsListPanel", "HelpHighlight");
        images[5] = readImage("panels/plantsListPanel", "MenuHighlight");
        images[6] = readImage("panels/plantsListPanel/cards", "Sunflower");
        images[7] = readImage("panels/plantsListPanel/cards", "Peashooter");
        images[8] = readImage("panels/plantsListPanel/cards", "WallNut");
        images[9] = readImage("panels/plantsListPanel/cards", "SnowPea");
        images[10] = readImage("panels/plantsListPanel/cards", "Squash");
        images[11] = readImage("panels/plantsListPanel/cards", "Lilypad");
        images[12] = readImage("panels/plantsListPanel/cards", "TangleKelp");
        images[13] = readImage("panels/plantsListPanel/cards", "Cactus");
        images[14] = readImage("panels/plantsListPanel/cards", "CherryBomb");
        images[15] = readImage("panels/plantsListPanel/cards", "Jalapeno");images[0] = readImage("panels/plantsListPanel", "Background");
        images[16] = readImage("panels/plantsListPanel/highlights", "Sunflower");
        images[17] = readImage("panels/plantsListPanel/highlights", "Peashooter");
        images[18] = readImage("panels/plantsListPanel/highlights", "WallNut");
        images[19] = readImage("panels/plantsListPanel/highlights", "SnowPea");
        images[20] = readImage("panels/plantsListPanel/highlights", "Squash");
        images[21] = readImage("panels/plantsListPanel/highlights", "Lilypad");
        images[22] = readImage("panels/plantsListPanel/highlights", "TangleKelp");
        images[23] = readImage("panels/plantsListPanel/highlights", "Cactus");
        images[24] = readImage("panels/plantsListPanel/highlights", "CherryBomb");
        images[25] = readImage("panels/plantsListPanel/highlights", "Jalapeno");
        images[26] = readImage("panels/plantsListPanel/attributes", "Sunflower");
        images[27] = readImage("panels/plantsListPanel/attributes", "Peashooter");
        images[28] = readImage("panels/plantsListPanel/attributes", "WallNut");
        images[29] = readImage("panels/plantsListPanel/attributes", "SnowPea");
        images[30] = readImage("panels/plantsListPanel/attributes", "Squash");
        images[31] = readImage("panels/plantsListPanel/attributes", "Lilypad");
        images[32] = readImage("panels/plantsListPanel/attributes", "TangleKelp");
        images[33] = readImage("panels/plantsListPanel/attributes", "Cactus");
        images[34] = readImage("panels/plantsListPanel/attributes", "CherryBomb");
        images[35] = readImage("panels/plantsListPanel/attributes", "Jalapeno");
        
        return images;
    }

    public static BufferedImage[] loadZombiesList() {
        BufferedImage[] images = new BufferedImage[36];

        images[0] = readImage("panels/zombiesListPanel", "Background");
        images[1] = readImage("panels/zombiesListPanel", "Almanac");
        images[2] = readImage("panels/zombiesListPanel", "Help");
        images[3] = readImage("panels/zombiesListPanel", "Menu");
        images[4] = readImage("panels/zombiesListPanel", "HelpHighlight");
        images[5] = readImage("panels/zombiesListPanel", "MenuHighlight");
        images[6] = readImage("panels/zombiesListPanel/cards", "Normal");
        images[7] = readImage("panels/zombiesListPanel/cards", "Conehead");
        images[8] = readImage("panels/zombiesListPanel/cards", "PoleVaulting");
        images[9] = readImage("panels/zombiesListPanel/cards", "Buckethead");
        images[10] = readImage("panels/zombiesListPanel/cards", "DuckyTube");
        images[11] = readImage("panels/zombiesListPanel/cards", "DolphinRider");
        images[12] = readImage("panels/zombiesListPanel/cards", "JackInTheBox");
        images[13] = readImage("panels/zombiesListPanel/cards", "ScreenDoor");
        images[14] = readImage("panels/zombiesListPanel/cards", "Football");
        images[15] = readImage("panels/zombiesListPanel/cards", "Newspaper");images[0] = readImage("panels/plantsListPanel", "Background");
        images[16] = readImage("panels/zombiesListPanel/highlights", "Normal");
        images[17] = readImage("panels/zombiesListPanel/highlights", "Conehead");
        images[18] = readImage("panels/zombiesListPanel/highlights", "PoleVaulting");
        images[19] = readImage("panels/zombiesListPanel/highlights", "Buckethead");
        images[20] = readImage("panels/zombiesListPanel/highlights", "DuckyTube");
        images[21] = readImage("panels/zombiesListPanel/highlights", "DolphinRider");
        images[22] = readImage("panels/zombiesListPanel/highlights", "JackInTheBox");
        images[23] = readImage("panels/zombiesListPanel/highlights", "ScreenDoor");
        images[24] = readImage("panels/zombiesListPanel/highlights", "Football");
        images[25] = readImage("panels/zombiesListPanel/highlights", "Newspaper");
        images[26] = readImage("panels/zombiesListPanel/attributes", "Normal");
        images[27] = readImage("panels/zombiesListPanel/attributes", "Conehead");
        images[28] = readImage("panels/zombiesListPanel/attributes", "PoleVaulting");
        images[29] = readImage("panels/zombiesListPanel/attributes", "Buckethead");
        images[30] = readImage("panels/zombiesListPanel/attributes", "DuckyTube");
        images[31] = readImage("panels/zombiesListPanel/attributes", "DolphinRider");
        images[32] = readImage("panels/zombiesListPanel/attributes", "JackInTheBox");
        images[33] = readImage("panels/zombiesListPanel/attributes", "ScreenDoor");
        images[34] = readImage("panels/zombiesListPanel/attributes", "Football");
        images[35] = readImage("panels/zombiesListPanel/attributes", "Newspaper");

        return images;
    }

    public static BufferedImage[] loadHelp() {
        BufferedImage[] images = new BufferedImage[5];

        images[0] = readImage("panels/helpPanel", "Background");
        images[1] = readImage("panels/helpPanel", "Menu");
        images[2] = readImage("panels/helpPanel", "Inventory");
        images[3] = readImage("panels/helpPanel", "Play");
        images[4] = readImage("panels/helpPanel", "Introduction");

        return images;
    }

    public static BufferedImage[] loadInventoryCard() {
        BufferedImage[] images = new BufferedImage[10];

        images[0] = readImage("entities/items/inventory", "Sunflower");
        images[1] = readImage("entities/items/inventory", "Peashooter");
        images[2] = readImage("entities/items/inventory", "WallNut");
        images[3] = readImage("entities/items/inventory", "SnowPea");
        images[4] = readImage("entities/items/inventory", "Squash");
        images[5] = readImage("entities/items/inventory", "LilyPad");
        images[6] = readImage("entities/items/inventory", "TangleKelp");
        images[7] = readImage("entities/items/inventory", "Cactus");
        images[8] = readImage("entities/items/inventory", "CherryBomb");
        images[9] = readImage("entities/items/inventory", "Jalapeno");
        images[10] = readImage("entities/items/inventory", "PotatoMine");

        return images;
    }

    public static BufferedImage[] loadPlay() {
        BufferedImage[] images = new BufferedImage[5];

        images[0] = readImage("panels/playPanel", "Background");
        images[1] = readImage("panels/playPanel", "Menu");
        images[2] = readImage("panels/playPanel", "Inventory");
        images[3] = readImage("panels/playPanel", "Help");
        images[4] = readImage("panels/playPanel", "Pause");

        return images;
    }

    public static BufferedImage[] loadMap() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box");
        images[1] = readImage("menus/world_menu", "house_info_box");
        images[2] = readImage("menus/world_menu", "help_box");
        images[3] = readImage("menus/world_menu", "world_help");

        return images;
    }

    public static BufferedImage[] loadGamePause() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box");
        images[1] = readImage("menus/world_menu", "house_info_box");
        images[2] = readImage("menus/world_menu", "help_box");
        images[3] = readImage("menus/world_menu", "world_help");

        return images;
    }

    public static BufferedImage[] loadGameWin() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box");
        images[1] = readImage("menus/world_menu", "house_info_box");
        images[2] = readImage("menus/world_menu", "help_box");
        images[3] = readImage("menus/world_menu", "world_help");

        return images;
    }

    public static BufferedImage[] loadGameLose() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box");
        images[1] = readImage("menus/world_menu", "house_info_box");
        images[2] = readImage("menus/world_menu", "help_box");
        images[3] = readImage("menus/world_menu", "world_help");

        return images;
    }

    public static BufferedImage[] loadWaveTab() {
        BufferedImage[] images = new BufferedImage[4];

        images[0] = readImage("menus/world_menu", "sim_preview_box");
        images[1] = readImage("menus/world_menu", "house_info_box");
        images[2] = readImage("menus/world_menu", "help_box");
        images[3] = readImage("menus/world_menu", "world_help");

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