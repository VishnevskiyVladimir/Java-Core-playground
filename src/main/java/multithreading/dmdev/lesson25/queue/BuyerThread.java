package multithreading.dmdev.lesson25.queue;

import java.util.Queue;

public class BuyerThread implements Runnable {

    Queue<CashBox> cashBoxes;

    public BuyerThread(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!cashBoxes.isEmpty()) {
                    CashBox cashbox = cashBoxes.remove();
                    System.out.println(Thread.currentThread().getName() + " took  " + cashbox);
                    Thread.sleep(5L);


                    System.out.println(Thread.currentThread().getName() + " gave back " + cashbox);
                    cashBoxes.add(cashbox);
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " is waiting ");
                    Thread.sleep(5L);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
