package mitHackingAGoogleInterview;

public class MaximalSubarray {

	/**
	 * Given an array, describe an algorithm to identify the subarray with the
	 * maximum sum. For example, if the input is [1, -3, 5, -2, 9, -5, 6, -4],
	 * the output would be: 
	 * 
	 * max sum: 13, [5, -2, 9, -5, 6]
	 * 
	 * */
	
	public static void maximumSubarray(int[] vs) {
		int cur_sum = vs[0], max_sum = vs[0], min = vs[0], max_sum_index = 0, length = 0;
		for (int i = 1, j = 0; i < vs.length; i++, j++) {
			int next = vs[i];
			cur_sum += next;
			if (cur_sum < min) {
				min = cur_sum;
			}
			if (cur_sum - min > max_sum) {
				max_sum = cur_sum - min;
				max_sum_index = i;
				length = j;
			}
		}
		System.out.printf("max sum: %d, [", max_sum);
		length = max_sum_index - length + 1; // 1 2 3 4
		while (length < max_sum_index) {
			System.out.printf("%d, ", vs[length++]);
		}
		System.out.printf("%d]", vs[length]);
		System.out.println();
	}

	public static void main(String[] args) {
		int [] vs = {1, -3, 5, -2, 9, -5, 6, -4};
		maximumSubarray(vs);
	}
}
