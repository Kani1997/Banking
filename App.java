package Com.BankingApplication.App;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;

import Com.BankingApplication.user.User;


public class App {

	public static User user = new User();
	private static final String amount = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		User user = null;
		boolean stayInLoop = true;

		while (stayInLoop) {
			if (user == null) {
				try {
					user = signInOrCreateNewUser(0, null);
				} catch (IOException exception) {
					System.out.println("There was an error creating your account ,Let's try that gain");
					continue;

				}

			}
			displayOptions(user);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String response = bufferedReader.readLine();

			switch (response) {
			case "1":
				boolean depositSuccessful = false;
				while (!depositSuccessful) {
					System.out.println("How much would you like to deposit?");
					//String amount = bufferedReader.readLine();
					Scanner s = new Scanner(System.in);
					int ConvetedAmount=0;
					ConvetedAmount=s.nextInt();
					//Float ConvetedAmount = isValidNumber(amount);
					if (ConvetedAmount >0) {
						user.depositMoney(ConvetedAmount);
						displayAccountBalance(user);
						depositSuccessful = true;

					} else {
						System.out.println("Thast's not a valid number");
					}
				}
				break;

			case "2":
				boolean withdrawSuccessful = false;
				while (!withdrawSuccessful) {
					System.out.println("How much do want to withdraw?");
					Scanner s = new Scanner(System.in);
					int ConvetedAmount=0;
					ConvetedAmount=s.nextInt();
				
					if (ConvetedAmount >= 0) {
						user.withdrawMoney(ConvetedAmount);
						displayAccountBalance(user);
						withdrawSuccessful = true;

					} else {
						System.out.println("Thast's not a valid number");
					}
				}
				break;
			case "3":
				displayAccountBalance(user);
				break;

			case "4":
				stayInLoop = false;
				break;

			default:
				System.out.println("Not a valid option,please try again.\n");
			}
		}
	}

	private static User signInOrCreateNewUser(float accountBalance, String firstName) throws IOException {
		System.out.println("Welcome to the Bank Project\n");

		System.out.println("Let's get started and created and acount for you\n");
		System.out.println("What is ur firstName\n");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String firstName1 = reader.readLine();
		user.setFirstName(firstName1);

		System.out.println("What is ur lastName\n");
		String lastName = reader.readLine();
		user.setLastName(lastName);

		System.out.println("What is your email\n");
		String email = reader.readLine();
		user.setEmail(email);

		int pinvalid;
		boolean isValidpin = false;
		while (!isValidpin) {
			System.out.println("What do you want your pin to be?(Needs to ba a 4 digit number)\n");
			Scanner s = new Scanner(System.in);
//pin =reader.readLine();
			pinvalid = s.nextInt();

			String pin = Integer.toString(pinvalid);
			user.setPin(pinvalid);
//computing the size of the string  
			int size = pin.length();

			if (size == 4) {
				// System.out.println("To check loop");
//Float integer =isValidNumber(pin);

				if (size == 4) {
					System.out.println("Pin was valid, Kindly proceed");
				} else {
					System.out.println("Pin was not 4 digits long\n");
				}
			}

		//Arju	User user = new User(firstName1, lastName, pinvalid, email, accountBalance);
			System.out.println("Would you like to make an intial deposit? Type yes if you want to you \n");
			String answer = reader.readLine();
			int amount = 0;
			if ("Yes".equalsIgnoreCase(answer)) {
				System.out.println("Great ! how much\n");
				Scanner st = new Scanner(System.in);
				amount = st.nextInt();
				user.depositMoney(amount);
				user.setAccountBalance(amount);

//Float   convertedAmount =isValidNumber(amount);
				if (amount <= 0) {

					System.out.println("Thats's not valid amount\n");
				} else {
					System.out.println("This Amount deposited succesfully\n");
					isValidpin = true;

				}
			} else {
				System.out.println("user rejected deposit amount");
			}
		}
		return user;
	}

	private static Float isValidNumber(String value) {
		try {
			Float isValid = Float.parseFloat(value);
			return isValid;
		} catch (Exception exception) {
			return null;

		}
	}

	private static void displayOptions(User user2) {
		System.out.println("Hello" + User.getFirstName() + " what operation need to perform ?\n");
		System.out.println("1.Deposit\n");
		System.out.println("2.Withdraw\n");
		System.out.println("3.Check Balance\n");
		System.out.println("4.Exit\n");
		System.out.println("Enter 1,2,3,or 4.\n");

	}

	private static void displayAccountBalance(User user) {
		System.out.println("Your new balance is $" + user.getAccountBalance());
	}
	
}
