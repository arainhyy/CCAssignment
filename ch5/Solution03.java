package codingbootcamp;

import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp {

	public static int flipBitToWin(int a) {
		int pre_length = 0; // record the length of the previous sequence of 1
		int now_length = 0;

		int now = a;
		int inx = 0;
		int plus_pre = -1; // the length if can flip one bit to merge the
							// previous sequence of 1 and the present one

		int ans = 1; // answer
		while (now != 0) {
			if ((now & 1) == 1) {
				while ((now & 1) == 1) { // calculate the length of the present
											// sequence of 1
					now_length++;
					now >>>= 1;
				}
				if (inx != 0 && inx >= 2) {
					if (((a >> (inx - 2)) & 1) == 1) { // if previous sequence
														// of 1 can be merged
						plus_pre = now_length + pre_length + 1;
						ans = Math.max(ans, plus_pre);
					}
				}
				if (now_length < 32) // if there is other bit of zero we can flip
										
					ans = Math.max(ans, now_length + 1);
				else
					ans = 32;

				inx += now_length;
				pre_length = now_length;
				now_length = 0;

			} else {
				inx++;
				now >>>= 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(flipBitToWin(0b11011101111));

		System.out.println(flipBitToWin(0b1111));

		System.out.println(flipBitToWin(0b111001111));

		System.out.println(flipBitToWin(0xFFFFFFFF));
	}
}
