package codingbootcamp;


import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp
{
	public static String binaryToString(double a) {
		if (a <= 0 || a >= 1) return "ERROR";
		double now = a;
		double tmp;
		StringBuilder st = new StringBuilder();
		st.append("0.");
		
		
		while (now > 0) {
			if (st.length() >= 32) return "ERROR";
			
			tmp = now * 2;
			if (tmp - 1 >= 0) {
				now = tmp - 1;
				st.append('1');
			}
			else {
				now = tmp;
				st.append('0');
			}
		}
		
		return st.toString();
	}
	
	
	public static void main (String[] args) {
		System.out.println(binaryToString(0.53125));
    }
}
