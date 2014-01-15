package leetcode;

import java.util.*;

public class Combinations {

	/**
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * 
	 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
	 * */

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n == 0 || k == 0)
			return result;

		int[] vs = new int[n];
		for (int i = 1; i <= n; i++) {
			vs[i - 1] = i;
		}

		boolean[] used = new boolean[n];
		combinate(vs, used, 0, 0, k, result);
		
		return result;
	}

	private static void combinate(int[] vs, boolean[] used, int start, int size,
			int k, ArrayList<ArrayList<Integer>> result) {
		// Base case
		if (size == k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < vs.length; i++) {
				if (used[i])
					list.add(vs[i]);
			}
			result.add(list);
			return;
		}

		if (start == vs.length)
			return;

		// we can use this element
		used[start] = true;
		combinate(vs, used, start + 1, size + 1, k, result);

		// or not to use it
		used[start] = false;
		combinate(vs, used, start + 1, size, k, result);
	}
	
	public static void main(String [] args) {
		int n = 4, k = 3;
		ArrayList<ArrayList<Integer>> result = combine(n, k);
		for (ArrayList<Integer> list : result) {
			for (int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
