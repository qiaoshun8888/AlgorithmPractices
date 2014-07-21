package other_practices2.array;

public class RotateImage {

	/*
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 */

	public void rotate(int[][] matrix) {
		if (matrix == null)
			return;
		int n = matrix.length - 1, layer = (n + 1) / 2;
		for (int i = 0; i < layer; i++) {
			for (int j = i; j < n - i; j++) {
				int tmp = matrix[i][j];
				// top
				matrix[i][j] = matrix[n - j][i];
				// left
				matrix[n - j][i] = matrix[n - i][n - j];
				// bottom
				matrix[n - i][n - j] = matrix[j][n - i];
				// right
				matrix[j][n - i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } 
				};
		RotateImage o = new RotateImage();
		o.rotate(matrix);
		for (int[] vs : matrix) {
			for (int v : vs) {
				System.out.print(v + "\t");
			}
			System.out.println();
		}
	}
}
