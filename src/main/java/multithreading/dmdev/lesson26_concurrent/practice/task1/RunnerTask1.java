package multithreading.dmdev.lesson26_concurrent.practice.task1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Написать программу, бесконечно считывающую
 * пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При каждом вводе числа, должна создаваться задача,
 * которая засыпает на введённое число секунд и затем
 * выводит "Я спал N секунд".
 * Однако нужно сделать так, чтобы все задачи выполнялись в
 * одном и том же потоке в порядке ввода.
 * Т.е. в программе есть 2 потока: главный и поток для
 * выполнения всех задач по очереди.
 * При вводе отрицательного числа программа должна завершать свою работу.
 * Второе решение - несколько потоков в пуле. Посчитать кол-во
 * обработанных задач каждым потоком
 */

public class RunnerTask1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        while (scanner.hasNextInt()) {
            int duration = scanner.nextInt();
            if (duration < 0) {
                break;
            } else {
                executorService.submit(() -> {
                    try {
                        Integer counter = threadLocal.get();
                        threadLocal.set(counter == null ? 1 : ++counter);
                        System.out.println(Thread.currentThread().getName() + " is waiting for " + duration + " seconds.");
                        System.out.println(Thread.currentThread().getName() + " took task number  " + threadLocal.get());
                        Thread.sleep(duration * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
