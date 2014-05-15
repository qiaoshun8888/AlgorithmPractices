package leetcode;

public class PalindromeNumber {

	/**
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 * 
	 * */

	public static boolean isPalindrome(int x) {
		// Here we assume -1221 is also a palindrome number
		if (x < 10 && x > -10)
			return true;
		// If negative number is not a palindrome, we shoud return false.
		/*
		 * if (x < 0) return false;
		 * 
		 * */
		
		
		// tricky part, we should convert x to long.
		// When x equals Integer.MIN_VALUE we can not get the absolute value by using -x
		long y = Math.abs((long)x);
		
		long i = 10;
		while (i < y) {
			i *= 10;
		}

		if (i == y)
			return false;

		i /= 10;

		int j = 10;
		while (i >= j) {
			if (y / i != ((y % j) / (j / 10)))
				return false;
			y -= i * (y / i);

			i /= 10;
			j *= 10;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147483648));
		System.out.println(isPalindrome(-2147447412));
		System.out.println(isPalindrome(1874994781));
	}
}
