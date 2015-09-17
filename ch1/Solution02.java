package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	//check number of each character
	public boolean check_permute(String a, String b) {
		if (a.length() != b.length()) return false;
		Map <Character, Integer> mp = new HashMap <Character, Integer> ();
		char tmp;
		for (int i=0; i<a.length(); i++) { //put each character of string a into hashmap
			tmp = a.charAt(i);
			if (mp.containsKey(tmp)) mp.put(tmp, mp.get(tmp) + 1);
			else mp.put(tmp, 1);
		}
		for (int i=0; i<b.length(); i++) { //check each character of string b by hashmap
			tmp = b.charAt(i);
			if (!mp.containsKey(tmp) || mp.get(tmp) == 0) return false;
			else mp.put(tmp, mp.get(tmp) - 1);
		}
		return true;
	}
	
	//sort string and compare
	public String sort(String s) {
		char [] a = s.toCharArray();
		Arrays.sort(a);
		String sorted = new String(a);
		return sorted;
	}
	public boolean check_permute2(String a, String b) {
		return (sort(a).equals(sort(b)));
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		System.out.println(s.check_permute("codingbootCAMP!", "CodingcAMP!boot"));
		System.out.println(s.check_permute2("codingbootCAMP!", "CodingcAMP!boot"));
		System.out.println(s.check_permute("whatsup","whatysa"));
		System.out.println(s.check_permute2("whatsup","whatysa"));
	}
}
