package tdd.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AccountTests {
    Account account;
    @BeforeEach
    public void initAccount() {
        account = new Account();
    }

    @Test
    public void accountEmptyTest() {
        assertEquals(0, account.getBalance());
    }

    @Test
    public void accountPositiveTransactionTest() {
        account.addTransaction(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    public void accountNegativeTransactionTest() {
        account.addTransaction(500);
        account.addTransaction(-300);
        assertEquals(200, account.getBalance());
    }

    @Test
    public void accountLowerThanZeroBalanceTest() {
        account.addTransaction(500);
        assertEquals(Account.TransactionResult.FAIL, account.addTransaction(-600));
    }

    @Test
    public void rangePrintTest() {
        String expected = "Time                  Amount    Balance\n" +
        "28.09.2021 13:37:00   +500 \t500  \n" +
        "28.09.2021 13:37:01   -100 \t400  \n" +
        "\n"; //footer
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printer = new PrintStream(baos);
        HumanFormatter formatter = new HumanFormatter();

        ZonedDateTime transactTimeFirst = ZonedDateTime.of(2021, 9, 28, 13, 37, 00, 00, ZoneId.of("UTC"));
        account.addTransaction(500, transactTimeFirst);
        ZonedDateTime transactTimeSecond = ZonedDateTime.of(2021, 9, 28, 13, 37, 01, 00, ZoneId.of("UTC"));
        account.addTransaction(-100, transactTimeSecond);

        account.printTransactions(formatter, printer);

        assertEquals(expected, baos.toString().replace("\r", "")); //accounts for CRLF v LF
    }
}

