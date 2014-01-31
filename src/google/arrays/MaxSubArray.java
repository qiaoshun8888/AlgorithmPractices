package google.arrays;

/**
 * MaxSubArray.java
 * 
 * Description: Find the contiguous subarray within an array (containing at
 * least one number) which has the largest sum.
 * 
 * For example, 
 * 
 * given the array [−2,1,−3,4,−1,2,1,−5,4], 
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 30, 2014
 */

public class MaxSubArray {

	public static int maxSubArray(int [] vs) {
		if (vs == null || vs.length == 0) return 0;
		
		int maxSum = Integer.MIN_VALUE, sum = 0;
		
		for (int i = 0; i < vs.length; i++) {
			sum = sum > 0 ? vs[i] + sum : vs[i];
			maxSum = Math.max(sum, maxSum);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 2, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(vs));
	}
}
