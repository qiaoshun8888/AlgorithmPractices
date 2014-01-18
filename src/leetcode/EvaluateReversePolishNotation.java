package leetcode;

import java.util.*;

public class EvaluateReversePolishNotation {

	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation.
	 * 
	 * Valid operators are +, -, *, /. Each operand may be an integer or another
	 * expression.
	 * 
	 * Some examples: 
	 * 
	 * 		["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
	 * 
	 * 		["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 * */

	private static final String operants = "+-*/";

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;

		Stack<String> stack = new Stack<String>();

		for (String s : tokens) {

			if (!operants.contains(s)) {
				stack.push(String.valueOf(s));
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				switch (operants.indexOf(s)) {
				case 0: {
					stack.push(String.valueOf(a + b));
					break;
				}
				case 1: {
					stack.push(String.valueOf(b - a));
					break;
				}
				case 2: {
					stack.push(String.valueOf(a * b));
					break;
				}
				case 3: {
					stack.push(String.valueOf(b / a));
					break;
				}
				}
			}
		}

		return Integer.valueOf(stack.pop());
	}
}
