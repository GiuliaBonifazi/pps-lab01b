package it.unibo.pps.e1;

public interface BankAccount {

    /**
     * Get the current balance of the account
     *
     * @return The current account balance
     */
    int getBalance();

    /**
     * Deposit an amount of money into the account
     *
     * @param amount The amount of money to be deposited
     */
    void deposit(int amount);

    /**
     * Withdraw an amount of money from the account, in accordance with
     * the withdrawal policy.
     *
     * @param amount The amount of money to be withdrawn
     */
    void withdraw(int amount);
}
