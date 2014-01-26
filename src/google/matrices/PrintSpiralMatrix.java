package google.matrices;

import java.util.ArrayList;

/**
 * PrintSpiralMatrix.java
 * 
 * Description: Given a matrix of m x n elements (m rows, n columns), return all
 * elements of the matrix in spiral order.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 24, 2014
 */

public class PrintSpiralMatrix {

	public static ArrayList<Integer> spiralMatrix(int [][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) return null;
		
		int m = matrix.length, n = matrix[0].length, count = 0;
		
		int maxLayer = Math.min(m, n) / 2;
		
		for (int layer = 0; layer <= maxLayer; layer++) {
			
			// top
			for (int i = layer; i < n - layer && count < m * n; i++) {
				count++;
				result.add(matrix[layer][i]);
			}
			
			// right
			for (int i = layer + 1; i < m - layer && count < m * n; i++) {
				count++;
				result.add(matrix[i][n - layer - 1]);
			}
			
			// bottom
			for (int i = n - layer - 1 - 1; i >= layer && count < m * n; i--) {
				count++;
				result.add(matrix[m - layer - 1][i]);
			}
			
			// left
			for (int i = m - layer - 1 -1; i > layer && count < m * n; i--) {
				count++;
				result.add(matrix[i][layer]);
			}
		}
		
		return result;
	}
	
	public static void main(String [] args) {
		int [][] matrix = {
			{1,  2,  3},
			{4,  5,  6},
			{7,  8,  9},
			{10, 11, 12},
			{13, 14, 15},
		};
		
		int [][] matrix2 = {
			{1, 2, 3, 4, 5, 6, 7},
			{8, 9, 0, 1, 2, 3, 4},
			{1, 2, 3, 4, 5, 6, 7}	
		};
		
		ArrayList<Integer> result = spiralMatrix(matrix2);
		for(int v : result) {
			System.out.print(v + " ");
		}
		System.out.println();
	}
}
