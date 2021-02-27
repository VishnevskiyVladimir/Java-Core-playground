package multithreading.dmdev.lesson25.queue;

import java.util.Queue;

public class BuyerThread implements Runnable {

    final Queue<CashBox> cashBoxes;

    public BuyerThread(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashBoxes) {
                while (true) {
                    if (!cashBoxes.isEmpty()) {
                        CashBox cashbox = cashBoxes.remove();
                        System.out.println(Thread.currentThread().getName() + " took  " + cashbox);
                        cashBoxes.wait(5L);


                        System.out.println(Thread.currentThread().getName() + " gave back " + cashbox);
                        cashBoxes.add(cashbox);
                        cashBoxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " is waiting ");
                        cashBoxes.wait();
                    }

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
