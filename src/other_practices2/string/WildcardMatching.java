package other_practices2.string;

public class WildcardMatching {
	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*")
	 * → true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
	 */

	// O(n!m!) TLE!!!
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.length() == 0)
			return s.length() == 0;
		return matchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
	}

	private boolean matchHelper(char[] cc_s, char[] cc_p, int index_s,
			int index_p) {
		// base case, all the characters matched.
		if (index_p == cc_p.length || index_s == cc_s.length) {
			return index_p == cc_p.length && index_s == cc_s.length;
		}
		// current p is '*', try to match any sequence of characters.
		if (cc_p[index_p] == '*') {
			// move to the last '*'
			while (index_p < cc_p.length && cc_p[index_p] == '*') {
				index_p++;
			}
			index_p--;
			while (index_s < cc_s.length) {
				boolean match = matchHelper(cc_s, cc_p, index_s + 1,
						index_p + 1);
				if (match)
					return true;
				index_s++;
			}
			// didn't match.
			return false;
		} else {
			// current p is not '*'
			if (cc_s[index_s] != cc_p[index_p] && cc_p[index_p] != '?')
				return false;
			return matchHelper(cc_s, cc_p, index_s + 1, index_p + 1);
		}
	}

	// Greedy Algorithm.
	public boolean isMatch2(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.length() == 0)
			return s.length() == 0;
		// deal with head
		int i = 0;
		while (i < p.length() && i < s.length() && p.charAt(i) != '*') {
			if (p.charAt(i) != s.charAt(i) && p.charAt(i) != '?')
				return false;
			i++;
		}
		// if i reaches the end of the s, but not the end of the p, we look at
		// whether the left characters in p are '*' or not.
		if (i == s.length()) {
			while (i < p.length())
				if (p.charAt(i++) != '*')
					return false;
			return true;
		}
		// if i reaches the end of the p, but not the end of the s, that means
		// there is no more characters other than '*' could match the left
		// characters in s.
		else if (i == p.length()) {
			return false;
		} else {
			s = s.substring(i);
			p = p.substring(i);
		}

		// deal with tail
		i = p.length() - 1;
		int j = s.length() - 1;
		while (i >= 0 && j >= 0 && p.charAt(i) != '*') {
			if (p.charAt(i) != s.charAt(j) && p.charAt(i) != '?')
				return false;
			i--;
			j--;
		}
		// j < 0 means j reaches the head of the s. So we look at the left
		// characters in p and see if they are all '*'. If it is not, then s and
		// p don't match, and we return false;
		if (j < 0) {
			while (i >= 0) {
				if (p.charAt(i--) != '*')
					return false;
			}
			return true;
		}
		// i < 0 means i reaches the head of the p but j doesn't reach the head
		// of s. That means there is no more characters other than '*' could
		// match the left characters in s.
		else if (i < 0) {
			return false;
		} else {
			s = s.substring(0, j + 1);
			p = p.substring(0, i + 1);
		}
		
		// split p into several pattern groups.
		String[] patterns = p.split("[*]");
		for (String pattern : patterns) {
			if (pattern.length() > 0) {
				int index = getFirstIndex(s, pattern);
				if (index < 0)
					return false;
				else
					s = s.substring(index + pattern.length());
			}
		}
		return true;
	}

	// find the first substring in s that matches the pattern p.
	private int getFirstIndex(String s, String p) {
		if (p.length() > s.length())
			return -1;
		int i = 0;
		// iterate the string s. We end at s.length() - p.length() because there
		// is not enough characters in s that match the pattern p.
		while (i <= s.length() - p.length()) {
			// find the starting point.
			// TODO(sqiao): why not i <= s.length() - p.length()
			while (i < s.length() && s.charAt(i) != p.charAt(0)
					&& p.charAt(0) != '?')
				i++;
			// if didn't find the starting point.
			if (i > s.length() - p.length())
				return -1;
			int j = i;
			// check if the substring from the starting point i matches the
			// pattern p.
			while (j - i < p.length()
					&& (s.charAt(j) == p.charAt(j - i) || p.charAt(j - i) == '?'))
				j++;
			// found the match!
			if (j - i == p.length())
				return i;
			// didn't found, keep looking from the next index of s.
			i++;
		}
		return -1;
	}

	public static void main(String[] args) {
		String[][] test_cases = { { "aa", "a" }, // 0
				{ "aa", "aa" }, // 1
				{ "aaa", "aa" }, // 2
				{ "aa", "*" }, // 3
				{ "aa", "a*" }, // 4
				{ "ab", "?*" }, // 5
				{ "aab", "c*a*b" }, // 6
				{ "", "" }, // 7
				{ null, null }, // 8
				{ "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
						"a*******b" }, // 9
		};
		boolean[] expected_result = { false, true, false, true, true, true,
				false, true, false, false };
		WildcardMatching o = new WildcardMatching();
		for (int i = 0; i < test_cases.length; i++) {
			String[] s_p = test_cases[i];
			boolean result = o.isMatch2(s_p[0], s_p[1]);
			System.out.println("TEST CASE [" + i + "]: "
					+ (result == expected_result[i]));
		}
	}
}
