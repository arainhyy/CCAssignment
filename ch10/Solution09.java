package codingbootcamp;

public class codingbootcamp {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        int tmp;
        while (row >= 0 && row < m && col >= 0 && col < n) {
            tmp = matrix[row][col];
            if (target < tmp) col--;
            else if (target > tmp) row++;
            else return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
       int [][] array = {
    		   {1,   4,  7, 11, 15},
    		   {2,   5,  8, 12, 19},
    		   {3,   6,  9, 16, 22},
    		   {10, 13, 14, 17, 24},
    		   {18, 21, 23, 26, 30}
    		 };
       System.out.println(searchMatrix(array, 20));
       System.out.println(searchMatrix(array, 21));
       System.out.println(searchMatrix(array, 30));
       System.out.println(searchMatrix(array, 10));
    }
}