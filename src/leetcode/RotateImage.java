package leetcode;

public class RotateImage {

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 * 
	 * */
	
	/*
     *   1  2  3  4
     *   5  6  7  8
     *   9  10 11 12
     *   13 14 15 16
     */
	public static void rotateImage(int[][] matrix) {
		int n = matrix.length, layers = n / 2;
		for (int layer = 0; layer < layers; layer++) {
			for (int i = layer; i < n - layer - 1; i++) {
				int temp = matrix[layer][i];

				// left -> top
				matrix[layer][i] = matrix[n - 1 - i][layer];

				// bottom -> left
				matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];

				// right -> bottom
				matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];

				// top -> right
				matrix[i][n - 1 - layer] = temp;
			}
		}
	}
	
	public static void main(String [] args) {
		int [][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		rotateImage(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for ( int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
