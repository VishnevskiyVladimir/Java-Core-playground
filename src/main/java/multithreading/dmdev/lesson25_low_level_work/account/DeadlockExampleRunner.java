package multithreading.dmdev.lesson25_low_level_work.account;

public class DeadlockExampleRunner {
    public static void main(String[] args) {
        Account account1 = new Account(20000);
        Account account2 = new Account(20000);

        Thread thread1 = new AccountThread(account1, account2);
        Thread thread2 = new AccountThread(account2, account1);
        try {

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account1);
        System.out.println(account2);


    }
}
