package codingbootcamp;


import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp
{
	public static int getNextSmallest(int a) {
		if (a <= 0) return 0;
		int tmp = a;
		int bit = 0;
		int cnt_one_after = 0;
		while ((tmp & 1) == 0) {
			tmp = tmp >> 1;
			bit++;
		}
		while ((tmp & 1) != 0 && tmp != 0) {
			tmp = tmp >> 1;
			bit ++;
			cnt_one_after++;
		}
		if (bit == 31) return -1; // no non-tailing zero
		tmp = (tmp | 1) << bit;
		cnt_one_after--;
		while (cnt_one_after > 0) {
			tmp |= (1 << --cnt_one_after);
		}
		return tmp;
	}
	
	public static int getPreviousLargest(int a) {
		if (a <= 0) return 0;
		int tmp = a;
		int bit = 0;
		int cnt_one_after = 0;
		while ((tmp & 1) == 1) {
			tmp >>= 1;
			bit++;
			cnt_one_after++;
		}
		if (tmp == 0) return -1; // no non-tailing one
		while ((tmp & 1) != 1) {
			tmp >>= 1;
			bit++;
		}
		tmp = tmp >> 1 << (bit + 1);
		cnt_one_after++;
		while (cnt_one_after > 0) {
			tmp |= (1 << --bit);
			cnt_one_after--;
		}
		return tmp;
	}
	
	
	public static void main (String[] args) {
		System.out.println(Integer.toBinaryString(getPreviousLargest(0b10011110000011)));
		System.out.println(Integer.toBinaryString(getPreviousLargest(0b11111)));
		System.out.println(Integer.toBinaryString(getNextSmallest(0b11011001111100)));
		System.out.println(Integer.toBinaryString(getNextSmallest(0b01111111111111111111111111110000)));
    }
}
