import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Bank Account class for creating new bank account
 * 
 * @author Adebayo Majaro
 * @author maja0011@algonquincollege.com
 * @version 1.0
 * @since 1.0
 */
public class Bank {

	private ArrayList<BankAccount> accounts;
	private int numAccounts;
	private int theAccountnum;
	private Scanner theScanner;

	/**
	 * Bank class constructor for initializing variables
	 */
	public Bank() {
		accounts = new ArrayList<BankAccount>(); // Creating an array to store all the bank accounts
		theScanner = new Scanner(System.in);
		numAccounts = 0;
	}

	/**
	 * addAccount method for creating a type of account and return success or fail
	 * 
	 * @return true/false depending on if account creation is suceesd=ful
	 */
	public boolean addAccount() {
		char accType;
		System.out.println("Enter account type (s for savings, c for checking): ");
		accType = theScanner.next().charAt(0);

		/*
		 * if statement to create either a savings account or chequing, depending on
		 * user input
		 */
		if (accType == 's') {
			accounts.add(new SavingsAccount());

		} else if (accType == 'c') {
			accounts.add(new ChequingAccount());
		} else {
			System.out.println("Error, account wasn't created");
			return false;
		}

		/*
		 * if addBankaccount method in Bankaccount class is successful, increment number
		 * of account
		 */
		if ((accounts.get(numAccounts).addBankAccount())) {
			numAccounts++;
		} else {
			System.out.println("Account not added");
		}
		return true;
	}

	/**
	 * Display account method for displaying specific account based on input
	 * 
	 * @return String contain account holder details
	 */
	public String displayAccount() {
		int input = -1;
		System.out.println("Enter account number: ");

		boolean answer = false;

		/* while statement to check for input mismatch */
		while (!answer) {

			try {
				input = theScanner.nextInt();
				if (input < 0) {
					System.out.println("Enter a positive account number : ");
					System.out.println("Enter account number again");

				} else {
					answer = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the account number");
				System.out.println("Enter account number again");
				theScanner.next();
			}

		}
		/* for loop to check array of accounts to find if input matches any accounts */
		for (int i = 0; i < accounts.size(); i++) {

			if (input == accounts.get(i).accNumber) {
				return accounts.get(i).toString();
			}

		}
		return "The account number inputed was not found";

	}

	/**
	 * Prints out all of the account details stored in the array
	 */
	public void printAccountDetails() {
		System.out.println("Banking System \n*************");
		System.out.println("Number of Account holders: " + accounts.size());

		for (int i = 0; i < accounts.size(); i++) {

			System.out.println(accounts.get(i).toString());

		}
	}

	/**
	 * Update the balance of an account based on user input(positive or negative)
	 */
	public void updateAccount() {
		int input = -1;
		double amount = 0;
		boolean answer = false;
		System.out.println("Enter account number");

		/* while statement to check for input mismatch */
		while (!answer) {

			try {
				input = theScanner.nextInt();
				answer = true;

			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the account number");
				System.out.println("Enter account number again");
				theScanner.next();
			}

		}

		/* For loop to check if account number is valid and update if valid. */
		for (int i = 0; i < accounts.size(); i++) {
			if (input == accounts.get(i).accNumber) {
				theAccountnum = i;
				theScanner.nextLine();
				System.out.println(
						"Enter amount to deposit/withdraw (positive number for deposit, negative number to withdraw):");
				while (answer) {
					try {
						amount = theScanner.nextDouble();

						answer = false;

					} catch (InputMismatchException e) {
						System.out.println("You inputed the wrong format for the amount");
						System.out.println("Enter amount again");
						theScanner.next();
					}
				}

				accounts.get(theAccountnum).updateBalance(amount);

			} else {
				System.out.println("The account number inputed was not found");
			}
		}

	}

	/**
	 * Update all of the accounts based on each accounts version of monthly update
	 */
	public void monthlyUpdate() {
		for (int i = 0; i < accounts.size(); i++) {
			accounts.get(i).monthlyAccountUpdate();
		}
	}

}
