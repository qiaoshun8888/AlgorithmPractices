package crackingTheCodingInterview2;

public class Ch1_RotateMatrix {

	/**
	 * Given an image represented by an NxN matrix, where each pixel in the
	 * image is 4 bytes, write a method to rotate the image by 90 degrees. Can
	 * you do this in place?
	 * 
	 * */
	
	/**
	 *    Input:
	 *    
	 *      1   2   3   4
	 *      5   6   7   8
	 *      9   10  11  12
	 *      13  14  15  16
	 *    
	 *    Output:
	 *    
	 *    	13	9	5	1	
	 *		14	10	6	2	
	 * 		15	11	7	3	
	 *		16	12	8	4
	 * 
	 * */
	
	public static void rotate(int [][] matrix) {
		int temp = 0, n = matrix.length;
		
		for (int layer = 0; layer < n / 2; layer++) {
			for (int i = layer; i < n - layer - 1; i++) {
				temp = matrix[layer][i];
				// left -> top
				matrix[layer][i] = matrix[n - i - 1][layer];
				
				// bottom -> left
				matrix[n - i - 1][layer] = matrix[n - layer - 1][n - i - 1];
				
				// right -> bottom
				matrix[n - layer - 1][n - i - 1] = matrix[i][n - layer - 1];
				
				// top -> right
				matrix[i][n - layer - 1] = temp;
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
		rotate(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
