package other_practices2.string;

public class RegularExpressionMatching {

	/*
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the
	 * preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa",
	 * ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
	 */

	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;
		// p's length 1 is special case
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1
					|| (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
				return false;
			}
			return isMatch(s.substring(1), p.substring(1));
		}
		else {
			int len = s.length();
			int i = -1;
			while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public boolean isMatch2(String s, String p) {
		if (p == null || p.length() == 0)
			return s.length() == 0;
		char[] cc_s = s.toCharArray();
		char[] cc_p = p.toCharArray();
		return matchHelper(cc_s, cc_p, 0, 0);
	}

	private boolean matchHelper(char[] cc_s, char[] cc_p, int index_s,
			int index_p) {
		// base case, we iterated all the whole pattern.
		if (index_p == cc_p.length) {
			return index_s == cc_s.length;
		}

		// next pattern is '*'
		if (index_p < (cc_p.length - 1) && cc_p[index_p + 1] == '*') {
			// 1. current s don't need to match the pattern, skip it.
			boolean match = matchHelper(cc_s, cc_p, index_s, index_p + 2);
			if (match)
				return true;
			// 2. current s should match current p, or current p is '.'
			while (index_s < cc_s.length
					&& (cc_s[index_s] == cc_p[index_p] || cc_p[index_p] == '.')) {
				match = matchHelper(cc_s, cc_p, index_s + 1,
						index_p + 2);
				if (match)
					return true;
				index_s++;
			}
			return false;
		} else {
			// if next pattern is not '*', then current s must match current p or p is '.'
			if (index_s < cc_s.length && cc_s[index_s] != cc_p[index_p]
					&& cc_p[index_p] != '.') {
				return false;
			}
			return matchHelper(cc_s, cc_p, index_s + 1, index_p + 1);
		}
	}

	public static void main(String[] args) {
		String[][] test_cases = {
				{"aa", "a"},  // 0
				{"aa", "aa"},  // 1
				{"aaa", "aa"},  // 2
				{"aa", "a*"},  // 3
				{"aa", ".*"},  // 4
				{"ab", ".*"},  // 5
				{ "aab", "c*a*b" },  // 6
				{ "aab", "c*a*bb" }, // 7
				{ "ab", ".*c*" },  // 8
				{ "a", "ab*c*" },  // 9
				{ "", ".*c*" },  // 10
				{ "aaa", "a*a" }, // 11
				{ "bbbba", ".*a*a" }, // 12
				{ "a", "ab*a" }, // 13
				{ "aaba", "ab*a*c*a" }, // 14
		};
		boolean[] expected_result = { false, true, false, true, true, true,
				true, false, true, true, true, true, true, false, false };
		RegularExpressionMatching o = new RegularExpressionMatching();
		for (int i = 0; i < test_cases.length; i++) {
			String[] s_p = test_cases[i];
			boolean result = o.isMatch2(s_p[0], s_p[1]);
			System.out.println("TEST CASE [" + i + "]: "
					+ (result == expected_result[i]));
		}
	}
}
