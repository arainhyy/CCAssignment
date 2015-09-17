package codingbootcamp;

import java.util.*;

//assumption: ignore non-letter character
public class codingbootcamp {
	public boolean palin_permute(String s) {
		int len = s.length();
		char tmp;
		Map <Character, Integer> mp = new HashMap <Character, Integer> ();
		for (int i=0; i<len; i++) { //put each character of s into hashmap
			tmp = s.charAt(i);
			if (tmp < 'A' || tmp > 'z' || (tmp < 'a' && tmp > 'Z')) continue; //filter
			if (mp.containsKey(tmp)) mp.put(tmp, mp.get(tmp) + 1);
			else mp.put(tmp, 1);
		}
		Iterator it = mp.entrySet().iterator();
		Integer cnt;
		boolean flag = true;
		while (it.hasNext()) { //iterator over the hashmap
			Map.Entry entry = (Map.Entry) it.next();
			cnt = (Integer) entry.getValue();
//			System.out.println(cnt);
			if (cnt % 2 != 0) {
				if (flag) flag = false;
				else return false;
			}
		}
		return true;
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		String a = "taco cat";
		System.out.println(s.palin_permute(a));
		System.out.println(s.palin_permute("gogo  ab"));
	}
}
