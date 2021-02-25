package multithreading;

public class Main {
    public static void main(String[] args) {

        SimpleThread thread1 =  new SimpleThread("thread1");
        System.out.println(thread1.getName() + " : " + thread1.getState());
        Runnable simpleRunnable = new SimpleRunnable();
        Thread thread2 = new Thread(simpleRunnable,"thread2");
        Thread thread3 = new Thread(()-> System.out.println("Hello from " + Thread.currentThread().getName()),"thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(thread1.getName() + " : " + thread1.getState());

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getName() + " : " + thread1.getState());
        System.out.println(Thread.currentThread().getName());

    }
}
