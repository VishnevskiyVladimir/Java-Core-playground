package multithreading.dmdev.lesson25_low_level_work.account;

public class Account {
    private static int generator = 1;
    private int id;
    private int money;

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


    @Override
    public String toString() {
        return "Account{" +
                "generator=" + generator +
                ", id=" + id +
                ", money=" + money +
                '}';
    }

}
