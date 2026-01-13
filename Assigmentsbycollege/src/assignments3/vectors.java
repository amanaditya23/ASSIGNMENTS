package assignments3;


	import java.util.Vector;
	import java.util.Arrays;
	import java.util.Iterator;

	public class vectors {

	    public static void main(String[] args) {

	        Vector<String> v1 = new Vector<>();
	        Vector<String> v2 = new Vector<>(5);
	        Vector<String> v3 = new Vector<>(5, 2);
	        Vector<String> v4 = new Vector<>(Arrays.asList("A", "B", "C"));

	        System.out.println("Initial v4: " + v4);

	        v1.add("Java");                         // 1 add()
	        v1.add("Python");
	        v1.add("C++");

	        v1.add(1, "HTML");                     // 2 add(index, element)

	        System.out.println("After add: " + v1);

	        v1.remove("Python");                   // 3 remove(object)
	        v1.remove(2);                          // 4 remove(index)

	        System.out.println("After remove: " + v1);

	        System.out.println("Size: " + v1.size());         // 5 size()

	        System.out.println("Contains Java? " + v1.contains("Java"));  // 6 contains()

	        System.out.println("Element at index 1: " + v1.get(1));       // 7 get()

	        v1.set(1, "CSS");                      // 8 set(index, element)
	        System.out.println("After set: " + v1);

	        System.out.println("Index of Java: " + v1.indexOf("Java"));   // 9 indexOf()

	        System.out.println("Is empty? " + v1.isEmpty());              // 10 isEmpty()

	        Vector<String> temp = new Vector<>();
	        temp.add("SQL");
	        temp.add("Spring");

	        v1.addAll(temp);                       // 11 addAll()
	        System.out.println("After addAll: " + v1);

	        v1.removeAll(temp);                    // 12 removeAll()
	        System.out.println("After removeAll: " + v1);

	        v1.addAll(temp);
	        v1.retainAll(Arrays.asList("Java", "SQL"));  // 13 retainAll()
	        System.out.println("After retainAll: " + v1);

	        v1.clear();                            // 14 clear()
	        System.out.println("After clear: " + v1);

	        v1.add("One");
	        v1.add("Two");
	        v1.add("Three");

	        Iterator<String> it = v1.iterator();   // 15 iterator()
	        System.out.print("Using iterator: ");
	        while (it.hasNext()) {
	            System.out.print(it.next() + " ");
	        }
	    }
	}



