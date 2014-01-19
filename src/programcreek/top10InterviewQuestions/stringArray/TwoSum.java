package programcreek.top10InterviewQuestions.stringArray;

public class TwoSum {

	/**
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
	 * 
	 * */

	public int[] twoSum(int[] numbers, int target) {
		int [] two = new int[2];
		
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] <= target) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[i] + numbers[j] == target) {
						two[0] = i + 1;
						two[1] = j + 1;
					}
				}
			}
		}
		
		return two;
	}
	
	public static void main(String[] args) {
		int [] numbers = {3,2,4};
		int target = 6;
		
		TwoSum o = new TwoSum();
		int [] result = o.twoSum(numbers, target);
		System.out.println("[" + result[0] + "]" + "[" + result[1] + "]");
	}
}
