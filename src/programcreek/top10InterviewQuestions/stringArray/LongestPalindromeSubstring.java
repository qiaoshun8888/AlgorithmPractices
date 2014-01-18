package programcreek.top10InterviewQuestions.stringArray;

public class LongestPalindromeSubstring {

	/**
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 * 
	 * */
	
	// abcccba
	public static String longestPalindromeNaive(String s) {
		if (s == null || s.length() <= 1) return s;
		
		int gStart = 0, gEnd = 0;
		char [] cc = s.toCharArray();
		for (int i = 0; i < cc.length - 1; i++) {
			for (int j = 1; j < cc.length; j++) {
				if (isPalindrome(cc, i, j)) {
					if (j - i > gEnd - gStart) {
						gEnd = j;
						gStart = i;
					}
				}
			}
		}
		
		return s.substring(gStart, gEnd + 1);
	}
	
	// abcccba
	public static String longestPalindromeImprove(String s) {
		if (s == null || s.length() <= 1) return s;
		
		int gStart = 0, gEnd = 0, left = 0, right = 0;
		char [] cc = s.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			left = i; right = i;
			
			while (left >= 0 && right < cc.length) {
				if (cc[left] != cc[right]) break;
				left--; right++;
			}
			
			if (++left < --right && gEnd - gStart < right - left) {
				gStart = left; gEnd = right;
			}
			
			left = i; right = i + 1;
			while (left >= 0 && right < cc.length) {
				if (cc[left] != cc[right]) break;
				left--; right++;
			}
			
			if (++left < --right && gEnd - gStart < right - left) {
				gStart = left; gEnd = right;
			}
		}
		
		return s.substring(gStart, gEnd + 1);
	}
	
	private static boolean isPalindrome(char [] cc, int start, int end) {
		while (start < end) {
			if (cc[start] != cc[end]) return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String [] strs = {
				"322acdeedca||",
				"acdeedca",
				"322acedca||"
		};
		
		// Test for Naive method
		for (String str : strs) {
			System.out.println(longestPalindromeNaive(str));
		}
		
		// Test for Improve method
		for (String str : strs) {
			System.out.println(longestPalindromeImprove(str));
		}
	}
}
