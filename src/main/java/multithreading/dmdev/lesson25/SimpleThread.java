package multithreading.dmdev.lesson25;

public class SimpleThread extends Thread{

    public SimpleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Hello from " + getName());
    }
}