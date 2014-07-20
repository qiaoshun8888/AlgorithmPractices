package other_practices2.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	/*
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */

	public int longestConsecutive(int[] num) {
		int longest = 0;
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int n : num)
			map.put(n, false);
		for (int n : num) {
			if (map.get(n))
				continue;
			int length = 1;
			// left
			for (int i = n - 1; map.containsKey(i); i--) {
				map.put(i, true);
				length++;
			}
			// right
			for (int i = n + 1; map.containsKey(i); i++) {
				map.put(i, true);
				length++;
			}
			longest = Math.max(longest, length);
		}
		return longest;
	}

	public static void main(String[] args) {
		int[] num = { 100, 4, 200, 2, 1, 3 };
		LongestConsecutiveSequence o = new LongestConsecutiveSequence();
		System.out.println(o.longestConsecutive(num));
	}
}
