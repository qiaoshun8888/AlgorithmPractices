package leetcode;

/**
 * LongestSubstringWithoutRepeatingCharacters.java
 * 
 * Description: Given a string, find the length of the longest substring without
 * repeating characters. For example, the longest substring without repeating
 * letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the
 * longest substring is "b", with the length of 1.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;

		char[] cc = s.toCharArray();

		// cdadcabcdabcbb
		int i = 0, j = 0, maxCount = 0;
		boolean [] b = new boolean[26];

		while (i < cc.length) {
			int v = cc[i] - 97;
			if (b[v]) {
				maxCount = Math.max(maxCount, i - j);
				while (cc[i] != cc[j]) {
					b[cc[j] - 97] = false;
					j++;
				}
				j++;
			}
			else {
				b[v] = true;
			}
			i++;
		}

		maxCount = Math.max(maxCount, i - j);

		return maxCount;
	}

	public static void main(String[] args) {
		// String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		// String s = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
		String s = "qopubjguxhxdipfzwswybgfylqvjzhar";
		LongestSubstringWithoutRepeatingCharacters o = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println("Longest Substring length is: " + o.lengthOfLongestSubstring(s));
	}
}
