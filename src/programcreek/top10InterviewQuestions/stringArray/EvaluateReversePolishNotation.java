package programcreek.top10InterviewQuestions.stringArray;

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
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 *  
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 * */
	
	private static final String operants = "+-*/";
	
	public static int solution(String [] strs) {
		Stack<String> stack = new Stack<String>();
		
		for (String s : strs) {
			
			if (!operants.contains(s)) {
				stack.push(String.valueOf(s));
			}
			else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				
				switch(operants.indexOf(s)) {
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
	
	public static void main(String[] args) {
		String [] strs = {"2", "1", "+", "3", "*"};
		String [] strs2 = {"4", "13", "5", "/", "+"};
		System.out.println(solution(strs));
		System.out.println(solution(strs2));
	}
}
