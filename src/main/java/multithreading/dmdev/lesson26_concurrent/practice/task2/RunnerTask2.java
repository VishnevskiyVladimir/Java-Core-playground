package multithreading.dmdev.lesson26_concurrent.practice.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;


/**
 * Задан массив случайных целых чисел (от 1 до 300)  1 млн элементов, 10 млн и 100 млн элементов.
 * Найти максимальный элемент в массиве двумя способами:в одном потоке и используя 10 потоков.
 * Сравнить затраченное в обоих случаях время.
 */
public class RunnerTask2 {

    public static final int LENGTH = 100_000_000;

    public static void main(String[] args) {
        int[] arr = getArray();
        System.out.println(calculateTime(() -> findMaxOneThread(arr)));
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        System.out.println(calculateTime(() -> {
            try {
                return findMaxMultiThread(arr, threadPool);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }));
        threadPool.shutdown();

    }

    private static int findMaxOneThread(int[] array) {
        return Arrays.stream(array)
                .max()
                .orElse(Integer.MAX_VALUE);
    }

    private static int findMaxMultiThread(int[] array, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> Arrays.stream(array)
                .parallel()
                .max()
                .orElse(Integer.MAX_VALUE)).get();
    }


    private static long calculateTime(Supplier<Integer> supplier) {
        long beginning = System.currentTimeMillis();
        supplier.get();
        return System.currentTimeMillis() - beginning;
    }

    private static int[] getArray() {
        Random random = new Random();
        int[] ints = new int[LENGTH];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(300) + 1;
        }
        return ints;
    }
}
