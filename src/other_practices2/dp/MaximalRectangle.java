package other_practices2.dp;

import java.util.Stack;

public class MaximalRectangle {

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, 
	 * find the largest rectangle containing all ones and return its area.
	 */

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int[][] height = new int[m][n];
		// actually we know that height can just be a int[n + 1],
		// however, int that case, we have to write the 2 parts together in row traverse.
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0')
					height[i][j] = 0;
				else
					height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
			}
		}

		for (int i = 0; i < m; i++) {
			int area = maxAreaInHist(height[i]);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private int maxAreaInHist(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i < height.length;) {
			int v = height[i];
			if (s.isEmpty() || v >= height[s.peek()]) {
				s.push(i++);
			} else {
				int topIndex = s.pop();
				int area = (s.isEmpty() ? i : i - s.peek() - 1) * height[topIndex];
				maxArea = Math.max(maxArea, area);
			}
		}
		int index = height.length;
		while (!s.isEmpty()) {
			int topIndex = s.pop();
			int area = height[topIndex] * (s.isEmpty() ? index : index - s.peek() - 1);
			maxArea = Math.max(maxArea, area); 
		}
		return maxArea;
	}

	public static void main(String[] args) {
		char[][] matrix = {
				{'0', '0', '1', '1'},
				{'1', '1', '1', '0'},
				{'1', '1', '1', '0'},
				{'1', '1', '0', '1'},
		};
		MaximalRectangle o = new MaximalRectangle();
		System.out.println(o.maximalRectangle(matrix));
	}
}
