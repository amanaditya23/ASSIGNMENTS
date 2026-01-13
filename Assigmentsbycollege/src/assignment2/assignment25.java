package assignment2;


	import java.util.*;
	import java.util.regex.*;

	interface UniversityOperations {
	    void addStudent(Scanner sc);
	    void displayStudents();
	    void searchStudent(int id);
	    void removeStudent(int id);
	    void sortByMarks();
	    void countCourseWise();
	    void convertToTreeMap();
	    void showUniqueCourses();
	}

	class Student {
	    int id;
	    String name;
	    String course;
	    double marks;

	    Student(int id, String name, String course, double marks) {
	        this.id = id;
	        this.name = name;
	        this.course = course;
	        this.marks = marks;
	    }

	    public String toString() {
	        return id + " " + name + " " + course + " " + marks;
	    }
	}

	public class assignment25  implements UniversityOperations {

	    List<Student> arrayList = new ArrayList<>();
	    Vector<Student> vector = new Vector<>();
	    Stack<Student> stack = new Stack<>();
	    Set<Integer> idSet = new HashSet<>();
	    Map<Integer, Student> hashMap = new HashMap<>();
	    Hashtable<Integer, Student> hashtable = new Hashtable<>();
	    TreeMap<Integer, Student> treeMap = new TreeMap<>();
	    Set<String> uniqueCourses = new HashSet<>();

	    public void addStudent(Scanner sc) {
	        try {
	            System.out.print("ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            if (idSet.contains(id))
	                throw new Exception("Duplicate ID not allowed");

	            System.out.print("Name: ");
	            String name = sc.nextLine();
	            if (!Pattern.matches("[A-Za-z ]+", name))
	                throw new Exception("Invalid name");

	            System.out.print("Course: ");
	            String course = sc.nextLine();

	            System.out.print("Marks: ");
	            double marks = sc.nextDouble();

	            Student s = new Student(id, name, course, marks);

	            arrayList.add(s);
	            vector.add(s);
	            stack.push(s);
	            hashMap.put(id, s);
	            hashtable.put(id, s);
	            idSet.add(id);
	            uniqueCourses.add(course);

	            System.out.println("Student added");

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	            sc.nextLine();
	        }
	    }

	    public void displayStudents() {
	        if (arrayList.isEmpty()) {
	            System.out.println("No students found");
	            return;
	        }
	        arrayList.forEach(System.out::println);
	    }

	    public void searchStudent(int id) {
	        Student s = hashMap.get(id);
	        if (s != null)
	            System.out.println(s);
	        else
	            System.out.println("Student not found");
	    }

	    public void removeStudent(int id) {
	        Student s = hashMap.remove(id);
	        if (s != null) {
	            arrayList.remove(s);
	            vector.remove(s);
	            stack.remove(s);
	            hashtable.remove(id);
	            idSet.remove(id);
	            System.out.println("Student removed");
	        } else
	            System.out.println("Student not found");
	    }

	    public void sortByMarks() {
	        arrayList.sort(Comparator.comparingDouble(st -> st.marks));
	        System.out.println("Sorted by marks:");
	        displayStudents();
	    }

	    public void convertToTreeMap() {
	        treeMap.clear();
	        treeMap.putAll(hashMap);
	        System.out.println("Converted HashMap to TreeMap");
	        treeMap.forEach((k, v) -> System.out.println(v));
	    }

	    public void countCourseWise() {
	        Map<String, Integer> countMap = new HashMap<>();
	        for (Student s : arrayList)
	            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);

	        countMap.forEach((k, v) -> System.out.println(k + ": " + v));
	    }

	    public void showUniqueCourses() {
	        System.out.println("Unique courses:");
	        uniqueCourses.forEach(System.out::println);
	    }

	    public static void main(String[] args) {

	     assignment25  ums = new  assignment25();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1.Add 2.Display 3.Search 4.Remove 5.Sort 6.ConvertMap 7.CountCourse 8.UniqueCourses 9.Exit");
	            int ch = sc.nextInt();

	            switch (ch) {
	                case 1 -> ums.addStudent(sc);
	                case 2 -> ums.displayStudents();
	                case 3 -> {
	                    System.out.print("Enter ID: ");
	                    ums.searchStudent(sc.nextInt());
	                }
	                case 4 -> {
	                    System.out.print("Enter ID: ");
	                    ums.removeStudent(sc.nextInt());
	                }
	                case 5 -> ums.sortByMarks();
	                case 6 -> ums.convertToTreeMap();
	                case 7 -> ums.countCourseWise();
	                case 8 -> ums.showUniqueCourses();
	                case 9 -> System.exit(0);
	                default -> System.out.println("Invalid option");
	            }
	        }
	    }
	}

