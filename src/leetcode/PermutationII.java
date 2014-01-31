package leetcode;

import java.util.*;

/**
 * PermutationII.java
 * 
 * Description: Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class PermutationII {

	private int calledTimes = 0;

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return result;

		ArrayList<Integer> temp = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];

		Arrays.sort(num);

		permutationUniqueHelper(num, 0, temp, visited, result);

		return result;
	}

	private void permutationUniqueHelper(int[] vs, int step,
			ArrayList<Integer> temp, boolean[] visited,
			ArrayList<ArrayList<Integer>> result) {
		calledTimes++;
		if (step == vs.length) {
			ArrayList<Integer> list = new ArrayList<Integer>(temp);
			result.add(list);
			return;
		}

		for (int i = 0; i < vs.length; i++) {
			if (i > 0 && vs[i] == vs[i - 1] && !visited[i - 1])
				continue;
			if (!visited[i]) {
				temp.add(vs[i]);
				visited[i] = true;
				permutationUniqueHelper(vs, step + 1, temp, visited, result);
				visited[i] = false;
				temp.remove(step);
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 2, 2, 1, 1 };// {1,1,2};
		long costTime = System.currentTimeMillis();
		PermutationII o = new PermutationII();
		ArrayList<ArrayList<Integer>> result = o.permuteUnique(num);
		costTime = System.currentTimeMillis() - costTime;
		System.out.println("=== size: " + result.size() + " calledTimes: "
				+ o.calledTimes + " costTime: " + costTime + " ===");
		for (ArrayList<Integer> list : result) {
			System.out.println(list);
		}
	}
}
