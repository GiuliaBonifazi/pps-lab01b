package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BankAccountTest {
    protected BankAccount bankAccount;

    @BeforeEach
    abstract void init();

    @Test
    public void testBalanceEmptyOnCreation() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        int depositAmount = 100;
        this.bankAccount.deposit(depositAmount);
        assertEquals(depositAmount, this.bankAccount.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
        "100, 20, 80",
        "50, 60, -10"
    })
    abstract public void testWithdraw(int depositAmount, int withdrawAmount, int expectedBalance);
}
