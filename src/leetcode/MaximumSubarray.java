package leetcode;

public class MaximumSubarray {

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous
	 * subarray [4,-1,2,1] has the largest sum = 6.
	 * 
	 * */

	public int maxSubArray(int[] A) {
		if (A.length == 0)
			return 0;
		int gMax = A[0], gMaxStart = 0, gMaxEnd = 0, sum = A[0], gMin = A[0] < 0 ? A[0]
				: 0, gMinIndex = 0;
		for (int i = 1; i < A.length; i++) {
			sum += A[i];

			if (sum - gMin > gMax) {
				gMax = sum - gMin;
				gMaxStart = gMinIndex + 1;
				gMaxEnd = i;
			}

			if (sum < 0 && sum < gMin) {
				gMin = sum;
				gMinIndex = i;
			}
		}

		while (gMaxStart <= gMaxEnd) {
			System.out.print(A[gMaxStart++] + " ");
		}
		System.out.println();
		return gMax;
	}

	public static void main(String[] args) {
		int[] vs = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray o = new MaximumSubarray();
		System.out.println(o.maxSubArray(vs));
	}
}
