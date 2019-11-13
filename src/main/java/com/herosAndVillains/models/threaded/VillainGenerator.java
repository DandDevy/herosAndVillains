package main.java.com.herosAndVillains.models.threaded;

import main.java.com.herosAndVillains.controllers.Controller;

import java.util.concurrent.TimeUnit;

/**
 * <h1>VillainGenerator</h1>
 * <p>VillainGenerator implements Runnable</p>
 * <p>When the thread runs, it will generate a villain at the delay set in the constructor. Along with the attributes provided.</p>
 */
public class VillainGenerator implements Runnable {
    private int delay;
    private String type, strength;
    private boolean keepRunning = true;

    /**
     * <p>VillainGenerator constructor will take a delay for the villain generation, a type for the villain and strength for it.</p>
     * @param delay
     * @param type
     * @param strength
     */
    public VillainGenerator(int delay, String type, String strength) {
        this.delay = delay;
        this.type = type;
        this.strength = strength;
    }

    /**
     * <p>Generate villain (threading with Runnable).</p>
     */
    @Override
    public void run() {
        while (keepRunning){
            Controller.addVillain(type, strength);
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate() {
        keepRunning = false;
    }
}
