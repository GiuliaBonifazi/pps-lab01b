package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount{
    private final BankAccount bankAccount;

    public BronzeBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    private int calculateFee(int amount) {
        return amount > 100 ? 1 : 0;
    }

    private boolean canWithdraw(int amount) {
        return amount <= bankAccount.getBalance();
    }

    @Override
    public void withdraw(int amount) {
        int withdrawWithFee = amount + calculateFee(amount);
        if (canWithdraw(withdrawWithFee)) {
            bankAccount.withdraw(withdrawWithFee);
        }
    }
}
