package multithreading.dmdev.lesson25_low_level_work.practice.home_work.threaad;

import multithreading.dmdev.lesson25_low_level_work.practice.home_work.util.NightConstant;

public class Night extends Thread {

    private final Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < NightConstant.AMOUNT_OF_NIGHTS; i++) {
            synchronized (lock) {
                try {
                    System.out.printf("----------------\nNight %s started\n", (i + 1));
                    lock.notifyAll();//Here we call other threads to do their stuff
                    lock.wait(NightConstant.NIGHT_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}
