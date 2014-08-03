package other_practices2.tree;

public class UniqueBinarySearchTrees {

	/*
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

	public int numTrees(int n) {
		if (n <= 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees o = new UniqueBinarySearchTrees();
		System.out.println(o.numTrees(3));
	}
}
