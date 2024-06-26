package src.mains.times;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

// import src.entities.plants.Plant;
import src.mains.Consts;
import src.mains.UserInterface;
import src.maps.Map;

public class GameTime implements Runnable {
    private static GameTime gt = new GameTime();
    private static Thread gtThread = new Thread(gt);

    public static int day;
    public static int timeRemaining = Consts.SECOND * Consts.GAME;
    public static int morningRemaining = Consts.SECOND * Consts.MORNING;
    public static int nightRemaining = Consts.SECOND * Consts.NIGHT;

    // private static ArrayList<CooldownTimer> cooldownPlantsList = new ArrayList<>();

    private GameTime() {}

    public static void init(int day, int timeRemaining, int morningRemaining, int nightRemaining) {
        GameTime.day = day;
        GameTime.timeRemaining = timeRemaining;
        GameTime.morningRemaining = morningRemaining;
        GameTime.nightRemaining = nightRemaining;

        if (!gtThread.isAlive()) {
            gtThread.start();
        }
    }

    // GETTERS
    public static GameTime getInstance() {
        return gt;
    }

    public static Thread getThreadInstance() {
        return gtThread;
    }

    // public static ArrayList<CooldownTimer> getCooldownPlantsList() {
    //     return cooldownPlantsList;
    // }

    // public static CooldownTimer getcooldownTimer(Plant plant, String activity) {
    //     try {
    //         for (CooldownTimer cooldownTimer : cooldownPlantsList) {
    //             Plant cooldownPlant = cooldownTimer.getPlant();

    //             boolean isPlantCooldown = plant.getName().equals(cooldownPlant.getName());

    //             if (isPlantCooldown) {
    //                 return cooldownTimer;
    //             }
    //         }
    //     }
    //     catch (ConcurrentModificationException cme) {

    //     }

    //     return null;
    // }

    // IMPLEMENTATION OF INTERFACE
    @Override
    public void run() {
        while (gtThread.isAlive()) {
            if (UserInterface.isViewingGamePause()) continue;
            // if (cooldownPlantsList.isEmpty()) continue;

            try {
                Thread.sleep(Consts.THREAD_ONE_SECOND);

                // for (CooldownTimer cooldownTimer : cooldownPlantsList) {
                //     int cooldownRemaining = cooldownTimer.getTimeRemaining();

                //     if (cooldownRemaining <= 0) cooldownPlantsList.remove(cooldownTimer);

                //     cooldownTimer.setTimeRemaining(cooldownRemaining - 1);
                // }
                decrementTimeRemaining();

                Map map = UserInterface.getMap();
                // ArrayList<Plant> plantsList = map.getPlantsList();

                // for (Plant plant : plantsList) {
                //     int timeNotSlept = plant.getTimeNotSlept();
                //     int timeNotTakenLeak = plant.getTimeNotTakenLeak();

                //     plant.setTimeNotSlept(timeNotSlept + 1);
                //     plant.setTimeNotTakenLeak(timeNotTakenLeak + 1);
                // }
            }
            catch (InterruptedException ie) {}
            catch (ConcurrentModificationException cme) {}
        }
    }

    // public static boolean isAlive(Plant plant, String activity) {
    //     if (cooldownPlantsList.isEmpty()) return false;

    //     boolean isAlive = false;
    //     try {
    //         for (CooldownTimer cooldownTimer : cooldownPlantsList) {
    //             Plant cooldownPlant = cooldownTimer.getPlant();

    //             boolean isPlantCooldown = plant.getName().equals(cooldownPlant.getName());

    //             if (isPlantCooldown) {
    //                 isAlive = true;
    //             }
    //         }
    //     }
    //     catch (ConcurrentModificationException cme) {}
    //     catch (NullPointerException npe) {}

    //     return isAlive;
    // }

    // // SETTERS
    // public static void addCooldownTimer(Plant plant, String activity, int duration) {
    //     CooldownTimer cooldownTimer = new CooldownTimer(plant, timeRemaining, duration);
    //     cooldownPlantsList.add(cooldownTimer);
    // }

    public static void decrementTimeRemaining() {
        timeRemaining--;
        System.out.println("Game Time: " + (250 - timeRemaining));
        if (timeRemaining == 250) {
            System.out.println("Morning");
        }
        if (timeRemaining == 150) {
            System.out.println("Night");
        }
        if (timeRemaining == 125) {
            UserInterface.isViewingFlag();
        }
        if (timeRemaining == 50) {
            System.out.println("Morning");
            incrementDay();
        }
        if (timeRemaining == 0) {
            gtThread.isInterrupted();
            UserInterface.isViewingGameLose();
            // if (zombiesList.isEmpty()) {
            //     UserInterface.isviewingGameWin();
            // }
            // else {
            //     UserInterface.isviewingGameLose();
            
            // }
        }
    }

    public static void incrementDay() {
        day++;
    }

    public static void decreaseTimeRemaining(int time) {
        timeRemaining -= time;

        // for (CooldownTimer cooldownTimer : cooldownPlantsList) {
        //     int timeRemaining = cooldownTimer.getTimeRemaining();

        //     cooldownTimer.setTimeRemaining(timeRemaining - time);
        // }

        // Map map = UserInterface.getMap();
        // ArrayList<Plant> plantsList = map.getPlantsList();

        // for (Plant plant : plantsList) {
        //     int timeNotSlept = plant.getTimeNotSlept();
        //     int timeNotTakenLeak = plant.getTimeNotTakenLeak();

        //     Plant.setTimeNotSlept(timeNotSlept + time);
        //     Plant.setTimeNotTakenLeak(timeNotTakenLeak + time);
        // }

        if (timeRemaining <= 50) {
            incrementDay();
        }
    }
}