package other_practices2.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/*
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 */

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				int index = map.get(target - numbers[i]) + 1 ;
				return new int[] { Math.min(i + 1, index),
						Math.max(i + 1, index) };
			} else {
				map.put(numbers[i], i);
			}
		}
		return null;
	}

	// leetcode doesn't accept ordered answer.
	public int[] twoSum2(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			int v = numbers[i];
			int index = binarySearch(numbers, i + 1, numbers.length - 1, target
					- v);
			if (index != -1)
				return new int[] { i + 1, index + 1 };
		}
		return null;
	}

	private int binarySearch(int[] vs, int left, int right, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == vs[mid])
				return mid;
			if (target < vs[mid])
				return binarySearch(vs, left, mid - 1, target);
			else
				return binarySearch(vs, mid + 1, right, target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] vs = { 3, 2, 4 };
		int target = 6;
		TwoSum o = new TwoSum();
		int[] result = o.twoSum(vs, target);
		System.out.println("index1: " + result[0] + " index2: " + result[1]);
	}
}
