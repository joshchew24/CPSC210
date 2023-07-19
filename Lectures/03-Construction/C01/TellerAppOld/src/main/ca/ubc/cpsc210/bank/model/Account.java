package ca.ubc.cpsc210.bank.model;

import ca.ubc.cpsc210.bank.exception.InsufficientFundsException;
import ca.ubc.cpsc210.bank.exception.MoneyLaunderingException;
import ca.ubc.cpsc210.bank.exception.NegativeInputException;
import ca.ubc.cpsc210.bank.persistence.Reader;
import ca.ubc.cpsc210.bank.persistence.Saveable;

import java.io.PrintWriter;

// Represents an account having an id, owner name and balance (in dollars)
// Invariant: getBalance() >= 0
public class Account implements Saveable {
    private static int nextAccountId = 1;  // tracks id of next account created
    private int id;                        // account id
    private String name;                   // the account owner name
    private double balance;                // the current balance of the account

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName; account id is a
     *          positive integer not assigned to any other account;
     *          if initialBalance >= 0 then balance on account is set to
     *          initialBalance, otherwise balance is zero.
     */
    public Account(String accountName, double initialBalance) {
        id = nextAccountId++;
        name = accountName;
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
        checkBalanceInvariant();
    }

    /*
     * REQUIRES: name has a non-zero length, balance >= 0
     * EFFECTS: constructs an account with id, name and balance;
     * nextAccountId is the id of the next account to be constructed
     * NOTE: this constructor is to be used only when constructing
     * an account from data stored in file
     */
    public Account(int nextId, int id, String name, double balance) {
        nextAccountId = nextId;
        this.id = id;
        this.name = name;
        this.balance = balance;
        checkBalanceInvariant();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    /*
     * MODIFIES: this
     * EFFECTS: if amount < 0, throws NegativeInputException
     *          otherwise amount is added to balance and updated
     *          balance is returned
     */
    public double deposit(double amount) throws NegativeInputException {
        if (amount < 0) {
            throw new NegativeInputException();
        }
        if (amount > 1000000) {
            throw new MoneyLaunderingException();
        }
        balance = balance + amount;
        checkBalanceInvariant();
        return balance;
    }

    /*
     * MODIFIES: this
     * EFFECTS: if amount < 0 , throws NegativeInputException
     *          otherwise if amount > getBalance() throws InsufficientFundsException
     *          otherwise amount is withdrawn from account and updated
     *          balance is returned
     */
    public double withdraw(double amount) throws NegativeInputException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeInputException();
        }
        if (amount > balance) {
            throw new InsufficientFundsException();
        } else {
            balance = balance - amount;
            checkBalanceInvariant();
            return balance;
        }
    }

    /*
     * EFFECTS: returns a string representation of account
     */
    @Override
    public String toString() {
        String balanceStr = String.format("%.2f", balance);  // get balance to 2 decimal places as a string
        return "[ id = " + id + ", name = " + name + ", "
                + "balance = $" + balanceStr + "]";
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(nextAccountId);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(id);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(name);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(balance);
    }

    private void checkBalanceInvariant() {
        assert (balance >= 0);
    }
}
