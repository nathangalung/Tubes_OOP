package src.mains;

import java.awt.Color;
import java.util.ArrayList;

import src.assets.AssetsLoader;
import src.mains.times.GameTime;
import src.main.panels.CreateSimPanel;
import src.main.panels.InventoryPanel;
import src.mains.panels.GamePanel;
import src.entities.plants.Plant;
import src.entities.zombies.Zombie;
import src.mains.Consts;
import src.maps.Map;

public class GameLoader {
    public static void startNewGame() {
        GameTime.init(1, Consts.GAME, Consts.MORNING, Consts.NIGHT);
        Map map = GamePanel.map = new Map();
        
        String simName = CreateSimPanel.simName;
        int selectedColor = CreateSimPanel.selectedColor;
        
        // Create the new sim
        int[] plantsListPlayDeck = InventoryPanel.plantsDeck;
        ArrayList<Plant> plantsListPlay = new ArrayList<>();
        ArrayList<Zombie> zombiesListPlay = new ArrayList<>();

        for (int i = 0; i < plantsListPlayDeck.length; i++) {
            if (plantsListPlayDeck[i] == 0) {
                
            }
        }
        
        // Add the new sim to the world
        world.addSim(newSim);
        
        // Actually start the game by changing the state into adding a house
        UserInterface.init(map);
        ListOfSimsMenu.world = world;
        ListOfSimsMenu.listOfSims = world.getListOfSim();
    }

    public static void loadGame() {

        // LOAD GAME HERE
        
    }
}