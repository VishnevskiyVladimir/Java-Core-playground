package multithreading.dmdev.lesson25.practice.home_work;


import multithreading.dmdev.lesson25.practice.home_work.threaad.Night;

public class TaskRunner {
    public static void main(String[] args) {

        Night night = new Night();
        long beg = System.currentTimeMillis();
        night.start();
        try {
            night.join();
            System.out.println("time elapsed " + (System.currentTimeMillis() - beg));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
