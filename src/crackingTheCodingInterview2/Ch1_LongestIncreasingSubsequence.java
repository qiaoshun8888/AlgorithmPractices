package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_LongestIncreasingSubsequence {

	/**
	 * Find the longest subsequence of a given sequence
	 * 
	 * e.g.
	 * 		{9, 6, 2, 4, 5, 1, 3, 3, 7, 8}
	 * 
	 * LIS: {4, 5, 7, 8}
	 * 
	 * */
	
	public static List<Integer> LIS(int [] vs) {
		List<Integer> result = new ArrayList<Integer>();
		if (vs == null) return result;
		
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		
		path.add(vs[0]);
		paths.add(path);
		
		for (int i = 1; i < vs.length; i++) {
			path = new ArrayList<Integer>();
			paths.add(path);
			for (int j = 0; j < i; j++) {
				if (vs[i] > vs[j] && path.size() <= paths.get(j).size()) {
					path.clear();
					path.addAll(paths.get(j));
					path.add(vs[i]);
				}
			}
		}
		
		for (List<Integer> list : paths) {
			if (list.size() > result.size()) result = list;
		}
		
		return result;
	}
	
	public static void main(String [] args) {
		int [] vs = {9, 6, 2, 4, 5, 1, 3, 3, 7, 8};
		List<Integer> result = LIS(vs);
		
		for (int v : result) {
			System.out.print(v + " ");
		}
		System.out.println();
	}
}
