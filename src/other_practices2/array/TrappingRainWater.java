package other_practices2.array;

public class TrappingRainWater {

	/*
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 */

	/*
	 * An O(n) solution is to consider each bar at a time, we can see that, for
	 * each bar, the water itself can trap depends on the max height on its left
	 * and right.
	 * 
	 * e.g. if current bar is of height 2, the max height on its left is 4, max
	 * height on its right is 3, then water can be trapped in this bar is
	 * min(4,3)-2 = 1.
	 */
	public int trap(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int result = 0;
		int[] left = new int[A.length], right = new int[A.length];
		left[0] = A[0];
		int highest = A[0];
		for (int i = 1; i < A.length; i++) {
			left[i] = highest;
			highest = Math.max(A[i], highest);
		}
		highest = A[A.length - 1];
		right[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			right[i] = highest;
			highest = Math.max(A[i], highest);
			// calculate the water
			if (A[i] < left[i] && A[i] < right[i]) {
				result += Math.min(left[i], right[i]) - A[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] vs = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater o = new TrappingRainWater();
		System.out.println(o.trap(vs));
	}
}
