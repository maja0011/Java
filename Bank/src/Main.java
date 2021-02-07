import java.util.Scanner;

/**
 * Main class for building the project.
 * 
 * @author Adebayo Majaro
 * @author maja0011@algonquincollege.com
 * @version 1.0
 * @since 1.0
 */
public class Main {

	/**
	 * main method to instantiate the bank object and create a menu to navigate
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner theScanner = new Scanner(System.in);
		Bank theBank = new Bank();
		char input = 'b';
		int count = 1;

		/* while loop and case for switching to methods based on input */
		while (input != 'q') {
			System.out.println("a: Add new account\nu: Update an account\nd: display an account\np: Print all accounts"
					+ "\nm: Run monthly update\nq: Quit");
			System.out.println("Enter your option :");
			input = theScanner.next().charAt(0);

			switch (input) {
			case 'a':
				System.out.println("Enter details of account holder " + count);
				System.out.println("=======================================");
				if (theBank.addAccount()) {
					System.out.println("Account created successful");
					count++;
				} else {
					System.out.println("Account creation wasn't succesful");
				}
				break;

			case 'u':

				theBank.updateAccount();
				break;

			case 'd':
				System.out.println(theBank.displayAccount());
				break;

			case 'p':
				theBank.printAccountDetails();
				break;

			case 'm':
				theBank.monthlyUpdate();
				break;

			default:
				System.out.println("How did you get here ?, please input one of the correct menu options ");
			}

		}
		System.out.println("Quitting");

	}

}
