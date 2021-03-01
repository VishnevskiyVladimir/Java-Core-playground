package multithreading.dmdev.lesson25.practice.home_work.threaad;

import multithreading.dmdev.lesson25.practice.home_work.model.Dump;
import multithreading.dmdev.lesson25.practice.home_work.model.RobotParts;
import multithreading.dmdev.lesson25.practice.home_work.util.NightConstant;
import multithreading.dmdev.lesson25.practice.home_work.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Scientist extends Thread {
    private final Night night;
    private final Dump dump;
    private final List<RobotParts> collectedParts;

    public static final int MAX_AMOUNT_OF_PARTS_PER_NIGHT = 4;

    public Scientist(String name, Night night, Dump dump) {
        super(name);
        this.night = night;
        this.dump = dump;
        collectedParts = new ArrayList<>();
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
        synchronized (dump.getLock()) {

            partsAmountThisNight = getAmountThisNight();

            for (int i = 0; i < partsAmountThisNight; i++) {
                RobotParts collectedPart = dump.removeRandomPart();
                collectedParts.add(collectedPart);
            }
            System.out.println(getName() + "'s assistant today collected " + partsAmountThisNight + " parts from dump");
            System.out.println("Dump size is " + dump.size());
            System.out.println(getName() + " has: " + collectedParts.size());
        }

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
