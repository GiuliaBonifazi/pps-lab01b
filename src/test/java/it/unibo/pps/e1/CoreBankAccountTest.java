package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreBankAccountTest extends BankAccountTest{

    @BeforeEach
    @Override
    void init() {
        this.bankAccount = new CoreBankAccount();
    }

    @ParameterizedTest
    @CsvSource({
        "100, 20, 80",
        "50, 60, -10"
    })
    @Override
    public void testWithdraw(int depositAmount, int withdrawAmount, int expectedBalance) {
        this.bankAccount.deposit(depositAmount);
        this.bankAccount.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount, this.bankAccount.getBalance());
    }
}
