package assignment1;


	import java.util.Scanner;

	public class assignment15 {

	    static int accNo;
	    static String name;
	    static double balance;

	    static Scanner sc = new Scanner(System.in);

	    // Create account
	    static void createAccount() {
	        System.out.print("Enter Account Number: ");
	        accNo = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Account Holder Name: ");
	        name = sc.nextLine();

	        System.out.print("Enter Initial Balance: ");
	        balance = sc.nextDouble();

	        System.out.println("Account Created Successfully");
	    }

	    // Deposit
	    static void deposit() {
	        System.out.print("Enter deposit amount: ");
	        double amt = sc.nextDouble();

	        if (amt <= 0) {
	            System.out.println("Invalid amount");
	            return;
	        }

	        balance += amt;
	        System.out.println("Amount Deposited");
	    }

	    // Withdraw
	    static void withdraw() {
	        System.out.print("Enter withdrawal amount: ");
	        double amt = sc.nextDouble();

	        if (amt <= 0) {
	            System.out.println("Invalid amount");
	        } else if (amt > balance) {
	            System.out.println("Insufficient Balance");
	        } else {
	            balance -= amt;
	            System.out.println("Amount Withdrawn");
	        }
	    }

	    // Balance enquiry
	    static void checkBalance() {
	        System.out.println("Current Balance: " + balance);
	    }

	    // Display account details
	    static void displayDetails() {
	        System.out.println("Account Number: " + accNo);
	        System.out.println("Account Holder: " + name);
	        System.out.println("Balance: " + balance);
	    }

	    public static void main(String[] args) {

	        createAccount();

	        while (true) {
	            System.out.println("\n--- BANK MENU ---");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Balance Enquiry");
	            System.out.println("4. Account Details");
	            System.out.println("5. Exit");

	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            try {
	                switch (choice) {
	                    case 1:
	                        deposit();
	                        break;
	                    case 2:
	                        withdraw();
	                        break;
	                    case 3:
	                        checkBalance();
	                        break;
	                    case 4:
	                        displayDetails();
	                        break;
	                    case 5:
	                        System.out.println("Thank You");
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid Choice");
	                }
	            } catch (Exception e) {
	                System.out.println("Invalid Input");
	                sc.next();
	            }
	        }
	    }
	}

