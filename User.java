package Com.BankingApplication.user;

public class User {
	// Creating detail of atm project first name,lastname, pin
	// number,email,accountbalance.
	private static String firstName;
	private String lastName;
	private int pin;
	private String email;
	private float accountBalance;

	/*
	 * public User(String firstName, String lastName,int pin ,String email,float
	 * accountBalanace ) { this.firstName=firstName; this.lastName=lastName;
	 * this.email=email; //this.pin=pin; this.accountBalance = accountBalance;
	 * 
	 * }
	 */

	public static String getFirstName() {
		return firstName;
	}

	/*
	 * public User(String firstName, String lastName, int pin, String email, float
	 * accountBalance) {
	 * 
	 * this.lastName = lastName; this.pin = pin; this.email = email;
	 * this.accountBalance = accountBalance; }
	 */
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public float depositMoney(float amount) {
		this.accountBalance += amount;
		return this.accountBalance;
	}

	public float withdrawMoney(int amount) {
		this.accountBalance -= amount;
		return this.accountBalance;

	}

}
