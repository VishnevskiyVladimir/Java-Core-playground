package multithreading.dmdev.lesson26_concurrent.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count;

    public Counter() {
        this.count = new AtomicInteger();
    }

    public void increment() {
            count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
