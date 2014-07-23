package other_practices2.array;

public class SingleNumber {

	/*
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */

	public int singleNumber(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int result = 0;
		for (int v : A)
			result ^= v;
		return result;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3, 4, 3, 1, 4 };
		SingleNumber o = new SingleNumber();
		System.out.println(o.singleNumber(vs));
	}
}
