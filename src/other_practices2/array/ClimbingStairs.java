package other_practices2.array;

public class ClimbingStairs {

	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */

	public int climbStairs(int n) {
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		return climbStairsHelper(n, dp);
	}

	private int climbStairsHelper(int n, int[] dp) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (dp[n] == 0) {
			dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);
		}
		return dp[n];
	}

	public int climbStairsIterative(int n) {
		if (n == 0)
			return 0;
		int cur = 1, pre = 1;
		for (int i = 1; i < n; i++) {
			int tmp = cur;
			cur += pre;
			pre = tmp;
		}
		return cur;
	}

	public static void main(String[] args) {
		// n: 1 2 3 4 5
		// 1 2 3 5 8
		int n = 10;
		ClimbingStairs o = new ClimbingStairs();
		System.out.println(o.climbStairs(n));
		System.out.println(o.climbStairsIterative(n));
	}
}
