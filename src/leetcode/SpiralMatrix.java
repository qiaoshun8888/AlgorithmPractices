package leetcode;

import java.util.*;

public class SpiralMatrix {

	/**
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * 
	 * [ 
	 * 	[ 1, 2, 3 ], 
	 *  [ 4, 5, 6 ], 
	 *  [ 7, 8, 9 ] 
	 * ] 
	 * 
	 * You should return
	 * 
	 * 		[1,2,3,6,9,8,7,4,5].
	 * 
	 * */

	/*
	    [
	     [ 1,  2, 3 ],
	     [ 4,  5, 6 ],
	     [ 7,  8, 9 ],
	     [10, 11, 12],
	     [13, 14, 15],
	     [16, 17, 18],
	    ]
	
	    1, 2, 3, 6, 9, 12, 15, 18, 17, 16, 13, 10, 7, 4, 5, 8, 11, 14
	*/
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
	    
	    int m = matrix.length, n = matrix[0].length, count = 0;
	    int maxLayer = Math.min(m, n) / 2;
	    
	    for (int layer = 0; layer <= maxLayer; layer++) {
	        // top
	        for (int i = layer; i < n - layer && count < m * n; i++, count++) {
	            result.add(matrix[layer][i]);
	        }
	        
	        // right
	        for (int i = layer + 1; i < m - layer && count < m * n; i++, count++) {
	            result.add(matrix[i][n - 1 - layer]);
	        }
	        
	        // bottom
	        for (int i = n - 1 - layer - 1; i >= layer && count < m * n; i--, count++) {
	            result.add(matrix[m - 1 - layer][i]);
	        }
	        
	        // right
	        for (int i = m - 1 - layer - 1; i > layer && count < m * n; i--, count++) {
	            result.add(matrix[i][layer]);
	        }
	    }
	    
	    return result;
	}
	
	public static void main(String [] args) {
		int m = 6, n = 3, temp = 1;
		int [][] matrix = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%3d", temp);
				matrix[i][j] = temp++;
			}
			System.out.println();
		}
		System.out.println();
		
		SpiralMatrix o = new SpiralMatrix();
		ArrayList<Integer> result = o.spiralOrder(matrix);
		for (int v : result) {
			System.out.print(v + " ");
		}
	}
}
