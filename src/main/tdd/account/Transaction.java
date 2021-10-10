package tdd.account;

import java.time.ZonedDateTime;

public class Transaction {
    private int change;
    private int balance;
    private ZonedDateTime time;

    public Transaction(int change, int balance, ZonedDateTime time) {
        this.change = change;
        this.balance = balance + change;
        this.time = time;
    }

    public int getChange() {
        return this.change;
    }

    public int getBalance() {
        return this.balance;
    }

    public ZonedDateTime getTime() {
        return this.time;
    }
}

