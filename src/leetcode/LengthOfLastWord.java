package leetcode;

/**
 * LengthOfLastWord.java
 * 
 * Description: Given a string s consists of upper/lower-case alphabets and
 * empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] cc = s.toCharArray();

		int preLength = 0, length = 0;

		for (int i = 0; i < cc.length; i++) {
			if (cc[i] == ' ') {
				if (length != 0)
					preLength = length;
				length = 0;
			} else
				length++;
		}

		return length == 0 ? preLength : length;
	}

	public static void main(String[] args) {
		LengthOfLastWord o = new LengthOfLastWord();
		System.out.println(o.lengthOfLastWord("Hello World"));
	}
}
