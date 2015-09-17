package codingbootcamp;

import java.util.*;

//assume: input an ASCLL string
public class codingbootcamp {
	public boolean is_unique(String s) {
		boolean flag [] = new boolean [128];
		int len = s.length();
		int tmp;
		for (int i=0; i<len; i++) {
			tmp = s.charAt(i);
			if (flag[tmp] == false) flag[tmp] = true;
				else return false;
		}
		return true;
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		System.out.println(s.is_unique("ab^$*$><"));
		System.out.println(s.is_unique("ab^$><"));
	}
}
