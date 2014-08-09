package other_practices2.bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Combinations {

	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

		For example,
		If n = 4 and k = 2, a solution is:

		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
	 */

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (n <= 0) return results;
		Stack<Integer> s = new Stack<Integer>();
		Set<List<Integer>> sets = new HashSet<List<Integer>>();
		helper(n, k, 1, s, sets);
		results = new ArrayList<List<Integer>>(sets);
		return results;
	}

	private void helper(int n, int k, int cur, Stack<Integer> s, Set<List<Integer>> sets) {
		if (s.size() == k) {
			List<Integer> list = new ArrayList<Integer>(s);
			Collections.sort(list);
			sets.add(list);
			return;
		}
		for (int i = cur; i <= n; i++) {
			s.push(i);
			helper(n, k, i + 1, s, sets);
			s.pop();
		}
	}

	public static void main(String[] args) {
		Combinations o = new Combinations();
		List<List<Integer>> results = o.combine(4, 2);
		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}
}
