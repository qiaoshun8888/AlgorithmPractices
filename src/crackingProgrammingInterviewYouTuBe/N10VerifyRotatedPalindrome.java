package crackingProgrammingInterviewYouTuBe;

public class N10VerifyRotatedPalindrome {

	/**
	 * Verify is a char string a rotated palindrome.
	 * 
	 * */

	/*
	 * Correct solution
	 * */
	public static boolean verifyRotatedPalindrome(String s) {
		if (s.length() <= 1) return true;
		char [] cc = s.toCharArray();
		for (int i = 1; i < cc.length; i++) {
			if (isPalindrome(s.substring(i) + s.substring(0, i))) return true;
		}
		return false;
	}
	private static boolean isPalindrome(String s) {
		char [] cc = s.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			if (cc[i] != cc[cc.length - i - 1]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "CCABBA";
		System.out.println(verifyRotatedPalindrome(str1));
	}
}
