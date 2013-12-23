package crackingProgrammingInterviewYouTuBe;

public class N26LongestPalindrome {
	
	// Second method: Improve method O(N^2)
	public static String longestPalindromeImprove(String str) {
		char [] cc = str.toCharArray();
		int lp_start = 1, lp_end = 0;
		
		for (int mid = 0; mid < str.length(); mid++) {
			
			int left = mid, right = mid;
			
			// Odd  12321 -> mid 3
			while (left >= 0 && right < str.length()) {
				if (isPalindrome(cc, left, right)) {
					if (right - left > lp_end - lp_start) {
						lp_start = left;
						lp_end = right;
					}
				}
				left--;right++;
			}
			
			left = mid;
			right = mid + 1;
			// Even 123321 -> mid 33
			while (left >= 0 && right < str.length()) {
				if (isPalindrome(cc, left, right)) {
					if (right - left > lp_end - lp_start) {
						lp_start = left;
						lp_end = right;
					}
				}
				left--;right++;
			}
		}
		
		return str.substring(lp_start, lp_end + 1);
	}

	// First method: Naive method O(N^3)
	public static String longestPalindromeNaive(String str) {
		char [] cc = str.toCharArray();
		int lp_start = 0, lp_end = 0;
		for (int start = 0; start < str.length(); start++) { // 123321
			for (int end = start + 1; end <= str.length(); end++) { // <= is necessary to access the last char in string. Otherwise the palindrome of '3344123455432' won't be 23455432, it will be 345543 
				if (isPalindrome(cc, start, end - 1)) {
					if (end - start > lp_end - lp_start) {
						lp_end = end;
						lp_start = start;
					}
				}
			}
		}
		return str.substring(lp_start, lp_end);
	}
	
	// Supprot method to decide if given char[] is a palindrome
	private static boolean isPalindrome(char [] cc, int start, int end) {
		// 2 2 3 4 3 2 5
		for (int i = start; i <= (start + end)/2; i++) { // <= is necessary to detect, 234(56)432, the middle is palindrome or not
			if (cc[i] == cc[start+end-i]) continue;
			else return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		String str = "3344123455432";
		System.out.println("Longest Palindrome Naive: " + longestPalindromeNaive(str));
		System.out.println("Longest Palindrome Improve: " + longestPalindromeImprove(str));
	}
}
