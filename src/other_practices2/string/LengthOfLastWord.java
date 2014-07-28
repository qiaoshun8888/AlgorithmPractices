package other_practices2.string;

public class LengthOfLastWord {

	/*
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 */

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		boolean flag = false;
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!flag && s.charAt(i) != ' ') {
				flag = true;
			} else if (s.charAt(i) == ' ') {
				if (flag)
					return j - i - 1;
				j = i;
			}
		}
		if (flag) {
			return j;
		}
		return 0;
	}

	public static void main(String[] args) {
		String s = "s  ";
		LengthOfLastWord o = new LengthOfLastWord();
		System.out.println(o.lengthOfLastWord(s));
	}
}
