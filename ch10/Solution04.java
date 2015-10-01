package codingbootcamp;

import java.util.ArrayList;

public class codingbootcamp {
	public static int binarySearch(ArrayList <Integer> arr, int l, int r, int val) {
		if (l > r) return -1;
		int mid = (l + r) / 2;
		if (arr.get(mid) == val) return mid;
		else if (arr.get(mid) < val) return binarySearch(arr, mid + 1, r, val);
		else return binarySearch(arr, l, mid - 1, val);
	}
	
	// use get function from Arraylist class to simulate elementAt function
	public static int noSizeSearch(ArrayList <Integer> arr, int val) {
		int i = 1;
		int inx = 0;
		while (arr.get(inx) != -1 && arr.get(inx) < val) {
			inx += i;
			i = i << 1;
		}
		return binarySearch(arr, inx/2, inx, val);
	}
	
	public static void main(String[] args) {
	    int [] array = {1,2,2,2,2,4,5,6};
	    ArrayList <Integer> arr = new ArrayList <Integer> ();
	    for (int i=0; i<array.length; i++) {
	    	arr.add(array[i]);
	    }
	    for (int i=0; i<array.length * 2; i++) {
	    	arr.add(-1);
	    }
	    System.out.println(noSizeSearch(arr, 5));
	    System.out.println(noSizeSearch(arr, 6));
	    System.out.println(noSizeSearch(arr, 2));
	    System.out.println(noSizeSearch(arr, 1));
    }
}