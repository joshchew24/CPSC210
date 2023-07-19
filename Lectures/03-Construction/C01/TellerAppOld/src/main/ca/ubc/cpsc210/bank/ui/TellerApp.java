package ca.ubc.cpsc210.bank.ui;

import ca.ubc.cpsc210.bank.exception.BankingException;
import ca.ubc.cpsc210.bank.exception.InsufficientFundsException;
import ca.ubc.cpsc210.bank.exception.MoneyLaunderingException;
import ca.ubc.cpsc210.bank.exception.NegativeInputException;
import ca.ubc.cpsc210.bank.model.Account;
import ca.ubc.cpsc210.bank.persistence.Reader;
import ca.ubc.cpsc210.bank.persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;


// Bank teller application
public class TellerApp {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private Account cheq;
    private Account sav;
    private Scanner input;

    // EFFECTS: runs the teller application
    public TellerApp() {
        runTeller();
    }

    // MODIFIES: this
    // EFFECTS: loads acconts from ACCOUNTS_FILE, if that

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTeller() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        loadAccounts();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    private void loadAccounts() {
        try {
            List<Account> accounts = Reader.readAccounts(new File(ACCOUNTS_FILE));
            cheq = accounts.get(0);
            sav = accounts.get(1);
        } catch (IOException e) {
            init();
        }
    }

    // EFFECTS: saves state of chequing and savings accounts to ACCOUNTS_FILE
    private void saveAccounts() {
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(cheq);
            writer.write(sav);
            writer.close();
            System.out.println("Accounts saved to file " + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to " + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("d")) {
            doDeposit();
        } else if (command.equals("w")) {
            doWithdrawal();
        } else if (command.equals("t")) {
            doTransfer();
        } else if (command.equals("s")) {
            saveAccounts();
        } else if (command.equals("p")) {
            printAccount();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        cheq = new Account("Joe", 145.00);
        sav = new Account("Joe", 256.50);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> deposit");
        System.out.println("\tw -> withdraw");
        System.out.println("\tt -> transfer");
        System.out.println("\ts -> save accounts to file");
        System.out.println("\tp -> print to screen");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void doDeposit() {
        Account selected = selectAccount();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();

        try {
            selected.deposit(amount);
        } catch (NegativeInputException e) {
            System.out.println("Cannot deposit negative amount...\n");
        } catch (MoneyLaunderingException e) {
            System.out.println("You're not allowed to deposit that much money in a single transaction.");
        }

        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doWithdrawal() {
        Account selected = selectAccount();
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();

        try {
            selected.withdraw(amount);
        } catch (NegativeInputException e) {
            System.out.println("Cannot withdraw negative amount...\n");
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient balance on account...\n");
        }

        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a transfer transaction
    private void doTransfer() {
        System.out.println("\nTransfer from?");
        Account source = selectAccount();
        System.out.println("Transfer to?");
        Account destination = selectAccount();

        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();

        try {
            source.withdraw(amount);
            destination.deposit(amount);
        } catch (BankingException e) {
            System.out.println("Your transfer operation cannot be completed!");
        }

        System.out.print("Source ");
        printBalance(source);
        System.out.print("Destination ");
        printBalance(destination);
    }

    // EFFECTS: prompts user to select an account and prints account to screen
    private void printAccount() {
        Account selected = selectAccount();
        System.out.println("Id: " + selected.getId());
        System.out.println("Account holder: " + selected.getName());
        printBalance(selected);
    }

    // EFFECTS: prompts user to select chequing or savings account and returns it
    private Account selectAccount() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("c") || selection.equals("s"))) {
            System.out.println("c for chequing");
            System.out.println("s for savings");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("c")) {
            return cheq;
        } else {
            return sav;
        }
    }

    // EFFECTS: prints balance of account to the screen
    private void printBalance(Account selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}
