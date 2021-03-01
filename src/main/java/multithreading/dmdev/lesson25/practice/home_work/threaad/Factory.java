package multithreading.dmdev.lesson25.practice.home_work.threaad;

import multithreading.dmdev.lesson25.practice.home_work.model.Dump;
import multithreading.dmdev.lesson25.practice.home_work.model.RobotParts;
import multithreading.dmdev.lesson25.practice.home_work.util.NightConstant;
import multithreading.dmdev.lesson25.practice.home_work.util.RandomUtil;

public class Factory extends Thread{
    private final Night night;
    private  final Dump dump;
    public static final int MAX_AMOUNT_OF_PARTS_PER_NIGHT = 4;

    public Factory(Night night, Dump dump) {
        this.night = night;
        this.dump = dump;
    }


    @Override
    public void run() {
        for (int i = 0; i < NightConstant.AMOUNT_OF_NIGHTS; i++) {
            throwParts();
            waitNextNight();
        }

    }

    private void throwParts() {
        int partsAmountThisNight = RandomUtil.getRandomIntStartingFromOne(MAX_AMOUNT_OF_PARTS_PER_NIGHT);
        for (int i = 0; i < partsAmountThisNight; i++) {
            dump.add(RobotParts.getRandomPart());
        }
        System.out.println("Today added " + partsAmountThisNight + " parts to dump");
        System.out.println("Dump size is " + dump.size());
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
