package multithreading.dmdev.lesson25.account;

public class AccountThread extends Thread {
    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            synchronized (accountTo) {
                synchronized (accountFrom) {
                    if (accountFrom.takeMoney(10)) {
                        accountTo.putMoney(10);
                    }
                }
            }

        }
    }
}
