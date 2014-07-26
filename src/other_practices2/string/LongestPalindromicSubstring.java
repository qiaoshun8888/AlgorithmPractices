package other_practices2.string;

public class LongestPalindromicSubstring {

	/*
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		// cbabcbabac
		char[] cc = s.toCharArray();
		int start = -1, longestLen = 0;
		for (int i = 0; i < cc.length; i++) {
			// for 'aba'
			int[] pq = helper(cc, i, i);
			if (pq[1] - pq[0] > longestLen) {
				start = pq[0];
				longestLen = pq[1] - pq[0];
			}
			// for 'abba'
			pq = helper(cc, i, i + 1);
			if (pq[1] - pq[0] > longestLen) {
				start = pq[0];
				longestLen = pq[1] - pq[0];
			}
		}
		return s.substring(start, start + longestLen);
	}

	private int[] helper(char[] cc, int p, int q) {
		while (p >= 0 && q < cc.length && cc[p] == cc[q]) {
			p--;
			q++;
		}
		// After the while loop, p and q will be here:
		// nnabcccbamm
		//  ^       ^
		//  p       q
		int[] pq = { p + 1, q }; 
		return pq;
	}

	public static void main(String[] args) {
		// String s = "cbabcbabac";
		String s = "w12ekehdsdjcefiwe10";
		LongestPalindromicSubstring o = new LongestPalindromicSubstring();
		System.out.println(o.longestPalindrome(s));
	}
}
