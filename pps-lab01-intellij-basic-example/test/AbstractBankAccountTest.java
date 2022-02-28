import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100 - getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - getFee()*2, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100 - getFee(), bankAccount.getBalance());
    }

    abstract double getFee();
}
