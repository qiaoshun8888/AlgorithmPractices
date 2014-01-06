package crackingTheCodingInterview2;

public class Ch1_LongestPalindrome {

	/**
	 * Find the longest palindrome in a given string. 
	 * 
	 * e.g.
	 * 
	 * 		3344123455432
	 * 
	 * Longest palindrome:
	 * 
	 * 		23455432
	 * 
	 * */
	
	private static int calledTimes = 0;
	
	public static String longestPalindromeImprove(String str) {
		if (str == null) return null;
		if (str.length() == 1) return str;
		
		char [] cc = str.toCharArray();
		int lLeft = 0, lRight = 0;
		for (int mid = 0; mid < cc.length; mid++) {
			int left = mid, right = mid;
			
			// case:  12321
			while (left >= 0 && right < cc.length) {
				calledTimes++;
				if (cc[left] == cc[right]) {
					if (right - left > lRight - lLeft) {
						lLeft = left;
						lRight = right;
					}
				}
				else {
					break;
				}
				left--;
				right++;
			}
			
			// case: 123321
			left = mid;
			right = mid + 1;
			while (left >= 0 && right < cc.length) {
				calledTimes++;
				if (cc[left] == cc[right]) {
					if (right - left > lRight - lLeft) {
						lLeft = left;
						lRight = right;
					}
				}
				else {
					break;
				}
				left--;
				right++;
			}
		}
		
		return str.substring(lLeft, lRight + 1);
	}
	
	public static String longestPalindromeNaive(String str) {
		if (str == null) return null;
		if (str.length() == 1) return str;
		
		char [] cc = str.toCharArray();
		String longestPalindrome = null;
		for (int start = 0; start < cc.length - 1; start++) {
			for (int end = start + 1; end < cc.length; end++) {
				if (isPalindrome(cc, start, end)) {
					if (longestPalindrome == null) {
						longestPalindrome = substring(cc, start, end);
					}
					else {
						String temp = substring(cc, start, end);
						if (temp.length() > longestPalindrome.length()) {
							longestPalindrome = temp;
						}
					}
				}
			}
		}
		
		return longestPalindrome;
	}
	
	private static boolean isPalindrome(char [] cc, int start, int end) {
		while (start < end) {
			calledTimes++;
			if (cc[start++] != cc[end--]) return false;
		}
		return true;
	}
	
	private static String substring(char [] cc, int start, int end) {
		StringBuilder sb = new StringBuilder();
		while (start <= end) {
			sb.append(cc[start++]);
		}
		return sb.toString();
	}
	
	public static void main(String [] args) {
		String str = "3344123455432";
		System.out.println(longestPalindromeNaive(str));
		System.out.println("calledTimes: " + calledTimes);
		System.out.println();
		
		calledTimes = 0;
		System.out.println(longestPalindromeImprove(str));
		System.out.println("calledTimes: " + calledTimes);
	}
}
