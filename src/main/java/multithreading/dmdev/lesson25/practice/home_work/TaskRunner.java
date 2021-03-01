package multithreading.dmdev.lesson25.practice.home_work;


import multithreading.dmdev.lesson25.practice.home_work.model.Dump;
import multithreading.dmdev.lesson25.practice.home_work.model.RobotParts;
import multithreading.dmdev.lesson25.practice.home_work.threaad.Factory;
import multithreading.dmdev.lesson25.practice.home_work.threaad.Night;
import multithreading.dmdev.lesson25.practice.home_work.threaad.Scientist;
import multithreading.dmdev.lesson25.practice.home_work.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskRunner {
    public static void main(String[] args) {

        Night night = new Night();
        Dump dump = new Dump(getInitialParts());
        Scientist tesla = new Scientist("Tesla", night, dump);
        Factory factory = new Factory(night, dump);




        long beg = System.currentTimeMillis();
        night.start();
        //factory.start();
        tesla.start();
        try {
            night.join();
            tesla.join();
            //factory.join();
            System.out.println("time elapsed " + (System.currentTimeMillis() - beg));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static List<RobotParts> getInitialParts() {
        return IntStream
                .rangeClosed(1, 20)
                .mapToObj(x -> RobotParts.getRandomPart())
                .collect(Collectors.toList());
    }

}
