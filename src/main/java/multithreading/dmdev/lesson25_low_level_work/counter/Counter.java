package multithreading.dmdev.lesson25_low_level_work.counter;

public class Counter {
    private int count;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
