package crackingTheCodingInterview.chapter1;

import java.util.ArrayList;

public class MatrixSetZero {

	public static int [][] checkMatrix(int [][] matrix, int m, int n) {
		
		boolean rows [] = new boolean[matrix.length];
		boolean columns [] = new boolean[matrix[0].length];
		
		// System.out.println(matrix.length);
		// System.out.println(matrix[0].length);
		
		// ArrayList<int[]> points = new ArrayList<int[]>();	// O(MN) space
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int v = matrix[i][j];
				if (v == 0) {
					rows[i] = true;
					columns[j] = true;
					// points.add(new int[]{i, j});
					break;
				}
			}
		}
		
		/*
		for (int [] pos : points) {
			matrix = setMatrixZero(matrix, pos, m, n);			
		}
		*/
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || columns[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}
	
	public static int [][] setMatrixZero(int [][] matrix, int [] pos, int M, int N) {
		for (int a = 0; a < N; a++) {
			matrix[pos[0]][a] = 0;
		}
		for (int a = 0; a < M; a++) {
			matrix[a][pos[1]] = 0;
		}
		return matrix;
	}
	
	public static void main(String args[]) {
		
		int M = 4, N = 5;
		
		int [][] matrix = {
				{1, 2, 3, 1, 2},
				{2, 1, 0, 2, 3},
				{1, 3, 2, 2, 2},
				{1, 1, 1, 1, 0}
		};
		
		matrix = MatrixSetZero.checkMatrix(matrix, M, N);
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%4s", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
