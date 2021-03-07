package multithreading.dmdev.lesson26_concurrent.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable{
    private CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println("Rocket is preparing for start");
        try {
            countDownLatch.await();
            System.out.println("Rocket started");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
