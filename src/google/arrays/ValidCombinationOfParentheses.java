package google.arrays;

import java.util.*;

/**
 * ValidCombinationOfParentheses.java
 * 
 * Description: Implement an algorithm to print all valid (i.e., properly opened
 * and closed) combinations of n-pairs of parentheses.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 27, 2014
 */

public class ValidCombinationOfParentheses {

	private static int calledTimes = 0;
	
	/**
	 * n = 3	((( + )))
	 * 
	 * if right < left
	 * 		1. + (
	 * 		2. + )
	 * if right = left
	 * 		   + (
	 * if right > left
	 * 		invalid! 
	 * 
	 * */
	public static List<String> parentheses(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0) return result;
		parenthesesHelper(0, 0, n, new Stack<Integer>(), result);
		return result;
	}
	private static void parenthesesHelper(int left, int right, int n, Stack<Integer> stack, List<String> result) {
		if (right == n) {
			stackToString(stack, result);
			return;
		}
		
		if (left < n) {
			stack.push((int)'(');
			parenthesesHelper(left + 1, right, n, stack, result);
			stack.pop();
		}
		
		if (right < left) {
			stack.push((int)')');
			parenthesesHelper(left, right + 1, n, stack, result);
			stack.pop();
		}
	}
	private static void stackToString(Stack<Integer> stack, List<String> result) {
		List<Integer> list = new ArrayList<Integer>(stack);
		StringBuilder sb = new StringBuilder();
		for (int v : list) {
			calledTimes++;
			sb.append((char)v);
		}
		result.add(sb.toString());
	}
	
	public static void main(String[] args) {
		int n = 3;
		List<String> result = parentheses(n);
		System.out.println("Size: " + result.size() + " calledTimes: " + calledTimes + "\n");
		for (String s : result) {
			System.out.print(s + " ");
		}
	}
}
