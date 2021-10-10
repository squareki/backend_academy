package tdd.account;

import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    public static enum TransactionResult {
        FAIL,
        SUCCESS
    }

    private int balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

    public TransactionResult addTransaction(int change, ZonedDateTime time) {
        if (this.balance + change < 0)
            return TransactionResult.FAIL;

        Transaction transaction = new Transaction(change, this.balance, time);
        this.transactions.add(transaction);
        this.balance += change;
        return TransactionResult.SUCCESS;
    }

    public TransactionResult addTransaction(int change) {
        return addTransaction(change, ZonedDateTime.now());
    }

    public void printTransactions(Formatter formatter, PrintStream printer) {
        formatter.printHeader(printer);

        for (Transaction transaction : this.transactions) {
            formatter.printTransact(transaction, printer);
        }

        formatter.printFooter(printer);
    }
}

