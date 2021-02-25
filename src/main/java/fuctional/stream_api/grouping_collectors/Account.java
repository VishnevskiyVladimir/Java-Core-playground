package fuctional.stream_api.grouping_collectors;



public class Account {
    private long balance;
    private String number;
    private Status status;

    public Account(long balance, String number) {
        this.balance = balance;
        this.number = number;
    }

    public Account(long balance, String number, Status status) {
        this.balance = balance;
        this.number = number;
        this.status = status;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

enum Status {
    ACTIVE,
    BLOCKED,
    REMOVED
}
