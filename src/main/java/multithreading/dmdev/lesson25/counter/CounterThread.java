package multithreading.dmdev.lesson25.counter;

public class CounterThread extends Thread{

    private Counter counter;

    public CounterThread(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
