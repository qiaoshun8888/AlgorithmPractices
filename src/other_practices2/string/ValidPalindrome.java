package other_practices2.string;

public class ValidPalindrome {

	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		// convert to lower case
		s = s.toLowerCase();
		char[] cc = s.toCharArray();
		int i = 0, j = cc.length - 1;
		while (i < j) {
			if (!isAlnum(cc[i]))
				i++;
			else if (!isAlnum(cc[j]))
				j--;
			else if (cc[i++] != cc[j--]) {
				return false;
			}
		}
		return true;
	}

	public boolean isAlnum(char c) {
		// '0' - 48, '9' - 57
		// 'a' - 97, 'z' - 122
		// 'A' - 65, 'Z' - 90
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
	}

	public static void main(String[] args) {
		String s = "1a3a1";// "A man, a plan, a canal: Panama";
		ValidPalindrome o = new ValidPalindrome();
		System.out.println(o.isPalindrome(s));
		System.out.println((int) 'Z');
	}
}
