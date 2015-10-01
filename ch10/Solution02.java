package codingbootcamp;

import java.util.Arrays;
import java.util.Comparator;

class cmp implements Comparator <String> {
	public int compare(String a, String b) {
		char [] x = a.toCharArray();
		char [] y = b.toCharArray();
		Arrays.sort(x);
		Arrays.sort(y);
//		System.out.println(new String(x));
//		System.out.println(new String(y));
		int go = new String(x).compareTo(new String(y));
		return go;
	}
}

public class codingbootcamp {
	
	public static void groupAnagrams(String [] st) {
		Arrays.sort(st, new cmp());
	}
	
	public static void main(String[] args) {
       String [] st = {"abb", "dac", "bba", "ddb", "acd"};
       groupAnagrams(st);
       for (int i=0; i<st.length; i++) {
    	   System.out.println(st[i]);
       }
    }
}