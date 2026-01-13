package MiniProject;

import java.io.*;
import java.util.*;

abstract class BankAccount implements Serializable {
    private int accNo;
    private String name;
    protected double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccNo() { return accNo; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amt) {
        balance += amt;
    }

    public void deposit(int amt) {
        balance += amt;
    }

    abstract void withdraw(double amt);

    public void displayDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    void withdraw(double amt) {
        if (balance - amt >= 500)
            balance -= amt;
        else
            System.out.println("Minimum balance 500 required.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account");
        super.displayDetails();
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    void withdraw(double amt) {
        if (balance >= amt)
            balance -= amt;
        else
            System.out.println("Insufficient balance.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Current Account");
        super.displayDetails();
    }
}

public class MiniProject1 {

    static final String FILE = "accounts.dat";
    static Map<Integer, BankAccount> accounts = new HashMap<>();

    static void saveToFile() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
        oos.writeObject(accounts);
        oos.close();
    }

    static void loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
            accounts = (Map<Integer, BankAccount>) ois.readObject();
            ois.close();
        } catch (Exception e) { }
    }

    static void createAccount(Scanner sc) throws Exception {
        System.out.print("Account No: ");
        int no = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("Type (1.Savings 2.Current): ");
        int t = sc.nextInt();

        BankAccount acc;
        if (t == 1)
            acc = new SavingsAccount(no, name, bal);
        else
            acc = new CurrentAccount(no, name, bal);

        accounts.put(no, acc);
        saveToFile();
        System.out.println("Account created.");
    }

    static void deposit(Scanner sc) throws Exception {
        System.out.print("Account No: ");
        int no = sc.nextInt();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();

        BankAccount acc = accounts.get(no);
        if (acc != null) {
            acc.deposit(amt);
            saveToFile();
            System.out.println("Deposited.");
        } else System.out.println("Account not found.");
    }

    static void withdraw(Scanner sc) throws Exception {
        System.out.print("Account No: ");
        int no = sc.nextInt();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();

        BankAccount acc = accounts.get(no);
        if (acc != null) {
            acc.withdraw(amt);
            saveToFile();
        } else System.out.println("Account not found.");
    }

    static void balanceEnquiry(Scanner sc) {
        System.out.print("Account No: ");
        int no = sc.nextInt();
        BankAccount acc = accounts.get(no);
        if (acc != null)
            System.out.println("Balance: " + acc.getBalance());
        else
            System.out.println("Account not found.");
    }

    static void displayDetails(Scanner sc) {
        System.out.print("Account No: ");
        int no = sc.nextInt();
        BankAccount acc = accounts.get(no);
        if (acc != null)
            acc.displayDetails();
        else
            System.out.println("Account not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Balance 5.Display 6.Exit");
            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1 -> createAccount(sc);
                    case 2 -> deposit(sc);
                    case 3 -> withdraw(sc);
                    case 4 -> balanceEnquiry(sc);
                    case 5 -> displayDetails(sc);
                    case 6 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
