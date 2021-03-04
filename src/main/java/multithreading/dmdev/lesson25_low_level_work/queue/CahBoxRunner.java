package multithreading.dmdev.lesson25_low_level_work.queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CahBoxRunner {
    public static void main(String[] args) {
        Queue<CashBox> cashBoxes = new ArrayDeque<>(List.of(new CashBox(), new CashBox()));

        List<Thread> threadList = Stream.of(new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes)
        )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
