package assignment2;


	import java.util.Scanner;
	import java.util.regex.Pattern;
	import java.util.regex.Matcher;

	public class assignment22 {
	
	    static Scanner sc = new Scanner(System.in);

	    // Regex patterns
	    static final String MOBILE_REGEX   = "^[6-9][0-9]{9}$";
	    static final String EMAIL_REGEX    = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	    static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
	    static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!]).{6,}$";

	    public static void main(String[] args) {

	        int choice;

	        do {
	            System.out.println("\n--- REGEX VALIDATION MENU ---");
	            System.out.println("1. Validate Mobile Number");
	            System.out.println("2. Validate Email ID");
	            System.out.println("3. Validate Username");
	            System.out.println("4. Validate Password");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            try {
	                choice = Integer.parseInt(sc.nextLine());

	                switch (choice) {
	                    case 1:
	                        validateInput("Enter Mobile Number: ", MOBILE_REGEX);
	                        break;
	                    case 2:
	                        validateInput("Enter Email ID: ", EMAIL_REGEX);
	                        break;
	                    case 3:
	                        validateInput("Enter Username: ", USERNAME_REGEX);
	                        break;
	                    case 4:
	                        validateInput("Enter Password: ", PASSWORD_REGEX);
	                        break;
	                    case 5:
	                        System.out.println("Thank you! Exiting...");
	                        break;
	                    default:
	                        System.out.println("Invalid choice!");
	                }

	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number!");
	                choice = 0;
	            }

	        } while (choice != 5);

	        sc.close();
	    }

	    static void validateInput(String message, String regex) {
	        System.out.print(message);
	        String input = sc.nextLine();

	        try {
	            Pattern pattern = Pattern.compile(regex);
	            Matcher matcher = pattern.matcher(input);

	            if (matcher.matches()) {
	                System.out.println("Valid Input! Welcome 😊");
	            } else {
	                System.out.println("Invalid Input ❌");
	            }

	        } catch (Exception e) {
	            System.out.println("Error occurred during validation.");
	        }
	    }
	}


