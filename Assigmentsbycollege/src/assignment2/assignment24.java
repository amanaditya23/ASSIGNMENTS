package assignment2;


	import java.util.*;
	import java.util.regex.*;

	interface EmployeeOperations {
	    void addEmployee(Scanner sc);
	    void displayEmployees();
	    void searchEmployee(int id);
	    void removeEmployee(int id);
	}

	class Employee {
	    int id;
	    String name;
	    String dept;

	    Employee(int id, String name, String dept) {
	        this.id = id;
	        this.name = name;
	        this.dept = dept;
	    }

	    public String toString() {
	        return id + " " + name + " " + dept;
	    }
	}

	public class assignment24  implements EmployeeOperations {

	    Map<Integer, Employee> map;

	    assignment24(Map<Integer, Employee> map) {
	        this.map = map;
	    }

	    public void addEmployee(Scanner sc) {
	        try {
	            System.out.print("ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Name: ");
	            String name = sc.nextLine();

	            if (!Pattern.matches("[A-Za-z ]+", name))
	                throw new Exception("Invalid name format");

	            System.out.print("Department: ");
	            String dept = sc.nextLine();

	            map.put(id, new Employee(id, name, dept));
	            System.out.println("Employee added");

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	            sc.nextLine();
	        }
	    }

	    public void displayEmployees() {
	        if (map.isEmpty()) {
	            System.out.println("No employees found");
	            return;
	        }
	        map.values().forEach(System.out::println);
	    }

	    public void searchEmployee(int id) {
	        Employee e = map.get(id);
	        if (e != null)
	            System.out.println(e);
	        else
	            System.out.println("Employee not found");
	    }

	    public void removeEmployee(int id) {
	        if (map.remove(id) != null)
	            System.out.println("Employee removed");
	        else
	            System.out.println("Employee not found");
	    }

	    static void demonstrateNullSupport() {
	        Map<Integer, String> hmap = new HashMap<>();
	        Map<Integer, String> htable = new Hashtable<>();
	        Map<Integer, String> tmap = new TreeMap<>();

	        System.out.println("\n--- Null Support Demonstration ---");

	        try {
	            hmap.put(null, "Allowed");
	            hmap.put(1, null);
	            System.out.println("HashMap supports null key & value");
	        } catch (Exception e) {
	            System.out.println("HashMap: " + e);
	        }

	        try {
	            htable.put(null, "Not Allowed");
	        } catch (Exception e) {
	            System.out.println("Hashtable does NOT support null key");
	        }

	        try {
	            tmap.put(null, "Not Allowed");
	        } catch (Exception e) {
	            System.out.println("TreeMap does NOT support null key");
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.println("Choose Map Implementation:");
	        System.out.println("1.HashMap  2.Hashtable  3.TreeMap");

	        int choice = sc.nextInt();
	        sc.nextLine();

	        Map<Integer, Employee> selectedMap;

	        switch (choice) {
	            case 1 -> selectedMap = new HashMap<>();
	            case 2 -> selectedMap = new Hashtable<>();
	            case 3 -> selectedMap = new TreeMap<>();
	            default -> {
	                System.out.println("Invalid choice");
	                return;
	            }
	        }

	        assignment24 er = new assignment24(selectedMap);

	        while (true) {
	            System.out.println("\n1.Add  2.Display  3.Search  4.Remove  5.Null Demo  6.Exit");
	            int ch = sc.nextInt();

	            switch (ch) {
	                case 1 -> er.addEmployee(sc);
	                case 2 -> er.displayEmployees();
	                case 3 -> {
	                    System.out.print("Enter ID: ");
	                    er.searchEmployee(sc.nextInt());
	                }
	                case 4 -> {
	                    System.out.print("Enter ID: ");
	                    er.removeEmployee(sc.nextInt());
	                }
	                case 5 -> demonstrateNullSupport();
	                case 6 -> System.exit(0);
	                default -> System.out.println("Invalid option");
	            }
	        }
	    }
	}


