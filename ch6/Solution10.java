package codingbootcamp;

import java.util.*;

class findPoisonBottle {
	
	public static int [] result = new int [10]; // the result after 7 days
	public final static int testNumber = 1000;
	public final static int stripNumber = 10;
	private static int poisonNumber;
	public static List<ArrayList<Integer>> strips = new ArrayList<ArrayList<Integer>> ();
	
	findPoisonBottle() { // create poison bottle
		Random r = new Random(); 
		poisonNumber = r.nextInt(testNumber);
	}
	
	public void dfs(int now, int now_bit, int fixed_inx) {
		if (now_bit >= stripNumber) { 
			strips.get(fixed_inx).add(now);
			return;
		}
		if (now_bit != fixed_inx) {
			dfs(now, now_bit + 1, fixed_inx);
		}
		dfs(now + 1 << now_bit, now_bit + 1, fixed_inx);
	}
	
	public void dropToStrip() {
		for (int i=0; i<stripNumber; i++)
			strips.add(new ArrayList<Integer> ()); // init strips
		for (int i=0; i<stripNumber; i++) {
			dfs(0, 0, i); // put drops to the ith strips
		}
	}
	
	public void showResult() {
		int now = poisonNumber;
		for (int i=0; i<stripNumber; i++) {
			if ((now & 1) == 1) result[i] = 1;
			now >>= 1;
		}
	}
	
	public int getPoisonBottle() {
		int ans = 0;
		for (int i=0; i<10; i++) {
			ans += (result[i] << i);
		}
		return ans;
	}
	
	public boolean judgeTest(int testNum) {
		if (testNum == poisonNumber)  return true;
		else return false;
	}
}

public class codingbootcamp {
	public static void main(String[] args) {
		findPoisonBottle test = new findPoisonBottle();
		test.dropToStrip();
		test.showResult(); // means 7 days passed
		int poisonBottleNumber = test.getPoisonBottle();
		if (test.judgeTest(poisonBottleNumber)) 
			System.out.println("Find the right poison bottle: " + poisonBottleNumber);
		else System.out.println("Find the wrong poison bottle!");
	}
}
