package multithreading.dmdev.lesson26_concurrent.latch;

import java.util.concurrent.CountDownLatch;

public class RocketPartsFactory implements Runnable{
    private CountDownLatch countDownLatch;
    private RocketDetail detail;

    public RocketPartsFactory(CountDownLatch countDownLatch, RocketDetail detail) {
        this.countDownLatch = countDownLatch;
        this.detail = detail;
    }

    @Override
    public void run() {
        System.out.println("Details" + detail.name() + " is preparing!");
        try {
            Thread.sleep(1000L);
            System.out.println("Details" + detail.name() + " is ready");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
