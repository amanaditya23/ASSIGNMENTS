package MiniProject;


	import java.io.*;
	import java.util.*;

	
	public class MiniProject2 {

	    // ---------- Employee class ----------
	    static class Employee implements Serializable {
	        private int id;
	        private String name;
	        private String department;
	        private double salary;

	        public Employee(int id, String name, String department, double salary) {
	            this.id = id;
	            this.name = name;
	            this.department = department;
	            this.salary = salary;
	        }

	        public int getId() { return id; }
	        public String getName() { return name; }
	        public String getDepartment() { return department; }
	        public double getSalary() { return salary; }

	        public void setSalary(double salary) { this.salary = salary; }

	        @Override
	        public String toString() {
	            return "ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: " + salary;
	        }
	    }

	    // ---------- Custom Exception ----------
	    static class InvalidEmployeeException extends Exception {
	        public InvalidEmployeeException(String msg) {
	            super(msg);
	        }
	    }

	    // ---------- File Utilities ----------
	    static final String FILE_NAME = "employees.dat";

	    static void saveToFile(HashMap<Integer, Employee> map) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
	            oos.writeObject(map);
	        } catch (IOException e) {
	            System.out.println("File Save Error: " + e.getMessage());
	        }
	    }

	    @SuppressWarnings("unchecked")
	    static HashMap<Integer, Employee> loadFromFile() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
	            return (HashMap<Integer, Employee>) ois.readObject();
	        } catch (Exception e) {
	            return new HashMap<>();
	        }
	    }

	    // ---------- Login ----------
	    static boolean login(Scanner sc) {
	        System.out.print("Username: ");
	        String user = sc.next();
	        System.out.print("Password: ");
	        String pass = sc.next();
	        return user.equals("admin") && pass.equals("1234");
	    }

	    // ---------- Main ----------
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        if (!login(sc)) {
	            System.out.println("Invalid Login!");
	            return;
	        }

	        HashMap<Integer, Employee> employees = loadFromFile();

	        while (true) {
	            System.out.println("""
	            \n1. Add Employee
	            2. Display All Employees
	            3. Search Employee by ID
	            4. Update Employee Salary
	            5. Delete Employee
	            6. Display Sorted Employees
	            7. Display Departments
	            8. Exit
	            """);

	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            try {
	                switch (choice) {

	                    case 1 -> {
	                        System.out.print("ID: ");
	                        int id = sc.nextInt();
	                        if (employees.containsKey(id))
	                            throw new InvalidEmployeeException("Employee ID must be unique.");

	                        System.out.print("Name: ");
	                        String name = sc.next();
	                        System.out.print("Department: ");
	                        String dept = sc.next();
	                        if (dept.isBlank())
	                            throw new InvalidEmployeeException("Department cannot be empty.");

	                        System.out.print("Salary: ");
	                        double sal = sc.nextDouble();
	                        if (sal <= 0)
	                            throw new InvalidEmployeeException("Salary must be positive.");

	                        employees.put(id, new Employee(id, name, dept, sal));
	                        saveToFile(employees);
	                        System.out.println("Employee added.");
	                    }

	                    case 2 -> employees.values().forEach(System.out::println);

	                    case 3 -> {
	                        System.out.print("Enter ID: ");
	                        int id = sc.nextInt();
	                        System.out.println(employees.getOrDefault(id, null));
	                    }

	                    case 4 -> {
	                        System.out.print("ID: ");
	                        int id = sc.nextInt();
	                        System.out.print("New Salary: ");
	                        double sal = sc.nextDouble();
	                        if (sal <= 0)
	                            throw new InvalidEmployeeException("Salary must be positive.");

	                        Employee e = employees.get(id);
	                        if (e == null)
	                            throw new InvalidEmployeeException("Employee not found.");

	                        e.setSalary(sal);
	                        saveToFile(employees);
	                        System.out.println("Salary updated.");
	                    }

	                    case 5 -> {
	                        System.out.print("ID: ");
	                        int id = sc.nextInt();
	                        if (employees.remove(id) == null)
	                            throw new InvalidEmployeeException("Employee not found.");
	                        saveToFile(employees);
	                        System.out.println("Employee deleted.");
	                    }

	                    case 6 -> employees.values().stream()
	                            .sorted(Comparator.comparing(Employee::getName))
	                            .forEach(System.out::println);

	                    case 7 -> employees.values().stream()
	                            .map(Employee::getDepartment)
	                            .distinct()
	                            .forEach(System.out::println);

	                    case 8 -> System.exit(0);

	                    default -> System.out.println("Invalid option.");
	                }

	            } catch (InvalidEmployeeException e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
	}


