package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_SizeKSubsets {

	/**
	 * Print all size k subsets of a given set
	 * 
	 * e.g.
	 * 
	 * 		{1, 2, 3, 4}	k = 2
	 * 
	 * 		{1, 2} {1, 3} {1, 4} {2, 3} {2, 4} {3, 4}
	 * 
	 * */
	public static List<List<Integer>> subsets(int [] vs, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (vs == null || k <= 0 || k > vs.length) return result;
		boolean [] used = new boolean[vs.length];
		subsetsHelper(vs, used, 0, 0, k, result);
		return result;
	}
	private static void subsetsHelper(int [] vs, boolean [] used, int startIndex, int size, int k, List<List<Integer>> result) {
		if (size == k) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < used.length; i++) {
				if (used[i]) list.add(vs[i]);
			}
			result.add(list);
			return;
		}
		
		if (startIndex == vs.length) return;
		
		used[startIndex] = true;
		subsetsHelper(vs, used, startIndex + 1, size + 1, k, result);
		
		used[startIndex] = false;
		subsetsHelper(vs, used, startIndex + 1, size, k, result);
	}
	
	public static void main(String [] args) {
		int [] vs = {1, 2, 3, 4};
		int k = 2;
		List<List<Integer>> result = subsets(vs, k);
		
		for (List<Integer> list : result) {
			for (int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
