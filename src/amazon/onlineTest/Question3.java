package amazon.onlineTest;

/**
 * Question3.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 15, 2014
 */

public class Question3 {

	/**
	 * You have a 2d matrix of integers. Find a path from the top-left (0, 0) to
	 * bottom-right (m,n) that avoids small numbers along the way. Specifically
	 * maximize the smallest integer on the path. You are only allowed to move
	 * down or to the right.
	 * 
	 * Simple example (optimal path in bold). Smallest integer on path: 4
	 * 
	 * */

	public static int minimumPointOnMaximalPath2(int[][] matrix) {
		if (matrix == null || (matrix.length == 0))
			return -1;

		int cols = matrix[0].length, rows = matrix.length, min = Integer.MAX_VALUE;
		int i = 0, j = 0;
		
		int x = 0, y = 0, g_min = Integer.MIN_VALUE;
		
		while (i < rows || j < cols) {
			int v = matrix[i][j];
			
			// System.out.print(matrix[i][j] + " " + " (" + i + ", " + j + ")");
			System.out.print(matrix[i][j] + " ");

			// keep tracking the min value in the path
			if (v < min) min = v;
			
			if (min < g_min) {
				// re-search
				min = g_min;
				i = x;
				j = y;
				System.out.println("### " + min + "(" + x + "  " + y + ")");
				continue;
			}
			
			if (i == rows - 1 && j == cols - 1) {
				System.out.println("");
				return min;
			}

			int right_v = Integer.MIN_VALUE, bottom_v = Integer.MIN_VALUE;
			if (i + 1 < rows) right_v = matrix[i + 1][j];
			if (j + 1 < cols) bottom_v = matrix[i][j + 1];
			if (right_v > bottom_v) {
				if (bottom_v >= g_min) {
					x = i; y = j + 1;
					g_min = bottom_v;
				}
				i++;
			}
			else {
				if (right_v >= g_min) {
					x = i + 1; y = j;
					g_min = right_v;
				}
				j++;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 9, 9, 9 , 9}, 
				{ 8, 7, 8 , 1}, 
				{ 9, 9, 8 , 1},
				{ 9, 9, 8 , 9},
		};
		
//		int[][] matrix = {
//				{ 5, 1, 6 }, 
//				{ 4, 5, 8 }, 
//				{ 2, 3, 9 },
//		};
//		
//		int[][] matrix = {
//				{ 5, 1, 6 }, 
//				{ 4, 5, 8 }, 
//				{ 2, 3, 9 },
//				{ 5, 1, 6 }, 
//				{ 4, 5, 8 }, 
//				{ 2, 3, 9 },
//				{ 5, 1, 6 }, 
//				{ 4, 5, 8 }, 
//				{ 2, 3, 9 },
//		};

		System.out.print("Path: ");
		System.out.println(minimumPointOnMaximalPath2(matrix));
	}
}
