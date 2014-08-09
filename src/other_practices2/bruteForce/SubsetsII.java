package other_practices2.bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

	/**
	 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

		Note:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		For example,
		If S = [1,2,2], a solution is:

		[
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]
	 */

	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (num == null) return results;
		boolean[] b = new boolean[num.length];
		Set<List<Integer>> sets = new HashSet<List<Integer>>();
		helper(b, num, 0, sets);
		results = new ArrayList<List<Integer>>(sets);
		return results;
	}

	private void helper(boolean[] b, int[] vs, int index, Set<List<Integer>> sets) {
		if (index == b.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < b.length; i++) {
				if (b[i]) list.add(vs[i]);
			}
			Collections.sort(list);
			sets.add(list);
			return;
		}
		b[index] = true;
		helper(b, vs, index + 1, sets);
		b[index] = false;
		helper(b, vs, index + 1, sets);
	}

	public static void main(String[] args) {
		int[] vs = {1,2,2};
		SubsetsII o = new SubsetsII();
		List<List<Integer>> results = o.subsetsWithDup(vs);
		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}
}
