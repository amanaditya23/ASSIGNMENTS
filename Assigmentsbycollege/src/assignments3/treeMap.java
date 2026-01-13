package assignments3;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;

public class treeMap {

    public static void main(String[] args) {

        java.util.TreeMap<Integer, String> tm1 = new java.util.TreeMap<>();
        java.util.TreeMap<Integer, String> tm2 = new java.util.TreeMap<>(Comparator.reverseOrder());

        java.util.TreeMap<Integer, String> temp = new java.util.TreeMap<>();
        temp.put(1, "A");
        temp.put(2, "B");
        java.util.TreeMap<Integer, String> tm3 = new java.util.TreeMap<>(temp);

        tm1.put(1, "Java");                        // 1 put()
        tm1.put(2, "Python");
        tm1.put(3, "C++");

        tm1.putIfAbsent(4, "HTML");                // 2 putIfAbsent()

        System.out.println(tm1);

        System.out.println(tm1.get(2));            // 3 get()

        System.out.println(tm1.containsKey(1));    // 4 containsKey()

        System.out.println(tm1.containsValue("Java")); // 5 containsValue()

        System.out.println(tm1.size());            // 6 size()

        tm1.remove(3);                             // 7 remove(key)

        tm1.remove(2, "Python");                   // 8 remove(key,value)

        System.out.println(tm1);

        tm1.replace(1, "Spring");                  // 9 replace(key,value)

        tm1.replace(4, "HTML", "CSS");             // 10 replace(key,old,new)

        System.out.println(tm1);

        Set<Integer> keys = tm1.keySet();          // 11 keySet()
        System.out.println(keys);

        Collection<String> values = tm1.values();  // 12 values()
        System.out.println(values);

        Set<Map.Entry<Integer, String>> entries = tm1.entrySet(); // 13 entrySet()
        System.out.println(entries);

        System.out.println(tm1.firstKey());        // 14 firstKey()

        System.out.println(tm1.lastKey());         // 15 lastKey()
    }
}
