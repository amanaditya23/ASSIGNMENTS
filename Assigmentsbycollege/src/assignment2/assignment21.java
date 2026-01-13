package assignment2;
import java.util.Scanner;
public class assignment21 {
	

	

	

	    interface BankingOperations {
	        void deposit(double amount);
	        void withdraw(double amount) throws InsufficientBalanceException;
	        double checkBalance();
	    }

	    interface CustomerOperations {
	        void displayCustomerDetails();
	    }

	    static class InsufficientBalanceException extends Exception {
	        public InsufficientBalanceException(String message) {
	            super(message);
	        }
	    }

	    static class BankAccount implements BankingOperations, CustomerOperations {

	        private int accountNumber;
	        private String customerName;
	        private double balance;

	        public BankAccount(int accNo, String name, double initialBalance) {
	            accountNumber = accNo;
	            customerName = name;
	            balance = initialBalance;
	        }

	        public void deposit(double amount) {
	            if (amount <= 0) {
	                System.out.println("Amount must be positive.");
	            } else {
	                balance += amount;
	                System.out.println("Deposited: ₹" + amount);
	            }
	        }

	        public void withdraw(double amount) throws InsufficientBalanceException {
	            if (amount > balance) {
	                throw new InsufficientBalanceException("Insufficient balance!");
	            }
	            balance -= amount;
	            System.out.println("Withdrawn: ₹" + amount);
	        }

	        public double checkBalance() {
	            return balance;
	        }

	        public void displayCustomerDetails() {
	            System.out.println("\n--- Customer Details ---");
	            System.out.println("Account Number : " + accountNumber);
	            System.out.println("Customer Name  : " + customerName);
	            System.out.println("Balance        : ₹" + balance);
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Customer Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Initial Balance: ");
	        double balance = sc.nextDouble();

	        BankAccount account = new BankAccount(accNo, name, balance);

	        int choice;

	        do {
	            System.out.println("\n----- Bank Menu -----");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Display Customer Details");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter amount to deposit: ");
	                    double dep = sc.nextDouble();
	                    account.deposit(dep);
	                    break;

	                case 2:
	                    System.out.print("Enter amount to withdraw: ");
	                    double wit = sc.nextDouble();
	                    try {
	                        account.withdraw(wit);
	                    } catch (InsufficientBalanceException e) {
	                        System.out.println("Exception: " + e.getMessage());
	                    }
	                    break;

	                case 3:
	                    System.out.println("Current Balance: ₹" + account.checkBalance());
	                    break;

	                case 4:
	                    account.displayCustomerDetails();
	                    break;

	                case 5:
	                    System.out.println("Thank you for using the Bank System!");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 5);

	        sc.close();
	    }
	}
