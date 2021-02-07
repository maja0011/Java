/**
 * Person class for collecting details for a client
 * 
 * @author Adebayo Majaro
 * @author maja0011@algonquincollege.com
 * @version 1.0
 * @since 1.0
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private long phoneNumber;
	
	/*
	 * Constructor to create user object and get user information
	 */
	public Person(String firstName, String lastName, String emailAddress, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber= phoneNumber;
	}
	
	/**
	 * method for getting user name
	 * @return person's name
	 */
	public String getName() {
		return firstName + " "+lastName;
	}
	
	/**
	 * method for getting user email address
	 * @return person's email address
	 */
	public String getAddress() {
		return emailAddress;
	}
	
	/**
	 * method for getting user's phone number
	 * @return person's phone number
	 */
	public long getNumber() {
		return phoneNumber;
	}
	

}
