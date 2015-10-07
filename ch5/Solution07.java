package codingbootcamp;

import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp
{
	public static int pairwiseSwap(int a) {
		int even = a & 0xaaaaaaaa;
		int odd = a & 0x55555555;
		return (even >>> 1) | (odd << 1);
	}
	
	public static void main (String[] args) {
		System.out.println(Integer.toBinaryString(pairwiseSwap(0b1010101010101010)));
    }
}
