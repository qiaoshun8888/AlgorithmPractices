package leetcode;

import java.util.*;

/**
 * Subsets.java
 * 
 * Description: Given a set of distinct integers, S, return all possible
 * subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] vs) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (vs == null || vs.length == 0) return result;
		
		boolean [] used = new boolean[vs.length];
		
		subsetsHelper(vs, 0, used, result);
		
		return result;
	}
	private void subsetsHelper(int [] vs, int start, boolean [] used, ArrayList<ArrayList<Integer>> result) {
		if (start == vs.length) {
			Set<Integer> set = new TreeSet<Integer>();
			for (int i = 0; i < used.length; i++) {
				if (used[i]) set.add(vs[i]);
			}
			result.add(new ArrayList<Integer>(set));
			return;
		}
		
		used[start] = true;
		subsetsHelper(vs, start + 1, used, result);
		
		used[start] = false;
		subsetsHelper(vs, start + 1, used, result);
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 3, 4};
		Subsets o = new Subsets();
		ArrayList<ArrayList<Integer>> result = o.subsets(vs);
		
		System.out.println("=== size: " + result.size() + " ===\n");
		for (ArrayList<Integer> list : result) {
			System.out.println(list);
		}
	}
}
