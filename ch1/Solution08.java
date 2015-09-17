package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	HashMap <Integer, Boolean> row = new HashMap<Integer, Boolean>();
    HashMap <Integer, Boolean> col = new HashMap<Integer, Boolean>();
    int [][] a;
    int m, n;
    public void fillin(int x, int y){
        if (!row.containsKey(x)) {
            row.put(x, true);
            if (!col.containsKey(y)) {
                col.put(y, true);
                for (int i = 0; i < m; i++) {
                    if (a[i][y] == 0 && i != x) fillin(i, y);
                    else a[i][y] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                if (a[x][i] == 0 && i != y) fillin(x, i);
                else a[x][i] = 0;
            }
        }
        else if (!col.containsKey(y)){
            col.put(y, true);
            for (int i=0; i<m; i++){
                if (a[i][y] == 0 && i != x) fillin(i,y);
                else a[i][y] = 0;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return;
        n = matrix[0].length;
        a = matrix;
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j] == 0 && !row.containsKey(i) && !col.containsKey(j)){
                    fillin(i,j);
                }
            }
        }
    }
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		int [][] matrix = {{1,2,3,4},{5,0,7,8},{9,10,11,12},{0,14,15,16}};
		s.setZeroes(matrix);
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
}
