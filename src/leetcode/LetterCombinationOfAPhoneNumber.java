package leetcode;

import java.util.*;

/**
 * LetterCombinationOfAPhoneNumber.java
 * 
 * Description: Given a digit string, return all possible letter combinations
 * that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 30, 2014
 */

public class LetterCombinationOfAPhoneNumber {

	char[][] charMap = { {}, {}, 
			{ 'a', 'b', 'c' }, // 2
			{ 'd', 'e', 'f' }, // 3
			{ 'g', 'h', 'i' }, // 4
			{ 'j', 'k', 'l' }, // 5
			{ 'm', 'n', 'o' }, // 6
			{ 'p', 'q', 'r', 's' }, // 7
			{ 't', 'u', 'v' }, // 8
			{ 'w', 'x', 'y', 'z' }, // 9
	};

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
		    result.add(new String());
			return result;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int[] vs = new int[digits.length()];
		char[] cc = digits.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			vs[i] = Integer.parseInt(String.valueOf(cc[i]));
		}

		DFS(vs, 0, stack, result);

		return result;
	}

	private void DFS(int[] vs, int depth, Stack<Integer> stack,
			ArrayList<String> result) {
		if (stack.size() == vs.length) {
			List<Integer> list = new ArrayList<Integer>(stack);
			StringBuilder sb = new StringBuilder();
			for (int v : list) {
				sb.append((char) v);
			}
			result.add(sb.toString());
			return;
		}

		// {2, 3}
		for (int j = 0; j < charMap[vs[depth]].length; j++) {
			char c = charMap[vs[depth]][j];
			stack.push((int) c);
			DFS(vs, depth + 1, stack, result);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		LetterCombinationOfAPhoneNumber o = new LetterCombinationOfAPhoneNumber();
		ArrayList<String> result = o.letterCombinations("23");
		for (String s : result) {
			System.out.print(s + " ");
		}
	}
}
