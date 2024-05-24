package src.entities.plants.actions;

import src.mains.Consts;
import src.mains.UserInterface;
import src.mains.times.GameTime;
import src.maps.Map;
import src.entities.plants.Plant;

public class ActiveActions {
    public static void spawn(Plant plant, Map map) {
        Thread spawning = new Thread() {
            @Override
            public void run() {
                int initialDurationWorked = sim.getDurationWorked();
                sim.setStatus("Working");

                GameTime.addCooldownTimer(sim, "Working", duration, duration);
                
                while (GameTime.isAlive(sim, "Working")) {
                    try {
                        if (UserInterface.isPaused()) continue;
                        
                        int durationWorked = sim.getDurationWorked();
                        
                        Thread.sleep(Consts.THREAD_ONE_SECOND);
                        if (durationWorked <  initialDurationWorked + workDuration) {
                            sim.setDurationWorked(sim.getDurationWorked() + 1);
                        }

                        if (durationWorked == 0) continue;
                        
                        // decrease sim mood and hunger every 30 seconds
                        if (durationWorked % (Consts.ONE_SECOND * 30) == 0) {
                            int simHunger = sim.getHunger();
                            int simMood = sim.getMood();
                            sim.setHunger(simHunger - 10);
                            sim.setMood(simMood - 10);
                        }

                        // increase sim salary every 4 minutes of work done
                        if (durationWorked == (Consts.ONE_MINUTE * 4)) {
                            int simMoney = sim.getMoney();
                            int salary = sim.getProfession().getSalary();
                            sim.setMoney(simMoney + salary);
                            sim.setDurationWorked(0);
                        }
                    } catch (InterruptedException e) {}
                }
                sim.resetStatus();
            }
        };
        plant.spawning();
    }

    public static void attack(Plant Plant, Plant plant, Map map) {
    }

    public static void interact() {
        Plant Plant = UserInterface.getCurrentSim();
        Room currentRoom = sim.getCurrentRoom();
        Interactables object = sim.getInteractionHandler().getInteractableObject();
        
        if (object == null) {
            return;
        }
        
        if (object.isOccupied()) {
            return;
        }

        if (currentRoom.isEditingRoom()) {
            return;
        }

        object.interact(sim);
    }
}
