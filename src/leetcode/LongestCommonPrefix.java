package leetcode;

public class LongestCommonPrefix {

	/**
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 * 
	 * e.g.
	 * 
	 * 		{"aaa", "aa", "aaba"}
	 * 
	 * 		"aa"
	 * 
	 * */

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return new String();
		else if (strs.length == 1)
			return strs[0];

		char[] cc1 = strs[0].toCharArray();
		if (cc1.length == 0) return new String();
		
		int longestIndex = -1;
		for (int i = 1; i < strs.length; i++) {
			char[] cc = strs[i].toCharArray();
			if (cc.length == 0) return new String();
			
			int index = 0;
			for (int j = 0; j < Math.min(cc1.length, cc.length); j++) {
				if (cc[j] != cc1[j]) {
					if (j == 0) return new String();
					break;
				}
				index++;
			}
			
			if (longestIndex == -1) longestIndex = index;
			else longestIndex = Math.min(index, longestIndex);
		}

		return strs[0].substring(0, longestIndex);
	}

	public static void main(String[] args) {
		String[] strs = { "a", "a" };
		LongestCommonPrefix o = new LongestCommonPrefix();
		System.out.println("- " + o.longestCommonPrefix(strs));
	}
}
