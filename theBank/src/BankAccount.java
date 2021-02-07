import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * abstract bank account class represents a blueprint that the and personalizes
 * it.
 * 
 * @author Adebayo Majaro
 * @author maja0011@algonquincollege.com
 * @version 1.0
 * @since 1.0
 */
public abstract class BankAccount {
	private Person theUser;
	protected int accNumber;
	protected double balance;
	private Scanner theScanner;

	/**
	 * Bankaccount constructor for initializing variables
	 */
	public BankAccount() {
		theScanner = new Scanner(System.in);
		accNumber = -1;
		balance = 0;
	}

	/**
	 * Initializes steps required for client's account creation
	 * 
	 * @return true/false depending on if account creation is successful
	 */
	public boolean addBankAccount() {
		String firstName, lastName, emailAddress;
		long phoneNumber = -1;

		System.out.println("Enter account number :");

		boolean answer = false;

		/* while statement to check for input mismatch */
		while (!answer) {

			try {
				accNumber = theScanner.nextInt();
				if (accNumber < 0) {
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
		theScanner.nextLine();
		System.out.println("Enter first name of account holder : ");
		firstName = theScanner.nextLine();

		System.out.println("Enter last name of account holder : ");
		lastName = theScanner.nextLine();

		System.out.println("Enter phone number: ");

		/* while statement to check for input mismatch */
		while (answer) {

			try {
				phoneNumber = theScanner.nextLong();
				if (phoneNumber < 0) {
					System.out.println("Enter a positive phone number : ");
					System.out.println("Enter phone number again");

				} else {
					answer = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the phone number");
				System.out.println("Enter phone number again");
				theScanner.next();
			}

		}
		theScanner.nextLine();
		System.out.println("Enter Email address of account holder : ");
		emailAddress = theScanner.nextLine();

		System.out.println("Enter opening balance : ");
		while (!answer) {

			try {
				balance = theScanner.nextDouble();
				if (balance < 0) {
					System.out.println("Phone balance can't be negative ");
					System.out.println("Enter phone balance again");

				} else {
					answer = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the balance");
				System.out.println("Enter phone balance again");
				theScanner.next();
			}

		}
		theScanner.nextLine();

		theUser = new Person(firstName, lastName, emailAddress,
				phoneNumber); /* Creates a new user for based on user input */
		return true;

	}

	/**
	 * Updates a client's balance from input received
	 * 
	 * @param input Value required to update client's account
	 */
	public void updateBalance(double input) {

		balance = balance + input;
	}

	/**
	 * Prints out the details of user
	 */
	public String toString() {
		String output;
		output = "AccountNumber: " + accNumber + " Name: " + theUser.getName() + " Phone Number: " + theUser.getNumber()
				+ " Email Address: " + theUser.getAddress() + " Balance: " + balance;
		return output;
	}

	/**
	 * abstract method that would be overriden in subclasses
	 */
	public abstract void monthlyAccountUpdate();

}
