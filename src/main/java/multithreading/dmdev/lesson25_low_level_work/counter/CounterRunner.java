package multithreading.dmdev.lesson25_low_level_work.counter;

public class CounterRunner {

    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread thread1 = new CounterThread( "thread1", counter);
        CounterThread thread2 = new CounterThread( "thread2", counter);
        CounterThread thread3 = new CounterThread( "thread3", counter);
        CounterThread thread4 = new CounterThread( "thread4", counter);
        CounterThread thread5 = new CounterThread( "thread5", counter);
        CounterThread thread6 = new CounterThread( "thread6", counter);
        CounterThread thread7 = new CounterThread( "thread7", counter);
        CounterThread thread8 = new CounterThread( "thread8", counter);

        long beg = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected: 80000, Actual: " +  counter.getCount());
        System.out.println("time elapsed: " + (System.currentTimeMillis() - beg));
    }





}
