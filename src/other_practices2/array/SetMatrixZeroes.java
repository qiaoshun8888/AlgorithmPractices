package other_practices2.array;

public class SetMatrixZeroes {

	/*
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 * 
	 * Follow up: Did you use extra space? A straight forward solution using
	 * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
	 * space, but still not the best solution. Could you devise a constant space
	 * solution?
	 */

	public void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rows[i] || columns[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// Using constant space
	public void setZeroesImprove(int[][] matrix) {
		if (matrix == null)
			return;

		// check first row
		boolean firstRowZero = false;
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// check first column
		boolean firstColumnZero = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstRowZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if (firstColumnZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3, 1, 0},
				{1, 0, 3, 1, 2},
				{1, 2, 0, 1, 1},
				{1, 2, 3, 1, 2},
		};
		SetMatrixZeroes o = new SetMatrixZeroes();
		// o.setZeroes(matrix);
		o.setZeroesImprove(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
