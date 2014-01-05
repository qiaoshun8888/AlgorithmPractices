package leetcode;

import java.util.*;

public class ParenthesesPermutation {

	/**
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 * 
	 * */

	public int calledTimes = 0;

	public ArrayList<String> generateParenthesis(int n) {
		if (n <= 0)
			return new ArrayList<String>();

		// Method - 1
		// return helper(n, 0, 0, new StringBuilder());

		// Method - 2
		ArrayList<String> result = new ArrayList<String>();
		char[] c = new char[n * 2];
		generateHelper(n, n, c, 0, result);
		return result;
	}

	// Method - 1
	private ArrayList<String> helper(int n, int l, int r, StringBuilder sb) {
		calledTimes++;
		ArrayList<String> list = new ArrayList<String>();

		if (l > n || r > n) {
			return list;
		}

		if (r == n) {
			list.add(sb.toString());
			return list;
		}

		if (l < n) {
			StringBuilder newSb = new StringBuilder(sb);
			newSb.append("(");
			list.addAll(helper(n, l + 1, r, newSb));
		}

		if (r < l) {
			StringBuilder newSb = new StringBuilder(sb);
			newSb.append(")");
			list.addAll(helper(n, l, r + 1, newSb));
		}

		return list;
	}

	// Method - 2
	private void generateHelper(int leftRemain, int rightRemain, char[] c,
			int index, ArrayList<String> result) {
		calledTimes++;
		if (index == c.length) {
			result.add(new String(c));
			return;
		}

		if (leftRemain <= rightRemain) {
			if (leftRemain > 0) {
				c[index] = '(';
				generateHelper(leftRemain - 1, rightRemain, c, index + 1,
						result);
			}
		}
		if (leftRemain < rightRemain) {
			c[index] = ')';
			generateHelper(leftRemain, rightRemain - 1, c, index + 1, result);
		}
	}

	public static void main(String[] args) {
		ParenthesesPermutation o = new ParenthesesPermutation();
		ArrayList<String> list = o.generateParenthesis(1);
		System.out.println("Permutation size is: " + list.size()
				+ "  calledTimes: " + o.calledTimes);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
