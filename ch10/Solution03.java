package codingbootcamp;


public class codingbootcamp {
	// Assumption: if val don't exist, return -1
	public static int searchInRotatedArray(int [] array, int l, int r, int val) {
		int mid = (l + r) / 2;
		if (array[mid] == val) return mid;
		if (l > r) return -1;
		if (array[l] < array[mid]) {
			if (val >= array[l] && val <= array[mid])
				return searchInRotatedArray(array, l, mid - 1, val);
			else return searchInRotatedArray(array, mid + 1, r, val);
		}
		else if (array[mid] < array[r]) {
			if (val >= array[mid] && val <= array[r]) 
				return searchInRotatedArray(array, mid + 1, r, val);
			else return searchInRotatedArray(array, l, mid - 1, val);
		}
		else {
			if (array[l] == array[mid] && array[mid] == array[r]) {
				int ret = searchInRotatedArray(array, l, mid - 1, val);
				if (ret != -1) return ret;
				else return searchInRotatedArray(array, mid + 1, r, val);
			}
			else if (array[l] == array[mid]) return searchInRotatedArray(array, mid + 1, r, val);
			else return searchInRotatedArray(array, l, mid - 1, val);
		}
	}
	
	public static void main(String[] args) {
       int [] array = {2,2,2,2,4,5,6};
       System.out.println(searchInRotatedArray(array, 0, array.length - 1, 5));
       int [] array2 = {4,5,6,2,2,2};
       System.out.println(searchInRotatedArray(array2, 0, array2.length - 1, 4));
       int [] array3 = {2,4,5,6,2,2,2,2,2};
       System.out.println(searchInRotatedArray(array3, 0, array3.length - 1, 4));
       int [] array4 = {3,4,5,6,1,2};
       System.out.println(searchInRotatedArray(array4, 0, array4.length - 1, 2));
    }
}