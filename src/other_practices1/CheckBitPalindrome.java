package other_practices1;

public class CheckBitPalindrome {

	/**
	 * Describe a function that takes an int value, and returns true if the bit
	 * pattern of that int value is the same if you reverse it (i.e. it's a
	 * palindrome); [e.g.,] boolean isPalindrome(int x)
	 * 
	 * */
	
	public static boolean isPalindrome(int x) {
		int left = 0, y = x, right = 0;
		while (y > 0) {
			left ++;
			y >>= 1;
		}
		left -= 1; // bit start from 0
		while (left > right) {
			if (((x & (1 << left)) > 0 ? 1 : 0) == ((x & (1 << right)) > 0 ? 1 : 0)) {
				left--;
				right++;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args) {
		int x = 21;
		System.out.printf("x=%d, %s\n", x, Integer.toBinaryString(x));
		System.out.println("Is palindrome? " + (isPalindrome(x) ? "YES" : "NO"));
	}
}
