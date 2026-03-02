package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{
    private final static int MAXIMUM_OVERDRAFT = -500;
    private final BankAccount bankAccount;

    GoldBankAccount(BankAccount bankAccount) {
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
        return 0;
    }

    private boolean canWithdraw(int amount) {
        return bankAccount.getBalance() - amount >= MAXIMUM_OVERDRAFT;
    }

    @Override
    public void withdraw(int amount) {
        int withdrawWithFee = calculateFee(amount) + amount;
        if (canWithdraw(withdrawWithFee)) {
            bankAccount.withdraw(withdrawWithFee);
        }
    }
}
