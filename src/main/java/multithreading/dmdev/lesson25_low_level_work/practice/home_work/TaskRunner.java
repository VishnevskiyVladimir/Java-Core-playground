package multithreading.dmdev.lesson25_low_level_work.practice.home_work;


import multithreading.dmdev.lesson25_low_level_work.practice.home_work.model.Dump;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.model.RobotParts;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.threaad.Factory;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.threaad.Night;
import multithreading.dmdev.lesson25_low_level_work.practice.home_work.threaad.Scientist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskRunner {

    public static final int INITIAL_AMOUNT_OF_PARTS_IN_DUMP = 20;

    public static void main(String[] args) {

        Night night = new Night();
        Dump dump = new Dump(getInitialParts());
        Scientist tesla = new Scientist("Tesla", night, dump);
        Scientist einstein = new Scientist("Einstein", night, dump);
        Factory factory = new Factory(night, dump);


        long beg = System.currentTimeMillis();
        night.start();
        factory.start();
        tesla.start();
        einstein.start();
        try {
            night.join();
            tesla.join();
            einstein.join();
            factory.join();
            System.out.println("time elapsed " + (System.currentTimeMillis() - beg));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static List<RobotParts> getInitialParts() {
        return IntStream
                .rangeClosed(1, INITIAL_AMOUNT_OF_PARTS_IN_DUMP)
                .mapToObj(x -> RobotParts.getRandomPart())
                .collect(Collectors.toList());
    }

}
