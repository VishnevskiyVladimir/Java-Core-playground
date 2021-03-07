package multithreading.dmdev.lesson26_concurrent.queue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    final BlockingQueue<CashBox> cashBoxes;

    public BuyerThread(BlockingQueue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {

            CashBox cashbox = cashBoxes.take();
            System.out.println(Thread.currentThread().getName() + " took  " + cashbox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " gave back " + cashbox);
            cashBoxes.add(cashbox);
            System.out.println(Thread.currentThread().getName() + " is waiting ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
