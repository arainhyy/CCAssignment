package codingbootcamp;


import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp
{
	public static int insertionMtoN(int n, int m, int i, int j) {
		int mask = ~0 << (j + 1);
		int mask_i = ~(~0 << i) & n;;
		int after_clear = n & mask | mask_i;
		return after_clear | (m << i);
	}
	
	
	public static void main (String[] args) {
		System.out.println(Integer.toBinaryString(insertionMtoN(0b10000000000, 0b10011, 27, 32)));
    }
}
