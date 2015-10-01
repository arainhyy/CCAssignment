package codingbootcamp;

import java.util.ArrayList;

public class codingbootcamp {
	
	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void peaksAndValleys(int [] arr) {
		int now;
		for (int i=0; i<arr.length; i+=2) {
			now = arr[i];
			if (i != 0 && now < arr[i - 1]) {
				if (arr[i - 1] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
				else {
					swap(arr, i, i - 1);
				}
			}
			else if (i != arr.length && now < arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}
	}
	
	public static void main(String[] args) {
	    int [] array = {1,2,2,2,2,4,5,6};
	    peaksAndValleys(array);
	    for (int i=0; i<array.length; i++) System.out.println(array[i]);
    }
}