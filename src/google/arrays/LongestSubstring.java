package google.arrays;

/**
 * LongestSubstring.java
 * 
 * Description: Given a string, find the length of the longest substring without
 * repeating characters. For example, the longest substring without repeating
 * letters for “abcabcbb” is “abc”, which the length is 3. For “bbbbb” the
 * longest substring is “b”, with the length of 1.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, maxCount = 0;
		char[] cc = s.toCharArray();
		boolean [] b = new boolean[256];

		while (i < cc.length) {
			char c = cc[i];
			if (b[(int)c]) {
				maxCount = Math.max(maxCount, i - j);
				while (cc[i] != cc[j]) {
					b[cc[j]] = false;
					j++;
				}
				j++;
			}
			else {
				b[(int)c] = true;  
			}
			i++;
		}
		
		maxCount = Math.max(maxCount, cc.length - j);

		return maxCount;
	}
	
	public static void main(String[] args) {
		LongestSubstring o = new LongestSubstring();
		String s = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"; //"abcabcbb";
		System.out.println(o.lengthOfLongestSubstring(s));
	}
}
