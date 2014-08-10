package other_practices2.dp;


public class PalindromePartitioningII {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

		Return the minimum cuts needed for a palindrome partitioning of s.

		For example, given s = "aab",
		Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 */

	public int minCut(String s) {
		if (s == null || s.length() == 0) return 0;
		int n = s.length();
		// use to record whether s.substring(i, j + 1) is palindrome.
		boolean[][] isPalindrome = new boolean[n][n];
		// use to record the min cut of s.substring(i).
		int[] cut = new int[n + 1];
		cut[n] = -1;
		for (int i = n - 1; i >= 0; i--) {
			cut[i] = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && 
						(j - i < 2 || isPalindrome[i + 1][j - 1])) {
					cut[i] = Math.min(1 + cut[j + 1], cut[i]);
					isPalindrome[i][j] = true;
				}
			}
		}
		return cut[0];
	}

	public static void main(String[] args) {
		String s = "aab";
		PalindromePartitioningII o = new PalindromePartitioningII();
		System.out.println(o.minCut(s));
	}
}
