package tdd.account;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;

public class HumanFormatter extends Formatter {
    final String header = String.format("%-22s%-10s%s", "Time", "Amount", "Balance");
    final String footer = "";
    final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    final String transactFormat = "%s   %-+5d\t%-5d";

    public HumanFormatter() {}

    @Override
    public void printHeader(PrintStream printer) {
        printer.println(header);
    }

    @Override
    public void printFooter(PrintStream printer) {
        printer.println(footer);
    }

    @Override
    public void printTransact(Transaction transaction, PrintStream printer) {
        String date = transaction.getTime().format(dateFormat);
        String transactPrint = String.format(transactFormat, date, transaction.getChange(), transaction.getBalance());
        printer.println(transactPrint);
    }
}

