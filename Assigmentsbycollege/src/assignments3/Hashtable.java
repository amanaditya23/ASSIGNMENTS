package assignments3;

import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class Hashtable {

    public static void main(String[] args) {

        java.util.Hashtable<Integer, String> ht1 = new java.util.Hashtable<>();
        java.util.Hashtable<Integer, String> ht2 = new java.util.Hashtable<>(10);
        java.util.Hashtable<Integer, String> ht3 = new java.util.Hashtable<>(10, 0.75f);

        java.util.Hashtable<Integer, String> temp = new java.util.Hashtable<>();
        temp.put(1, "A");
        temp.put(2, "B");
        java.util.Hashtable<Integer, String> ht4 = new java.util.Hashtable<>(temp);

        ht1.put(1, "Java");                       // 1 put()
        ht1.put(2, "Python");
        ht1.put(3, "C++");

        ht1.putIfAbsent(4, "HTML");               // 2 putIfAbsent()

        System.out.println(ht1);

        System.out.println(ht1.get(2));           // 3 get()

        System.out.println(ht1.containsKey(1));   // 4 containsKey()

        System.out.println(ht1.containsValue("Java")); // 5 containsValue()

        System.out.println(ht1.size());           // 6 size()

        ht1.remove(3);                            // 7 remove(key)

        ht1.remove(2, "Python");                  // 8 remove(key, value)

        System.out.println(ht1);

        ht1.replace(1, "Spring");                 // 9 replace(key, value)

        ht1.replace(4, "HTML", "CSS");            // 10 replace(key, oldValue, newValue)

        System.out.println(ht1);

        Set<Integer> keys = ht1.keySet();         // 11 keySet()
        System.out.println(keys);

        Collection<String> values = ht1.values(); // 12 values()
        System.out.println(values);

        Set<Map.Entry<Integer, String>> entries = ht1.entrySet(); // 13 entrySet()
        System.out.println(entries);

        ht1.clear();                              // 14 clear()

        System.out.println(ht1.isEmpty());        // 15 isEmpty()
    }
}
