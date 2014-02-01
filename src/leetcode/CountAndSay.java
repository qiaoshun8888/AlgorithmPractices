package leetcode;

/**
 * CountAndSay.java
 * 
 * Description: The count-and-say sequence is the sequence of integers beginning
 * as follows: 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class CountAndSay {

	public String countAndSay(int n) {
		if (n == 0)
			new String();
		String s = "1";
		for (int i = 1; i < n; i++) {
			s = generate(s);
		}
		return s;
	}

	private String generate(String s) {
		char[] cc = s.toCharArray();
		char c0 = cc[0];
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < cc.length; i++) {
			if (cc[i] == c0)
				count++;
			else {
				sb.append(count);
				sb.append(c0);
				c0 = cc[i];
				count = 1;
			}
		}
		sb.append(count);
		sb.append(c0);
		return sb.toString();
	}

	public static void main(String[] args) {
		CountAndSay o = new CountAndSay();
		System.out.println(o.countAndSay(6));
	}
}
