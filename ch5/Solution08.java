package codingbootcamp;

import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp {
	public static void brutalDrawLine(byte[] screen, int width, int x1, int x2,
			int y) {
		int begin = (width * y) + x1;
		int end = begin - x1 + x2;
		for (int i = begin; i <= end; i++) {
			screen[i / 8] |= (0x80 >> (i % 8));
		}
	}

	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {

		int begin = (width * y) + x1;
		int end = begin - x1 + x2;

		// set full bytes from (begin / 8 + 1) to (end / 8 - 1)
		int full_begin = begin / 8 + 1;
		int full_end = end / 8;
		begin = begin % 8;
		end = end % 8;
		for (int i = full_begin; i < full_end; i++) {
			screen[i] = (byte) 0xFF;
		}

		byte start_mask = (byte) (0xFF >> begin);
		byte end_mask = (byte) (0xFF >> (7 - end) << (7 - end));
		// byte end_mask = (byte) ~(0xFF >> (end + 1));
		if (full_begin > full_end) { // if there is no full bytes
			byte mask = (byte) (start_mask & end_mask);
			screen[full_end] |= mask;
		} else {
			screen[full_begin - 1] |= start_mask;
			screen[full_end] |= end_mask;
		}
	}

	public static void main(String[] args) {
		byte screen[] = new byte[100];
		brutalDrawLine(screen, 24, 3, 18, 2);
		for (int i = 0; i < 10; i++) {
			System.out.println(Integer.toBinaryString(screen[i] & 0xFF));
		}
		System.out.println();

		screen = new byte[100];
		drawLine(screen, 24, 3, 18, 2);
		for (int i = 0; i < 10; i++) {
			System.out.println(Integer.toBinaryString(screen[i] & 0xFF));
		}
		System.out.println();

		screen = new byte[100];
		drawLine(screen, 24, 3, 7, 2);
		for (int i = 0; i < 10; i++) {
			System.out.println(Integer.toBinaryString(screen[i] & 0xFF));
		}
	}
}
