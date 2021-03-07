package multithreading.dmdev.lesson26_concurrent.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class RocketPartsFactory implements Runnable{
    private CyclicBarrier cyclicBarrier;
    private RocketDetail detail;

    public RocketPartsFactory(CyclicBarrier cyclicBarrier, RocketDetail detail) {
        this.cyclicBarrier = cyclicBarrier;
        this.detail = detail;
    }

    @Override
    public void run() {
        System.out.println("Details" + detail.name() + " is preparing!");
        try {
            Thread.sleep(1000L);
            System.out.println("Details" + detail.name() + " is ready");
            cyclicBarrier.await();
            System.out.println("Details" + detail.name() + " is utilized");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
