package other_practices2.dp;

public class MaximumSubarray {

	/**
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

		For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
		the contiguous subarray [4,−1,2,1] has the largest sum = 6.

		click to show more practice.

		More practice:
		If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
	 */

	public int maxSubArray(int[] A) {
		int max = A[0], sum = max;
		for (int i = 1; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			max = Math.max(sum, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] vs = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray o = new MaximumSubarray();
		System.out.println(o.maxSubArray(vs));
	}
}
