package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	public char [] URLify(char [] s, int len) {
		int inx = s.length - 1;
		for (int i = len-1; i>=0; i--) { //change string from end
			if (s[i] != ' ') s[inx--] = s[i];
			else {
				s[inx--] = '0';
				s[inx--] = '2';
				s[inx--] = '%';
			}
		}
		return s;
	}
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		String a = "Mr Jone Smith    ";
		System.out.println(s.URLify(a.toCharArray(), 13));
	}
}
