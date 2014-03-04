package amazon.onlineTest;

/**
 * Question3.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 15, 2014
 */

import java.util.*;

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
		
		Set<String> path = new HashSet<String>();
		
		int x = 0, y = 0, g_min = Integer.MIN_VALUE;
		
		int timeout = 0;
		
		while (i < rows || j < cols) {
			if (timeout++ > 20) break;
			
			int v = matrix[i][j];
			
			path.add(i + "," + j);
			
			// System.out.print(matrix[i][j] + " " + " (" + i + ", " + j + ")");
			System.out.println(v + " (" + i + "," + j + ")");

			// keep tracking the min value in the path
			if (v < min) min = v;
			
			if (min < g_min) {
				// re-search
				i = x;
				j = y;
				System.out.println("Back to: " + "(" + i + "," + j + ")  min: " + min + " g_min: " + g_min);
				// reset min
				min = g_min; // Integer.MAX_VALUE;
				// reset g_min
				g_min = Integer.MIN_VALUE;
				// continue;
			}
			
			if (i == rows - 1 && j == cols - 1) {
				System.out.println("");
				return min;
			}

			int right_v = Integer.MIN_VALUE, bottom_v = Integer.MIN_VALUE;
			if (j + 1 < cols) right_v = matrix[i][j + 1];
			if (i + 1 < rows) bottom_v = matrix[i + 1][j];
			if (right_v > bottom_v) {
				if (bottom_v > g_min) {
					System.out.println("bottom_v(" + bottom_v + ") > g_min(" + g_min + ") -> " + bottom_v);
					x = i + 1; y = j;
					g_min = bottom_v;
				}
				j++;
			}
			else {
				if (right_v > g_min) {
					System.out.println("right_v(" + right_v + ") > g_min(" + g_min + ") -> " + right_v);
					x = i; y = j + 1;
					g_min = right_v;
				}
				i++;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// re-search case 2
		int[][] matrix = { 
				{ 9, 9, 9 , 1}, 
				{ 8, 7, 1 , 1}, 
				{ 9, 9, 1 , 1},
				{ 9, 9, 9 , 9},
		};
		
		// re-search case 1
//		int[][] matrix = { 
//				{ 9, 9, 9 , 9}, 
//				{ 8, 7, 8 , 1}, 
//				{ 9, 9, 8 , 1},
//				{ 9, 9, 8 , 9},
//		};
		
		// normal case
//		int[][] matrix = {
//				{ 5, 1, 6 }, 
//				{ 4, 5, 8 }, 
//				{ 2, 3, 9 },
//		};
		
		// large case
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
		System.out.println("minimum value along the path: " + minimumPointOnMaximalPath2(matrix));
	}
}
