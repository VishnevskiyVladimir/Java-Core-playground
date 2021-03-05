package multithreading.dmdev.lesson26_concurrent.thread_pools;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableFuture {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<String> future1 = threadPool.submit(() -> {
            Thread.sleep(4000L);
            System.out.println("Callable 1 working");
            return "First finished";
        });
        Future<String> future2 = threadPool.submit(() -> {
            Thread.sleep(2000L);
            System.out.println("Callable 2 working");
            return "Second finished";
        });
        Future<String> future3 = threadPool.submit(() -> {
            Thread.sleep(1000L);
            System.out.println("Callable 3 working");
            return "Third finished";
        });

        System.out.println("Main method after calling futures.");
        System.out.println(future1);
        System.out.println(future2);
        System.out.println(future3);
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);



        System.out.println("Main End");
    }
}