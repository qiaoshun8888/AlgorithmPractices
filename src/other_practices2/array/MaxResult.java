package other_practices2.array;

public class MaxResult {

	/*
	 * Given an array, using + - * / to calculate the maximum result.
	 */

	public int maxResult(int[] vs) {
		/*
		 * 3  5  -12  7  9  2
		 * 3  5  -12  7  9  -100
		 * 
		 * -1  -1  -1  1  1  -1  1  -1
		 * 
		 * (3  5  -7  9)  0  (3  7  9)  0  (5)
		 * 
		 * even negative numbers: -2  2  4  -10  seems max is always multiple
		 * but!  -1  1  1  1  1  1  1 -1  counter example
		 * 
		 * -10  3  5  (-12  7  9  -100)
		 * */
		return -1;
	}
}
