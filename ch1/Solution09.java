package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	public boolean isSubstring(String a, String b) {
		int limit = a.length() - b.length();
		int b_len = b.length();
		for (int i=0; i<=limit; i++) {
			if (b.equals(a.substring(i, i + b_len)))
				return true;
		}
		return false;
	}
	public boolean isRotation(String a, String b) {
		String xyxy = a + a; //a = x+y  b = y+x  b is substring of x+y+x+y
		if (b.length() != a.length()) return false;
		System.out.println(xyxy);
		return isSubstring(xyxy, b);
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		System.out.println(s.isRotation("waterbottle", "erbottlewat"));
	}
}
