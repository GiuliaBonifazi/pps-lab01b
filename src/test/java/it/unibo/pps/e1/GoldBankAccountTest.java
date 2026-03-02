package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest extends BankAccountTest{
    @BeforeEach
    @Override
    void init() {
        BankAccount coreBankAccount = new CoreBankAccount();
        this.bankAccount = new GoldBankAccount(coreBankAccount);
    }

    @ParameterizedTest
    @CsvSource({
        "100, 80, 20",
        "100, 600, -500",
        "100, 700, 100"
    })
    @Override
    public void testWithdraw(int depositAmount, int withdrawAmount, int expectedBalance) {
        this.bankAccount.deposit(depositAmount);
        this.bankAccount.withdraw(withdrawAmount);
        assertEquals(expectedBalance, this.bankAccount.getBalance());
    }
}
