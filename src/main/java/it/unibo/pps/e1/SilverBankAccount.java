package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount{
    private final BankAccount bankAccount;

    SilverBankAccount(
        BankAccount bankAccount
    ) {
        this.bankAccount = bankAccount;
    }

    public int getBalance() {
        return bankAccount.getBalance();
    }

    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    private int calculateFee(int amount) {
        return 1;
    }

    private boolean canWithdraw(int amount) {
        return amount <= bankAccount.getBalance();
    }

    public void withdraw(int amount) {
        int withdrawWithFee = amount + calculateFee(amount);
        if (canWithdraw(withdrawWithFee)) {
            bankAccount.withdraw(withdrawWithFee);
        }
    }
}
