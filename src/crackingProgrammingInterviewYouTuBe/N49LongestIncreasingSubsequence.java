package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class N49LongestIncreasingSubsequence {

	/**
	 * Print Longest Increasing Subsequence (LIS)
	 * 
	 * e.g.
	 * 
	 * {2, 6, 4, 5, 1, 3}
	 * 
	 * the LIS = {2, 4, 5}
	 * 
	 * */
	
	private static int calledTimes = 0;
	
	public static void LIS(int [] vs) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		path.add(vs[0]);
		
		for (int i = 1; i < vs.length; i++) {
			path = new ArrayList<Integer>();
			paths.add(path);
			for (int j = 0; j <= i; j++) {
				if (vs[i] >= vs[j]) {
					calledTimes++;
					if (path.size() == 0) {
						path.add(vs[j]);
					}
					else if (path.size() > 0 && vs[j] > path.get(path.size() - 1)) {
						path.add(vs[j]);						
					}
				}
			}
		}
		
		// Find the longest path in paths
		List<Integer> longestPath = null;		
		Iterator<List<Integer>> it = paths.iterator();
		while (it.hasNext()) {
			path = it.next();
			if (longestPath == null) {
				longestPath = path;
			}
			else {
				if (path.size() > longestPath.size()) {
					longestPath = path;
				}
			}
		}
		
		// Print the path
		for (int v : longestPath) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println("calledTimes: " + calledTimes);
	}
	
	public static void main(String [] args) {
		int [] vs = {2, 6, 4, 5, 1, 3};
		LIS(vs);
	}
}
