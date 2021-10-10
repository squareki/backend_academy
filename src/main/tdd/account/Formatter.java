package tdd.account;

import java.io.PrintStream;

public abstract class Formatter {
    public Formatter() {}

    public abstract void printHeader(PrintStream printer);
    public abstract void printFooter(PrintStream printer);
    public abstract void printTransact(Transaction transaction, PrintStream printer);
}

