package programcreek.top10InterviewQuestions.stringArray;

import java.util.*;

public class ValidParentheses {

	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 * 
	 * */

	public boolean isValid(String s) {
		if ((s.length() & 1) > 0) return false; // check odd length
		
		char[] cc = s.toCharArray();

		Stack<Integer> stack = new Stack<Integer>();

		for (char c : cc) {
			switch (c) {
			case '(':
			case '[':
			case '{': {
				stack.push((int) c);
				break;
			}
			default:
				if (stack.isEmpty() || !isValid((char) (int) stack.pop(), c))
					return false;

			}
		}

		return stack.isEmpty();
	}

	private boolean isValid(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']')
				|| (c1 == '{' && c2 == '}');
	}

	public static void main(String[] args) {
		String[] testCases = {"[", "]]", "((", "()[]{}", "([)]", "(]", "()" };
		
		ValidParentheses o = new ValidParentheses();
		
		for (String testCase : testCases) {
			System.out.println(o.isValid(testCase));
		}
	}
}
