package multithreading.dmdev.lesson26_concurrent.thread_pools;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPoolRunner {
    public static void main(String[] args) {
        Queue<Runnable> tasks = new ArrayDeque<>();
        Runnable task1 = () -> System.out.println("Task #1 is running");
        Runnable task2 = () -> System.out.println("Task #2 is running");
        Runnable task3 = () ->  System.out.println("Task #3 is running");
        Runnable task4 = () ->  System.out.println("Task #4 is running");
        Runnable task5 = () ->  System.out.println("Task #5 is running");
        Runnable task6 = () ->  System.out.println("Task #6 is running");
        Runnable task7 = () ->  System.out.println("Task #7 is running");
        Runnable task8 = () ->  System.out.println("Task #8 is running");
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);

        Thread thread1 = new PoolThread(tasks);
        Thread thread2 = new PoolThread(tasks);
        Thread thread3 = new PoolThread(tasks);


        thread1.start();
        thread2.start();
        thread3.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
