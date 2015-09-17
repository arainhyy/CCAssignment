package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	//in place rotate
	public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int tmp=0,l=0,r=0;
        for (int i=0; i<m; i++){
            l = 0;
            r = m - 1;
            while (l < r){
                tmp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tmp;
                l++; r--;
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<m-i-1; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[m-1-j][m-1-i];
                matrix[m-1-j][m-1-i] = tmp;
            }
        }
    }
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		s.rotate(matrix);
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}
