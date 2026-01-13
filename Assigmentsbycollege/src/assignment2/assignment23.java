package assignment2;


	import java.util.*;
	import java.util.regex.*;

	public class assignment23 {

	    // Interface
	    interface StudentOperations {
	        void addStudent(Student s);
	        void displayStudents();
	        void removeStudent(int roll);
	        void searchStudent(int roll);
	    }

	    // Student class
	    static class Student {
	        int roll;
	        String name;
	        String email;

	        Student(int roll, String name, String email) {
	            this.roll = roll;
	            this.name = name;
	            this.email = email;
	        }

	        public String toString() {
	            return "Roll: " + roll + ", Name: " + name + ", Email: " + email;
	        }
	    }

	    // Implementation using different collections
	    static class StudentManager implements StudentOperations {

	        List<Student> arrayList = new ArrayList<>();
	        Vector<Student> vector = new Vector<>();
	        List<Student> list = new LinkedList<>();

	        public void addStudent(Student s) {
	            arrayList.add(s);
	            vector.add(s);
	            list.add(s);
	            System.out.println("Student added successfully.");
	        }

	        public void displayStudents() {
	            if (arrayList.isEmpty()) {
	                System.out.println("No students available.");
	                return;
	            }
	            System.out.println("\n--- Student Records ---");
	            for (Student s : arrayList) {
	                System.out.println(s);
	            }
	        }

	        public void removeStudent(int roll) {
	            boolean removed = arrayList.removeIf(s -> s.roll == roll);
	            vector.removeIf(s -> s.roll == roll);
	            list.removeIf(s -> s.roll == roll);

	            if (removed)
	                System.out.println("Student removed successfully.");
	            else
	                System.out.println("Student not found.");
	        }

	        public void searchStudent(int roll) {
	            for (Student s : arrayList) {
	                if (s.roll == roll) {
	                    System.out.println("Student Found: " + s);
	                    return;
	                }
	            }
	            System.out.println("Student not found.");
	        }
	    }

	    static Scanner sc = new Scanner(System.in);

	    // Regex patterns
	    static final String NAME_REGEX = "^[A-Za-z ]{3,}$";
	    static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	    public static void main(String[] args) {

	        StudentManager manager = new StudentManager();
	        int choice;

	        do {
	            System.out.println("\n--- Student Management Menu ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. Display All Students");
	            System.out.println("3. Remove Student by Roll No");
	            System.out.println("4. Search Student by Roll No");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");

	            try {
	                choice = Integer.parseInt(sc.nextLine());

	                switch (choice) {
	                    case 1:
	                        addStudentFlow(manager);
	                        break;
	                    case 2:
	                        manager.displayStudents();
	                        break;
	                    case 3:
	                        System.out.print("Enter roll to remove: ");
	                        manager.removeStudent(Integer.parseInt(sc.nextLine()));
	                        break;
	                    case 4:
	                        System.out.print("Enter roll to search: ");
	                        manager.searchStudent(Integer.parseInt(sc.nextLine()));
	                        break;
	                    case 5:
	                        System.out.println("Exiting...");
	                        break;
	                    default:
	                        System.out.println("Invalid choice.");
	                }

	            } catch (Exception e) {
	                System.out.println("Invalid input. Try again.");
	                choice = 0;
	            }

	        } while (choice != 5);
	    }

	    static void addStudentFlow(StudentManager manager) {

	        try {
	            System.out.print("Enter Roll No: ");
	            int roll = Integer.parseInt(sc.nextLine());

	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();
	            if (!Pattern.matches(NAME_REGEX, name)) {
	                System.out.println("Invalid name format.");
	                return;
	            }

	            System.out.print("Enter Email: ");
	            String email = sc.nextLine();
	            if (!Pattern.matches(EMAIL_REGEX, email)) {
	                System.out.println("Invalid email format.");
	                return;
	            }

	            manager.addStudent(new Student(roll, name, email));

	        } catch (NumberFormatException e) {
	            System.out.println("Roll number must be numeric.");
	        } catch (Exception e) {
	            System.out.println("Error adding student.");
	        }
	    }
	}


