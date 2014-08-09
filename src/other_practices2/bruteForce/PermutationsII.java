package other_practices2.bruteForce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PermutationsII {

	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

		For example,
		[1,1,2] have the following unique permutations:
		[1,1,2], [1,2,1], and [2,1,1].
	 */

	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (num == null) return results;
		Stack<Integer> s = new Stack<Integer>();
		Set<List<Integer>> sets = new HashSet<List<Integer>>();
		helper(num, 0, s, sets);
		results = new ArrayList<List<Integer>>(sets);
		return results;
	}

	private void helper(int[] vs, int start, Stack<Integer> s, Set<List<Integer>> sets) {
		if (start == vs.length) {
			List<Integer> list = new ArrayList<Integer>(s);
			sets.add(list);
			return;
		}
		for (int i = 0; i < vs.length - start; i++) {
			swap(vs, start, start + i);
			s.push(vs[start]);
			helper(vs, start + 1, s, sets);
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
		int[] vs = {1,1,2};
		PermutationsII o = new PermutationsII();
		List<List<Integer>> results = o.permuteUnique(vs);
		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}
}
