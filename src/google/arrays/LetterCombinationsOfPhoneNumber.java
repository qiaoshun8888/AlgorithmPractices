package google.arrays;

import java.util.*;

/**
 *	LetterCombinationsOfPhoneNumber.java
 *
 *	Description: Given a digit string, return all possible letter combinations that the number could represent.
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 30, 2014
 */

public class LetterCombinationsOfPhoneNumber {

	static final char[][] charMap = { {}, {}, 
			{ 'a', 'b', 'c' }, // 2
			{ 'd', 'e', 'f' }, // 3
			{ 'g', 'h', 'i' }, // 4
			{ 'j', 'k', 'l' }, // 5
			{ 'm', 'n', 'o' }, // 6
			{ 'p', 'q', 'r', 's' }, // 7
			{ 't', 'u', 'v' }, // 8
			{ 'w', 'x', 'y', 'z' }, // 9
	};
	
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) return result;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		char [] cc = digits.toCharArray();
		int [] vs = new int[cc.length];
		for (int i = 0; i < cc.length; i++) {
			vs[i] = Integer.parseInt(String.valueOf(cc[i]));
		}
		
		DFS(vs, 0, stack, result);
		
		return result;
	}
	
	private static void DFS(int [] vs, int depth, Stack<Integer> stack, ArrayList<String> result) {
		if (depth == vs.length) {
			List<Integer> list = new ArrayList<Integer>(stack);
			StringBuilder sb = new StringBuilder();
			for (int v : list) {
				sb.append((char)v);
			}
			result.add(sb.toString());
			return;
		}
		
		char [] cc = charMap[vs[depth]];
		
		for (int i = 0; i < cc.length; i++) {
			stack.push((int)cc[i]);
			DFS(vs, depth + 1, stack, result);
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> result = letterCombinations("23");
		for (String s : result) {
			System.out.print(s + " ");
		}
	}
}
