package multithreading.dmdev.lesson26_concurrent.thread_pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Runner2 {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Executors.newWorkStealingPool();
    }
}
