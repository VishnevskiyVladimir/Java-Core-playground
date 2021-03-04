package multithreading.dmdev.lesson25_low_level_work.vol;

public class VolatileDemo {
    private static boolean flag = false;
    //private static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("Still false");
            }
        });
        Thread thread2 = new Thread(() -> {
            while (!flag) {
                System.out.println("Still false");
            }
        });
        Thread thread3 = new Thread(() -> {
            while (!flag) {
                System.out.println("Still false");
            }
        });
        Thread thread4 = new Thread(() -> {
            while (!flag) {
                System.out.println("Still false");
            }
        });
        Thread thread5 = new Thread(() -> {
            flag = true;
            System.out.println("set true");

        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
