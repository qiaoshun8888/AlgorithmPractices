package other_practices2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	/*
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
	 * (ie, a ² b ² c ² d) The solution set must not contain duplicate
	 * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target =
	 * 0.
	 * 
	 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
	 */

	public static int callTimes = 0;

	// Method1: fourSum -> threeSum -> twoSum
	public List<List<Integer>> fourSum(int[] num, int target) {
		if (num == null || num.length == 0)
			return new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int v = num[i];
			List<Integer> list = new ArrayList<Integer>();
			list.add(v);
			threeSum(num, i + 1, list, target - v, set);
		}
		return new ArrayList<List<Integer>>(set);
	}

	private void threeSum(int[] num, int start, List<Integer> l,
			int target, Set<List<Integer>> set) {
		for (int i = start; i < num.length; i++) {
			int v = num[i];
			List<Integer> list = new ArrayList<Integer>(l);
			list.add(v);
			twoSum(num, i + 1, list, target - v, set);
		}
	}

	private void twoSum(int[] num, int startIndex, List<Integer> l, int target,
			Set<List<Integer>> set) {
		int left = startIndex, right = num.length - 1;
		while (left < right) {
			int sum = num[left] + num[right];
			if (sum == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.addAll(Arrays.asList(num[left], num[right]));
				list.addAll(l);
				Collections.sort(list);
				if (!set.contains(list)) {
					set.add(list);
				}
				left++;
				right--;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	public static void main(String[] args) {
		int[] vs = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		FourSum o = new FourSum();
		List<List<Integer>> result = o.fourSum(vs, target);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
		System.out.println("callTimes: " + callTimes);
	}
}
