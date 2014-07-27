package other_practices2.string;

public class LongestCommonPrefix {

	/*
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */

	public String longestCommonPrefix(String[] strs) {
		if (strs == null)
			return null;
		if (strs.length == 0 || strs[0].length() == 0)
			return "";
		for (int index = 0; index < strs[0].length(); index++) {
			char c = strs[0].charAt(index);
			for (String str : strs) {
				if (str.length() == 0 || index == str.length()
						|| str.charAt(index) != c)
					return strs[0].substring(0, index);
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		String[] strs = { "abcefsef", "abcefewdsefefwefwe", "abcefe203ep3ke2",
				"abcefa22", "abceee", "ab" };
		LongestCommonPrefix o = new LongestCommonPrefix();
		System.out.println(o.longestCommonPrefix(strs));
	}
}
