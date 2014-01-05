package leetcode;

import java.util.*;

public class Permutation {

	/**
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: 
	 * 
	 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * 
	 * */

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null)
			return result;
		Stack<Integer> stack = new Stack<Integer>();
		permutation(num, 0, stack, result);
		return result;
	}

	private void permutation(int[] vs, int start, Stack<Integer> stack,
			ArrayList<ArrayList<Integer>> result) {
		// base case
		if (start == vs.length) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}

		for (int i = 0; i < vs.length - start; i++) {
			swap(vs, start, start + i);
			stack.push(vs[start]);
			permutation(vs, start + 1, stack, result);
			stack.pop();
			swap(vs, start, start + i);
		}
	}

	private void swap(int[] vs, int i, int j) {
		if (i != j) {
			vs[i] ^= vs[j];
			vs[j] ^= vs[i];
			vs[i] ^= vs[j];
		}
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3 };
		Permutation o = new Permutation();
		ArrayList<ArrayList<Integer>> result = o.permute(vs);

		System.out.println("size is: " + result.size() + " \n");

		for (ArrayList<Integer> list : result) {
			for (int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
