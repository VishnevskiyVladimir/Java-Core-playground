package multithreading.dmdev.lesson26_concurrent.barrier;

import java.util.Arrays;
import java.util.concurrent.*;

public class RocketRunner {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(RocketDetail.values().length, () -> System.out.println("Rocket starts"));
        ExecutorService executorService = Executors.newCachedThreadPool();


        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketPartsFactory(barrier, detail))
                .forEach(executorService::submit);


        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.MINUTES);


    }
}
