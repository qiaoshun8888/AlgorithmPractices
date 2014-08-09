package other_practices2.bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

	/**
	 * Given a set of distinct integers, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,3], a solution is:

		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
	 */

	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (S == null) return results;
		boolean[] b = new boolean[S.length];
		helper(b, S, 0, results);
		return results;
	}

	private void helper(boolean[] b, int[] vs, int index, List<List<Integer>> results) {
		if (index == b.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < vs.length; i++) {
				if (b[i]) list.add(vs[i]);
			}
			Collections.sort(list);
			results.add(list);
			return;
		}
		b[index] = true;
		helper(b, vs, index + 1, results);
		b[index] = false;
		helper(b, vs, index + 1, results);
	}

	public static void main(String[] args) {
		int[] vs = {1,2,3};
		Subsets o = new Subsets();
		List<List<Integer>> results = o.subsets(vs);
		for (List<Integer> result : results) {
			System.out.println(result);
		}
	}
}
