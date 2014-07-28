package other_practices2.stack;

import java.util.Stack;

public class ValidParenthese {

	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */

	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ']' && c != ')' && c != '}') {
				stack.push(s.charAt(i));
			} else if ((c == ']' && (stack.isEmpty() || stack.pop() != '['))
					|| (c == ')' && (stack.isEmpty() || stack.pop() != '('))
					|| (c == '}' && (stack.isEmpty() || stack.pop() != '{'))) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String[] testCases = { "[", "]]", "((", "()[]{}", "([)]", "(]", "()",
				"[({}){}()]" };
		boolean[] expectedResults = { false, false, false, true, false, false,
				true, true };

		ValidParenthese o = new ValidParenthese();

		for (int i = 0; i < testCases.length; i++) {
			System.out.println(o.isValid(testCases[i]) == expectedResults[i]);
		}
	}
}
