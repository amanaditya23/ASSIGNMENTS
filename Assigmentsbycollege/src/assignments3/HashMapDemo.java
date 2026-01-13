package assignments3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>(10);
        HashMap<Integer, String> map3 = new HashMap<>(10, 0.75f);

        HashMap<Integer, String> temp = new HashMap<>();
        temp.put(1, "A");
        temp.put(2, "B");
        HashMap<Integer, String> map4 = new HashMap<>(temp);

        map1.put(1, "Java");                     // 1 put()
        map1.put(2, "Python");
        map1.put(3, "C++");

        map1.putIfAbsent(4, "HTML");             // 2 putIfAbsent()

        System.out.println(map1);

        System.out.println(map1.get(2));         // 3 get()

        System.out.println(map1.containsKey(1)); // 4 containsKey()

        System.out.println(map1.containsValue("Java")); // 5 containsValue()

        System.out.println(map1.size());         // 6 size()

        map1.remove(3);                          // 7 remove(key)

        map1.remove(2, "Python");                // 8 remove(key, value)

        System.out.println(map1);

        map1.replace(1, "Spring");               // 9 replace(key, value)

        map1.replace(4, "HTML", "CSS");          // 10 replace(key, oldValue, newValue)

        System.out.println(map1);

        Set<Integer> keys = map1.keySet();       // 11 keySet()
        System.out.println(keys);

        Collection<String> values = map1.values(); // 12 values()
        System.out.println(values);

        Set<Map.Entry<Integer, String>> entries = map1.entrySet(); // 13 entrySet()
        System.out.println(entries);

        map1.clear();                            // 14 clear()

        System.out.println(map1.isEmpty());      // 15 isEmpty()
    }
}
