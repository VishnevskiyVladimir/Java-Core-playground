package multithreading.dmdev.lesson26_concurrent.semafore;

import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    final Semaphore cashBoxes;

    public BuyerThread(Semaphore cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {

            cashBoxes.acquire();
            System.out.println(Thread.currentThread().getName() + " took  some cashbox");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " gave back  some cashbox");
            cashBoxes.release();
            System.out.println(Thread.currentThread().getName() + " is waiting ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
