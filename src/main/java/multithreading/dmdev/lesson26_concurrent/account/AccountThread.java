package multithreading.dmdev.lesson26_concurrent.account;

public class AccountThread extends Thread {
    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            try {
                lockAccounts();
                if (accountFrom.takeMoney(10)) {
                    accountTo.putMoney(10);
                }
            } finally {
                accountTo.getLock().unlock();
                accountFrom.getLock().unlock();
            }
        }
    }

    private void lockAccounts() {
        while (true) {
            boolean accountToLocked = accountTo.getLock().tryLock();
            boolean accountFromLocked = accountFrom.getLock().tryLock();
            if (accountFromLocked && accountToLocked) {
                break;
            }
            if (accountFromLocked) {
                accountFrom.getLock().unlock();
            }
            if (accountToLocked) {
                accountTo.getLock().unlock();
            }
        }
    }
}
