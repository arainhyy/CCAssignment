package codingbootcamp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class bitFlag {
	int [] flag = new int [(int) (((long)Integer.MAX_VALUE + 1) >> 5)];
	
	public void add(int val) {
		int inx = val >> 5;
		int pos = val & 0x1F;
		flag[inx] |= (1 << pos);
	}
	
	public int findMissing() {
		int tmp = 0;
		int inx = 0;
		for (int i=0; i<flag.length; i++) {
			if (flag[i] != (0xFFFFFFFF)) {
				while (((flag[i] >> tmp) & 1) == 1) {
					tmp++;
				}
				inx = i;
				break;
			}
		}
		return (inx << 5) + tmp;
	}
}

public class codingbootcamp {
	public static String fileName = "";
	
	public static int missingInt() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		bitFlag bf = new bitFlag();
		int val;
		while (in.hasNextInt()) {
			val = in.nextInt();
			bf.add(val);
		}
		in.close();
		return bf.findMissing();
	}
	
	public static void main(String[] args) {
//		bitFlag bf = new bitFlag();
//		
//	    for (int i=0; i<Integer.MAX_VALUE; i++) {
//	    	bf.add(i);
//	    }
//	    System.out.println(bf.findMissing());
    }
}