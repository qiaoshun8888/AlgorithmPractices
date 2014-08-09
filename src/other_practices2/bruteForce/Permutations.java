package other_practices2.bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {

	/**
	 * Given a collection of numbers, return all possible permutations.

		For example,
		[1,2,3] have the following permutations:
		[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */

	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (num == null) return results;
		Stack<Integer> s = new Stack<Integer>();
		helper(num, 0, s, results);
		return results;
	}

	public void helper(int[] vs, int start, Stack<Integer> s, List<List<Integer>> results) {
		if (start == vs.length) {
			List<Integer> list = new ArrayList<Integer>(s);
			results.add(list);
			return;
		}

		for (int i = 0; i < vs.length - start; i++) {
			swap(vs, start, start + i);
			s.push(vs[start]);
			helper(vs, start + 1, s, results);
			s.pop();
			swap(vs, start, start + i);
		}
	}

	private void swap(int[] vs, int a, int b) {
		if (a != b) {
			vs[a] ^= vs[b];
			vs[b] ^= vs[a];
			vs[a] ^= vs[b];
		}
	}

	public static void main(String[] args) {
		int[] vs = {1, 2, 3};
		Permutations o = new Permutations();
		List<List<Integer>> results = o.permute(vs);
		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}
}
