package leetcode;

public class LongestPalindromeSubstring {

	/**
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 * 
	 * */
	
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int gStart = 0, gEnd = 0, left = 0, right = 0;
		char[] cc = s.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			left = i;
			right = i;

			while (left >= 0 && right < cc.length) {
				if (cc[left] != cc[right])
					break;
				left--;
				right++;
			}

			if (++left < --right && gEnd - gStart < right - left) {
				gStart = left;
				gEnd = right;
			}

			left = i;
			right = i + 1;
			while (left >= 0 && right < cc.length) {
				if (cc[left] != cc[right])
					break;
				left--;
				right++;
			}

			if (++left < --right && gEnd - gStart < right - left) {
				gStart = left;
				gEnd = right;
			}
		}

		return s.substring(gStart, gEnd + 1);
	}
}
