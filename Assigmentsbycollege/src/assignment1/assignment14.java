package assignment1;

public class assignment14 {
	

	    public static void main(String[] args) {

	        String s = "Aman Aditya";

	        System.out.println("String: " + s);

	        System.out.println("length(): " + s.length());
	        System.out.println("isEmpty(): " + s.isEmpty());
	        System.out.println("charAt(1): " + s.charAt(1));
	        System.out.println("toString(): " + s.toString());
	        System.out.println("equals(\"Java\"): " + s.equals("Java"));
	        System.out.println("compareTo(\"Java\"): " + s.compareTo("Java"));
	        System.out.println("contains(\"Java\"): " + s.contains("Java"));
	        System.out.println("indexOf('a'): " + s.indexOf('a'));
	        System.out.println("lastIndexOf('a'): " + s.lastIndexOf('a'));
	        System.out.println("startsWith(\"  Ja\"): " + s.startsWith("  Ja"));
	        System.out.println("endsWith(\"  \"): " + s.endsWith("  "));
	        System.out.println("matches(\".*Java.*\"): " + s.matches(".*Java.*"));
	        System.out.println("substring(2,6): " + s.substring(2, 6));
	        System.out.println("toLowerCase(): " + s.toLowerCase());
	        System.out.println("trim(): '" + s.trim() + "'");
	        System.out.println("replace('a','@'): " + s.replace('a', '@'));

	        String arr[] = s.trim().split(" ");
	        System.out.println("split():");
	        for (String w : arr)
	            System.out.println(w);

	        System.out.println("join(): " + String.join("-", arr));

	        int x = 10;
	        System.out.println("valueOf(): " + String.valueOf(x));
	    }
	}





