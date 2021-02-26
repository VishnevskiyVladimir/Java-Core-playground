package multithreading.dmdev.lesson25.counter;

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
