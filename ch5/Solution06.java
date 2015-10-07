package codingbootcamp;

import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp
{
	public static int conversion(int a, int b) {
		int xor = a ^ b;
		int ans = 0;
		while (xor != 0) {
			ans += xor & 1;
			xor >>= 1;
		}
		return ans;
	}
	
	public static int quickConversionFromBook(int a, int b) {
		int ans = 0;
		for (int i=a^b; i!= 0; i &= (i-1))
			ans += 1;
		return ans;
	}
	
	public static void main (String[] args) {
		System.out.println(conversion(0b11101, 0b01111));
		System.out.println(quickConversionFromBook(0b11101, 0b01111));
    }
}
