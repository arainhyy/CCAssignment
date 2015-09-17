package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	public boolean one_way(String a, String b) {
		int flag = 2;
		int a_len = a.length();
		int b_len = b.length();
		if (a_len > b_len) flag = 1;
		else if (a_len < b_len) flag = -1;
		
		int a_inx = 0, b_inx = 0;
		
		while (a_inx < a_len) {
			if (a.charAt(a_inx) == b.charAt(b_inx)) {
				a_inx ++; 
				b_inx ++;
			}
			else if (flag == 0) return false;
			else {
				if (flag == 1) a_inx ++;
				else if (flag == -1) b_inx ++;
				else {
					b_inx ++; a_inx ++;
				}
				flag = 0;
			}
		}
		return true;
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		String a = "taco cat";
		System.out.println(s.one_way("pale", "ple"));
		System.out.println(s.one_way("pale", "bale"));
		System.out.println(s.one_way("pale", "bald"));
	}
}
