package epi;

/**
 * 
 * ClassName: Ch501
 * 
 * Description: How would you go about computing the parity of a very large
 * number of 64-bit nonegative integer.
 * 
 * Date: Jun 24, 2014 10:42:23 PM
 * 
 * @author johnqiao
 * @version
 */
public class Ch501 {

	/**
	 * Complexity: O(n)
	 * 
	 * @param v
	 * @return
	 */
	public static short compute(long v) {
		short i = 0;
		do {
			i = (short) ((v & 1) == 1 ? 1 - i : i);
		} while ((v >>= 1) != 0);
		return i;
	}

	/**
	 * Complexity: O(k)
	 * 
	 * @param v
	 * @return
	 */
	public static short compute2(long v) {
		short i = 0;
		while (v != 0) {
			v &= (v - 1); // erases the lowest set bit of v
			i ^= 1;
		}
		return i;
	}

	public static void main(String[] args) {
		long[] test_cases = { 1, 2, 3, 4, 5, 6, 7 };
		for (long test : test_cases) {
			System.out.println(test + ": " + compute(test));
		}

		System.out.println("==============\n");

		for (long test : test_cases) {
			System.out.println(test + ": " + compute2(test));
		}
	}
}
