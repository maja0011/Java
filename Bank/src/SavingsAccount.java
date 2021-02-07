import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Savings class inherits from bankaccount class and overides certain methods
 * and personalizes it.
 * 
 * @author Adebayo Majaro
 * @author maja0011@algonquincollege.com
 * @version 1.0
 * @since 1.0
 */
public class SavingsAccount extends BankAccount {

	private double minBalance;
	private double interestRate;
	private Scanner theScanner;

	/**
	 * Savings constructor for initializing variables
	 */
	public SavingsAccount() {
		theScanner = new Scanner(System.in);
		minBalance = -1;
		interestRate = -1;
	}

	/**
	 * Method calls it's super version(Bank account) then adds more details to it's
	 * account creation here.
	 * 
	 * @return true/false depending on if account creation is successful
	 */
	public boolean addBankAccount() {
		boolean answer = false;
		super.addBankAccount();
		System.out.println("Enter minimum balance : ");

		/* while statement to check for input mismatch */
		while (!answer) {

			try {
				minBalance = theScanner.nextDouble();
				if (minBalance < 0) {
					System.out.println("minimum balance can't be negative ");
					System.out.println("Enter minimum balance again");

				} else {
					answer = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the balance");
				System.out.println("Enter minimum balance again");
				theScanner.next();
			}

		}

		System.out.println("Enter interest rate (should be a number in (0,1)): ");

		/* while statement to check for input mismatch */
		while (answer) {

			try {
				interestRate = theScanner.nextDouble();
				if (interestRate < 0) {
					System.out.println("interest rate can't be negative ");
					System.out.println("Enter interest rate again");

				} else {
					answer = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the interest rate");
				System.out.println("Enter interest rate again");
				theScanner.next();
			}

		}
		theScanner.nextLine();
		return true;

	}

	/**
	 * Prints out the details of the user and client's saving's account
	 * 
	 * @return String containing client's information
	 */
	public String toString() {
		String output;

		output = super.toString() + " Minimum Balance: " + minBalance + " Interest Rate: " + interestRate;
		return output;

	}

	/**
	 * override absract method inherited from bankaccount and personalizes it. Runs
	 * a monthly update on all of the bank accounts
	 */
	@Override
	public void monthlyAccountUpdate() {
		double interest = 0;
		if (super.balance > minBalance) {
			interest = ((interestRate) * super.balance);
			super.balance = interest + super.balance;

		} else {
			System.out.println("Error the balance is not enough for a monthly upddate");
		}

	}

}
