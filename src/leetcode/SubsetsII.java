package leetcode;

import java.util.*;

/**
 * SubsetsII.java
 * 
 * Description: Given a collection of integers that might contain duplicates, S,
 * return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 * 
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class SubsetsII {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return result;

		boolean[] used = new boolean[num.length];

		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

		subsetsHelper(num, 0, used, set);

		return new ArrayList<ArrayList<Integer>>(set);
	}

	// 1 2 3 - {}, {1}, {2}, {3}, {1,2} ... {1,2,3}
	private void subsetsHelper(int[] vs, int start, boolean[] used,
			Set<ArrayList<Integer>> set) {
		if (start == vs.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < used.length; i++) {
				if (used[i])
					list.add(vs[i]);
			}
			Collections.sort(list);
			set.add(new ArrayList<Integer>(list));
			return;
		}

		used[start] = true;
		subsetsHelper(vs, start + 1, used, set);

		used[start] = false;
		subsetsHelper(vs, start + 1, used, set);
	}
}
