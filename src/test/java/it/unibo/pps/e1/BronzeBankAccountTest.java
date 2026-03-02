package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBankAccountTest extends BankAccountTest{

    @BeforeEach
    @Override
    void init() {
        BankAccount coreBankAccount = new CoreBankAccount();
        this.bankAccount = new BronzeBankAccount(coreBankAccount);
    }

    @ParameterizedTest
    @CsvSource({
        "100, 80, 20",
        "200, 150, 49",
        "100, 200, 100"
    })
    @Override
    public void testWithdraw(int depositAmount, int withdrawAmount, int expectedBalance) {
        bankAccount.deposit(depositAmount);
        bankAccount.withdraw(withdrawAmount);
        assertEquals(expectedBalance, bankAccount.getBalance());
    }
}
