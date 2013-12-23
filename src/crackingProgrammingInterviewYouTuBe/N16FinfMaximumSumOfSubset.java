package crackingProgrammingInterviewYouTuBe;

public class N16FinfMaximumSumOfSubset {

	/**
	 * Find the maximum sum of a subset in an array in O(N) time.
	 * 
	 * */
	
	/**
	 * {-2, 4, 7, 9, -5, 1, 10, -2, 15, -8}
	 * 
	 * */
	public static void find(int [] vs) {
		int cur_sum = 0, max_sum = Integer.MIN_VALUE, max_start_index = -1, max_count = 0;
		int start_index = -1, count = 0;
		for (int i = 0; i < vs.length; i++) {
			if (vs[i] + cur_sum >= cur_sum) {
				if (count == 0) {
					start_index = i;
				}
				cur_sum += vs[i];
				count++;
				if (cur_sum > max_sum) {
					max_sum = cur_sum;
					max_start_index = start_index;
					max_count = count;
				}
			}
			else {
				count = 0;
				cur_sum = 0;
			}
		}
		
		System.out.println("max value (" + max_sum + ") from [" + max_start_index + "] to [" + (max_start_index + max_count - 1) + "].");
	}
	
	public static void main(String [] args) {
		int [] vs = {-2, 4, 7, 9, -5, 1, 10, -2, 15, 7, -8};
		find(vs);
	}
}
