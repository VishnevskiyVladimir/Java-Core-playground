package multithreading.dmdev.lesson25_low_level_work.practice.home_work.threaad;

import multithreading.dmdev.lesson25_low_level_work.practice.home_work.model.Dump;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.model.RobotParts;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.util.NightConstant;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.util.RandomUtil;

import java.util.HashMap;
import java.util.Map;

public class Scientist extends Thread {
    private final Night night;
    private final Dump dump;
    private final Map<RobotParts,Integer> collectedParts;


    public static final int MAX_AMOUNT_OF_PARTS_PER_NIGHT = 4;

    public Scientist(String name, Night night, Dump dump) {
        super(name);
        this.night = night;
        this.dump = dump;
        collectedParts = new HashMap<>();
        for (int i = 0; i < RobotParts.values().length; i++) {
            collectedParts.put(RobotParts.values()[i],0);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < NightConstant.AMOUNT_OF_NIGHTS; i++) {
            throwAssistantForParts();
            waitNextNight();
        }

    }

    private void throwAssistantForParts() {
        int partsAmountThisNight;
        int alreadyCollectedOfTheKind;

        synchronized (dump.getLock()) {

            partsAmountThisNight = getAmountThisNight();
            for (int i = 0; i < partsAmountThisNight; i++) {
                RobotParts collectedPart = dump.removeRandomPart();
                alreadyCollectedOfTheKind = collectedParts.get(collectedPart);
                collectedParts.put(collectedPart, ++alreadyCollectedOfTheKind);
            }


            System.out.println(getName() + "'s assistant today collected " + partsAmountThisNight + " parts from dump");
            System.out.println("Dump size is " + dump.size());
            System.out.println(getName() + " got from his assistant: " + collectedParts.entrySet() +
                    ". Out of them he made " + countRobots() + " robots.");
        }

    }

    private int countRobots() {
        int curRobotsCounter = collectedParts.get(RobotParts.values()[0]);
        int curPartCounter;
        for (int i = 1; i < RobotParts.values().length; i++) {
            curPartCounter = collectedParts.get(RobotParts.values()[i]);
            if(curRobotsCounter > curPartCounter) {
                curRobotsCounter = curPartCounter;
            }
        }
        return curRobotsCounter;
    }

    private int getAmountThisNight() {
        return Math.min(dump.size(),
                RandomUtil.getRandomIntStartingFromOne(MAX_AMOUNT_OF_PARTS_PER_NIGHT));
    }

    private void waitNextNight() {
        synchronized (night.getLock()) {
            try {
                night.getLock().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
