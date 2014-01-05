package leetcode;

public class MinimumPathSum {

	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * 
	 * */

	private int gMinSum = Integer.MAX_VALUE;
	private int calledTimes = 0;
	private int[][] dp = null;

	public int minPathSum(int[][] grid) {
		walk(grid, 0, 0, 0);
		return gMinSum;
	}

	private void walk(int[][] grid, int x, int y, int sum) {
		calledTimes++;

		if (dp == null)
			dp = new int[grid.length][grid[0].length];

		if (x == grid.length - 1 && y == grid[0].length - 1) {
			// finished walking
			sum += grid[x][y];
			gMinSum = Math.min(gMinSum, sum);
			return;
		}
		if (x > grid.length - 1 || y > grid[0].length - 1) {
			// exceed boundary
			return;
		}

		sum += grid[x][y];
		if (sum >= gMinSum)
			return;
		// System.out.println("x: " + x + "  y: " + y + " sum: " + sum);

		walk(grid, x + 1, y, sum);

		walk(grid, x, y + 1, sum);
	}

	public int minPathSum2(int[][] grid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = grid.length;
		int n = grid[0].length;
		int[][] sum = new int[m][n];
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		sum[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			calledTimes++;
			sum[0][i] = grid[0][i] + sum[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			calledTimes++;
			sum[i][0] = grid[i][0] + sum[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				calledTimes++;
				sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
			}
		}
		return sum[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// int[][] matrix = { { 1, 3, 5, 8 }, { 2, 2, 1, 1 }, { 3, 9, 9, 2 } };
		int[][] matrix = { 
				{ 5, 1, 0, 4, 0, 1, 1, 6, 7, 3, 9, 9, 4, 6, 8, 1 },
				{ 9, 1, 0, 6, 4, 2, 8, 0, 1, 6, 0, 2, 7, 9, 0, 4 },
				{ 3, 2, 0, 3, 3, 3, 1, 3, 7, 3, 2, 1, 1, 2, 2, 0 },
				{ 5, 2, 8, 2, 7, 6, 2, 0, 5, 3, 2, 4, 4, 4, 8, 9 },
				{ 7, 0, 5, 2, 4, 6, 7, 1, 1, 1, 2, 2, 6, 6, 4, 1 },
				{ 0, 3, 5, 9, 1, 8, 0, 6, 3, 4, 0, 9, 9, 0, 9, 8 },
				{ 3, 4, 0, 7, 2, 8, 0, 4, 9, 4, 8, 5, 2, 5, 9, 4 },
				{ 0, 4, 4, 1, 4, 6, 0, 7, 0, 2, 7, 1, 3, 8, 9, 8 },
				{ 2, 0, 7, 4, 0, 7, 0, 1, 1, 1, 9, 5, 6, 8, 9, 6 },
				{ 4, 3, 9, 9, 1, 9, 8, 4, 2, 7, 5, 7, 5, 5, 5, 9 },
				{ 7, 4, 6, 9, 1, 8, 0, 4, 9, 9, 9, 7, 9, 8, 3, 4 },
				{ 4, 3, 5, 7, 4, 5, 1, 8, 3, 7, 7, 0, 4, 4, 2, 3 },
				{ 8, 0, 2, 9, 8, 2, 5, 8, 4, 4, 7, 3, 5, 1, 9, 1 },
				{ 6, 4, 8, 2, 2, 2, 1, 7, 1, 8, 7, 5, 5, 1, 0, 3 },
				{ 1, 2, 5, 0, 6, 0, 0, 0, 7, 7, 6, 4, 0, 5, 5, 8 },
				{ 2, 5, 1, 4, 9, 4, 1, 0, 2, 0, 5, 7, 4, 7, 3, 5 },
				{ 9, 8, 7, 8, 8, 9, 8, 5, 9, 6, 9, 9, 2, 6, 0, 6 },
				{ 4, 1, 2, 3, 5, 5, 4, 9, 5, 1, 9, 9, 9, 2, 7, 0 },
				{ 0, 6, 8, 0, 6, 9, 8, 7, 5, 7, 8, 9, 6, 8, 5, 0 } };

		// int [][] matrix = {
		// {1, 1, 5},
		// {4, 2, 6},
		// {3, 3, 1}
		// };

		MinimumPathSum o = new MinimumPathSum();

		System.out.println(o.minPathSum(matrix));
		System.out.println("calledTimes: " + o.calledTimes);

		o.calledTimes = 0;
		System.out.println(o.minPathSum2(matrix));
		System.out.println("calledTimes: " + o.calledTimes);
	}
}
