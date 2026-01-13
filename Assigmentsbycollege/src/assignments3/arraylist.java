package assignments3;

		// TODO Auto-generated method stub
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.Iterator;

		public class arraylist {
		    public static void main(String[] args) {

		        ArrayList<String> list1 = new ArrayList<>();
		        ArrayList<String> list2 = new ArrayList<>(5);
		        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("A", "B", "C"));

		        System.out.println("Initial list3: " + list3);
		     // 1 add()
		        list1.add("Java");                          
		        list1.add("Python");
		        list1.add("C++");
		        
		     // 2 add(index, element)
    		    list1.add(1, "HTML");                      
		        System.out.println("After add: " + list1);

		        list1.remove("Python");                    // 3 remove(object)
		        list1.remove(2);                           // 4 remove(index)

		        System.out.println("After remove: " + list1);

		        System.out.println("Size: " + list1.size());     // 5 size()

		        System.out.println("Contains Java? " + list1.contains("Java")); // 6 contains()

		        System.out.println("Element at index 1: " + list1.get(1));      // 7 get()

		        list1.set(1, "CSS");                       // 8 set(index, element)
		        System.out.println("After set: " + list1);

		        System.out.println("Index of Java: " + list1.indexOf("Java"));  // 9 indexOf()

		        System.out.println("Is empty? " + list1.isEmpty());             // 10 isEmpty()

		        ArrayList<String> list4 = new ArrayList<>();
		        list4.add("SQL");
		        list4.add("Spring");

		        list1.addAll(list4);                       // 11 addAll()
		        System.out.println("After addAll: " + list1);

		        list1.removeAll(list4);                    // 12 removeAll()
		        System.out.println("After removeAll: " + list1);

		        list1.addAll(list4);
		        list1.retainAll(Arrays.asList("Java", "SQL"));  // 13 retainAll()
		        System.out.println("After retainAll: " + list1);

		        list1.clear();                             // 14 clear()
		        System.out.println("After clear: " + list1);

		        list1.add("One");
		        list1.add("Two");
		        list1.add("Three");

		        Iterator<String> it = list1.iterator();    // 15 iterator()
		        System.out.print("Using iterator: ");
		        while (it.hasNext()) {
		            System.out.print(it.next() + " ");
		        }
		    }
		

	}


