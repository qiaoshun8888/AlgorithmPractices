package other_practices2.stack;

import java.util.Stack;


public class LongestValidParentheses {

	/*
	 * Given a string containing just the characters'(' and')', find the length
	 * of the longest valid (well-formed) parentheses substring. For "(()", the
	 * longest valid parentheses substring is"()", which has length = 2. Another
	 * example is ")()())", where the longest valid parentheses substring is
	 * "()()", which has length = 4.
	 */

	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int longestLen = 0, last = -1; // the position of the last unmatched ')'
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						// for the case: ")))()()"
						longestLen = Math.max(longestLen, i - last);
					} else {
						// for the case: "((((())"
						longestLen = Math.max(longestLen, i - stack.peek());
					}
				}
			}
		}
		return longestLen;
	}

	public static void main(String[] args) {
		String[] testCases = { "(()", ")()())", "()()()()()()", "))(())((", "",
				"()(()", "())()"
		};
		int[] expectedResults = { 2, 4, 12, 4, 0, 2, 2 };
		LongestValidParentheses o = new LongestValidParentheses();
		for (int i = 0; i < testCases.length; i++) {
			System.out.println(o.longestValidParentheses(testCases[i]));
			System.out
					.println(o.longestValidParentheses(testCases[i]) == expectedResults[i]);
		}
	}
}