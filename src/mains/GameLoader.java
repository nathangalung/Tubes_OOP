package src.mains;

import java.util.ArrayList;

import src.mains.times.GameTime;
import src.mains.panels.InventoryPanel;
import src.mains.panels.GamePanel;
// import src.entities.plants.Plant;
// import src.entities.zombies.Zombie;
import src.maps.Map;

public class GameLoader {
    public static void startNewGame() {
        GameTime.init(1, Consts.GAME, Consts.MORNING, Consts.NIGHT);
        Map map = GamePanel.map = new Map();
        
        
        int[] plantsListPlayDeck = InventoryPanel.plantsDeck;
        // ArrayList<Plant> plantsListPlay = new ArrayList<>();
        // ArrayList<Zombie> zombiesListPlay = new ArrayList<>();

        for (int i = 0; i < plantsListPlayDeck.length; i++) {
            if (plantsListPlayDeck[i] == 0) {
                
            }
        }
        
        // Actually start the game by changing the state into adding a house
        UserInterface.init(map);
    }

    public static void loadGame() {

        // LOAD GAME HERE
        
    }
}