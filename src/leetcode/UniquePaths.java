package leetcode;

public class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * XXXXXX XXXXXX XXXXXX XXXXXX
	 * XXXXXX XXXXXX XXXXXX XXXXXX
	 * XXXXXX IMAGE HERE :P XXXXXX
	 * XXXXXX XXXXXX XXXXXX XXXXXX
	 * XXXXXX XXXXXX XXXXXX XXXXXX
	 * 
	 * Above is a 3 x 7 grid. How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * */

	private int[][] dp = null;
	private int calledTimes = 0;

	public int uniquePaths(int m, int n) {
		calledTimes++;

		if (dp == null)
			dp = new int[m + 1][n + 1];

		if (m == 1 && n == 1)
			return 1;
		if (m < 1 || n < 1)
			return 0;

		if (dp[m][n] == 0) {
			dp[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		UniquePaths o = new UniquePaths();
		System.out.println(o.uniquePaths(3, 3));
		System.out.println("calledTimes: " + o.calledTimes);
	}
}
