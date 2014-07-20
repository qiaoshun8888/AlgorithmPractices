package other_practices2.array;

import java.util.Arrays;

public class ThreeSumClosest {

	/*
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int result = 0;
		int gap = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			int left = i + 1, right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == target)
					return target;
				int gap_tmp = Math.abs(sum - target);
				if (gap_tmp < gap) {
					gap = gap_tmp;
					result = sum;
				}
				if (sum > target)
					right--;
				else
					left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] vs = { -3, -2, -5, 3, -4 };
		int target = -1;
		ThreeSumClosest o = new ThreeSumClosest();
		System.out.println(o.threeSumClosest(vs, target));
	}
}
