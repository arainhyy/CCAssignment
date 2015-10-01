package codingbootcamp;

class BitFlag {
	int [] flag = new int [2 << 10];
	
	public boolean check(int val) {
//		int inx = (val - 1) / 32;
//		int pos = (val - 1) % 32;
		int inx = (val - 1) >> 5;
		int pos = (val - 1) & 0x1F;
		return (((flag[inx] >> pos) & 1) == 1);
	}
	
	public void insert(int val) {
//		int inx = (val - 1) / 32;
//		int pos = (val - 1) % 32;
		int inx = (val - 1) >> 5;
		int pos = (val - 1) & 0x1F;
		flag[inx] |= 1 << pos;
	}
}

public class codingbootcamp {
	
	public static void findDuplicates(int [] array) {
		BitFlag bf = new BitFlag();
		for (int i=0; i<array.length; i++) {
			if (bf.check(array[i]))
				System.out.println(array[i]);
			bf.insert(array[i]);
		}
	}
	
	public static void main(String[] args) {
       int [] array = {1, 3, 5, 1, 32000, 5, 99, 32000, 31999};
       findDuplicates(array);
       System.out.println();
       int [] array2 = new int [32000];
       for (int i=0; i<32000; i++) array2[i] = i+1;
       array2[100] = 32000;
       findDuplicates(array2);
    }
}