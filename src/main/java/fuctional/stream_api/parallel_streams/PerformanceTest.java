package fuctional.stream_api.parallel_streams;

import java.util.stream.LongStream;

public class PerformanceTest {
    public static void main(String[] args) {
        sumWithStream();
        sumWithParallelStreams();


    }
    static void sumWithStream() {
        long start = System.currentTimeMillis();
        long sum = LongStream
                .rangeClosed(1, 10_000_000)
                .sum();
        long time = System.currentTimeMillis() - start;
        System.out.println("Not parallel calculations took " + time + " milliseconds. Sum = " + sum);
    }

    static void sumWithParallelStreams() {
        long start = System.currentTimeMillis();
        long sum = LongStream
                .rangeClosed(1, 10_000_000)
                .parallel()
                .sum();
        long time = System.currentTimeMillis() - start;
        System.out.println("Parallel calculations took " + time + " milliseconds. Sum = " + sum);
    }
}
