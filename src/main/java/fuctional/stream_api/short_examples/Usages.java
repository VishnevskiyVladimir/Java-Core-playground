package fuctional.stream_api.short_examples;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Usages {
    public static void main(String[] args) {
        summaryStatisticsMethod();
    }


    static void generateRandom(){
        DoubleStream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    static void summaryStatisticsMethod () {
        IntSummaryStatistics stat = IntStream.rangeClosed(1, 55_555).summaryStatistics();

        System.out.printf("Count: %d, Min: %d, Max: %d, Avg: %.1f%n",
                stat.getCount(), stat.getMin(), stat.getMax(), stat.getAverage());
    }


}

