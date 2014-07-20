package other_practices2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a ² b ² c) The solution set must not contain duplicate triplets. For
	 * example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: (-1, 0, 1) (-1, -1, 2)
	 */
	public static int callTimes = 0;

	// exponential
	public List<List<Integer>> threeSum(int[] num) {
		if (num == null || num.length == 0)
			return new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		helper(num, 0, 1, 2, set);
		List<List<Integer>> result = new ArrayList<List<Integer>>(set);
		return result;
	}

	private void helper(int[] num, int i, int j, int k, Set<List<Integer>> set) {
		callTimes++;
		if (i == j || j == k || k == i || i == num.length || j == num.length
				|| k == num.length)
			return;
		if (num[i] + num[j] + num[k] == 0) {
			Integer[] vs = { num[i], num[j], num[k] };
			Arrays.sort(vs);
			List<Integer> list = Arrays.asList(vs);
			if (!set.contains(list))
				set.add(list);
		}
		helper(num, i + 1, j, k, set);
		helper(num, i, j + 1, k, set);
		helper(num, i, j, k + 1, set);
	}

	// O(N^2)
	public List<List<Integer>> threeSumImprove(int[] num) {
		if (num == null || num.length == 0)
			return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < num.length; i++) {
			int v = num[i];
			helperTwoSum(num, i + 1, -v, set);
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>(set);
		return result;
	}

	private void helperTwoSum(int[] vs, int startIndex, int target,
			Set<List<Integer>> set) {
		int left = startIndex, right = vs.length - 1;
		while (left < right) {
			callTimes++;
			int sum = vs[left] + vs[right];
			if (sum == target) {
				List<Integer> list = Arrays.asList(-target, vs[left], vs[right]);
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
		int[] num = { -2, 0, 1, 1, 2 };
		ThreeSum o = new ThreeSum();
		List<List<Integer>> result = o.threeSum(num);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
		System.out.println("callTimes: " + callTimes);

		callTimes = 0;
		result = o.threeSumImprove(num);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
		System.out.println("callTimes: " + callTimes);
	}
}
