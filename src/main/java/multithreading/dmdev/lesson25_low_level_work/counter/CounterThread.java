package multithreading.dmdev.lesson25_low_level_work.counter;

public class CounterThread extends Thread{

    private final Counter counter;

    public CounterThread(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
