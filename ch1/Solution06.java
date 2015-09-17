package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	public String str_compress(String a) {
		StringBuilder ans = new StringBuilder();
		int len = a.length();
		int dist;
		for (int i=0; i<len; ) {
			dist = 1; 
			while (i + dist < len && a.charAt(i) == a.charAt(i + dist)) 
				dist ++;
			ans.append(a.charAt(i));
			ans.append(dist);
			i += dist;
		}
		return ans.toString();
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		String a = "taco cat";
		System.out.println(s.str_compress("aabccaddd"));
	}
}
