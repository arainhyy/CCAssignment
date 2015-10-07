package codingbootcamp;

import java.lang.*;
import java.util.*;
import java.io.*;

public class codingbootcamp {

	public static double oneGenerationSimulation() {
		double girl_ratio = 0;
		double boy_ratio = 0;

		double pre_girl_ratio = -1;
		double pre_boy_ratio = -1;

		double probability = 0.5;
		int boy_num = 0;
		while (girl_ratio - pre_girl_ratio > 0.000000000000000000001
				|| boy_ratio - pre_boy_ratio > 0.000000000000000000001) {
			pre_girl_ratio = girl_ratio;
			pre_boy_ratio = boy_ratio;

			girl_ratio += probability; // probability * 1
			boy_ratio += probability * boy_num;

			boy_num++;
			probability *= 0.5; // probability = probability * (1 - 0.5)
		}
		return girl_ratio / (girl_ratio + boy_ratio);
	}

	public static void main(String[] args) {
		System.out.println("Girl ratio of next generation :" + oneGenerationSimulation());
	}
}
