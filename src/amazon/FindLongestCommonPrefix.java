package amazon;

import leetcode.LongestCommonPrefix;

public class FindLongestCommonPrefix {

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
	
	public static String longestCommonPrefix(String [] strs) {
		if (strs == null) return null;
		if (strs.length == 0) return new String();
		
		char [] cc = strs[0].toCharArray();
		
		int longestIndex = -1;
		
		for (int i = 1; i < strs.length; i++) {
			char [] ccTemp = strs[i].toCharArray();
			int index = check(cc, ccTemp);
			longestIndex = Math.max(longestIndex, index);
		}
		
		if (longestIndex == -1) return null;
		
		return strs[0].substring(0, longestIndex + 1);
	}
	private static int check(char [] cc1, char [] cc2) {
		int end = Math.min(cc1.length, cc2.length);
		int index = -1;
		for (int j = 0; j < end; j++) {
			if (cc1[j] != cc2[j]) break;
			else index = j;
		}
		return index;
	}
	
	public static void main(String[] args) {
		String[] strs = {"aaa", "aa", "aaba"};
		LongestCommonPrefix o = new LongestCommonPrefix();
		System.out.println("- " + o.longestCommonPrefix(strs));
	}
}
