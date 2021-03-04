package multithreading.dmdev.lesson26_concurrent.account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static int generator = 1;
    private int id;
    private int money;
    private final Lock lock = new ReentrantLock();

    public Account(int money) {
        this.id = generator++;
        this.money = money;
    }

    public void putMoney(int money) {
        this.money += money;
    }

    public boolean takeMoney(int money) {
        if (this.money >= money){
            this.money -= money;
            return true;
        } else {
            return  false;
        }
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "generator=" + generator +
                ", id=" + id +
                ", money=" + money +
                '}';
    }

}
