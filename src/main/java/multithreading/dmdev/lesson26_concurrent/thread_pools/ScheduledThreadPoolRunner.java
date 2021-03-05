package multithreading.dmdev.lesson26_concurrent.thread_pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolRunner {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(()-> System.out.println("Delayed task invoked"),4, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(()-> System.out.println("Scheduled at fixed rate task invoked"),1,2,TimeUnit.SECONDS);

//        scheduledThreadPool.shutdown();
//        scheduledThreadPool.awaitTermination(1, TimeUnit.HOURS);
    }
}
