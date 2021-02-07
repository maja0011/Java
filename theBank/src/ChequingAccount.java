import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Chequing class inherits from bankaccount class and overides certain methods
 * and personalizes it.
 * 
 * @author Adebayo Majaro
 * @author maja0011@algonquincollege.com
 * @version 1.0
 * @since 1.0
 */
public class ChequingAccount extends BankAccount {
	private double fee;
	private Scanner theScanner;

	/**
	 * chequing constructor for initializing variables
	 */
	public ChequingAccount() {
		fee = 0;
		theScanner = new Scanner(System.in);
	}

	/**
	 * Method calls it's super version(Bank account) then adds more details to it's account
	 * creation here.
	 * 
	 * @return true/false depending on if account creation is successful
	 */
	public boolean addBankAccount() {
		boolean answer = false;
		super.addBankAccount(); /* calling the super addBankaccount first */
		System.out.println("Enter monthly fee : ");

		/* while statement to check for input mismatch */
		while (!answer) {

			try {
				fee = theScanner.nextDouble();
				if (fee < 0) {
					System.out.println("monthly fee can't be negative ");
					System.out.println("Enter monthly fee again");

				} else {
					answer = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("You inputed the wrong format for the monthly fee");
				System.out.println("Enter monthly fee again");
				theScanner.next();
			}

		}

		theScanner.nextLine();
		return true;

	}

	/**
	 * Prints out the details of the user and client's chequing account
	 * 
	 * @return String containing client's information
	 */
	public String toString() {
		String output;

		output = super.toString() + " Fee: " + fee;
		return output;

	}

	/**
	 * override absract method inherited from bankaccount and personalizes it. Runs
	 * a monthly update on all of the bank accounts
	 */
	@Override
	public void monthlyAccountUpdate() {

		if (super.balance > fee) {

			super.balance = super.balance - fee;

		} else {
			System.out.println("Error the balance is not enough for a monthly upddate");
		}

	}

}
