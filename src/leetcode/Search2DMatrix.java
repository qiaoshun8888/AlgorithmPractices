package leetcode;

public class Search2DMatrix {

	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
	 * 
	 * Given target = 3, return true.
	 * 
	 * */

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row_index = binarySearchVertical(matrix, 0, matrix.length - 1,
				target);
		if (row_index < 0)
			return false;
		int column_index = binarySearchHorizontal(matrix, row_index, 0,
				matrix[0].length - 1, target);
		return column_index >= 0;
	}

	private static int binarySearchVertical(int[][] matrix, int low, int high,
			int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == matrix[mid][0]) {
				return mid;
			} else if (target < matrix[mid][0]) {
				if (mid == 0)
					return -1;
				else
					return binarySearchVertical(matrix, low, mid - 1, target);
			} else {
				if (mid < matrix.length - 1) {
					if (target < matrix[mid + 1][0])
						return mid;
					return binarySearchVertical(matrix, mid + 1, high, target);
				} else if (mid == matrix.length - 1) {
					return mid;
				}
			}
		}
		return -1;
	}

	private static int binarySearchHorizontal(int[][] matrix, int row, int low,
			int high, int target) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (matrix[row][mid] == target)
				return mid;
			else if (target < matrix[row][mid])
				return binarySearchHorizontal(matrix, row, low, mid - 1, target);
			else
				return binarySearchHorizontal(matrix, row, mid + 1, high,
						target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 12, 14, 16, 18, 20 }, { 31, 33, 35, 37, 39 },
				{ 50, 60, 70, 80, 90 } };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println(searchMatrix(matrix, matrix[i][j]));
			}
		}
		System.out.println(searchMatrix(matrix, 99));
	}
}
