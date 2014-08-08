package other_practices2.search;

public class SearchA2DMatrix {

	/**
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

		Integers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the previous row.
		For example,

		Consider the following matrix:

		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		Given target = 3, return true.

	 */

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) return false;
		int indexVertical = binarySearchVertical(matrix, 0, matrix.length - 1, target);
		// System.out.println(indexVertical);
		if (indexVertical == -1) return false;
		return binarySearchHorizontal(matrix, 0, matrix[0].length - 1, indexVertical, target) != -1;
	}
	private int binarySearchVertical(int[][] matrix, int top, int bottom, int target) {
		if (top <= bottom) {
			// System.out.println(top + "  " + bottom);
			int mid = top + (bottom - top) / 2;
			int val = matrix[mid][0]; 
			if (val == target) return mid;
			if (val > target) {
				if (mid == 0) return mid;
				return binarySearchVertical(matrix, top, mid - 1, target);
			}
			else {
				// System.out.println(val + "  " + matrix[mid + 1][0]);
				if (mid == matrix.length - 1 || val < target && target < matrix[mid + 1][0]) return mid;
				return binarySearchVertical(matrix, mid + 1, bottom, target);
			}
		}
		return -1;
	}
	private int binarySearchHorizontal(int[][] matrix, int left, int right, int index, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			int val = matrix[index][mid];
			// System.out.println(val + "  " + target);
			if (val == target) return mid;
			if (val > target) return binarySearchHorizontal(matrix, left, mid - 1, index, target);
			else return binarySearchHorizontal(matrix, mid + 1, right, index, target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 3, 5, 7, 9},
				{10, 11, 15, 17, 19},
				{22, 25, 27, 29, 33},
				{42, 45, 57, 69, 73},
		};
		/*
		int[][] matrix = {
				{1},
				{10},
				{22},
				{42},
		};
		 */
		int target = 57;
		SearchA2DMatrix o = new SearchA2DMatrix();
		System.out.println(o.searchMatrix(matrix, target));
	}
}
