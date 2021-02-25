package multithreading.dmdev.lesson25;

public class SimpleRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
