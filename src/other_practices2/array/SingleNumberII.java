package other_practices2.array;

public class SingleNumberII {

	/*
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */

	public int singleNumber(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int result = 0, sign = 0;
		for (int i = 0; i < 32; i++) {
			int tmp = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] < 0) {
					sign = (sign + 1) % 3;
					A[j] *= -1;
				}
				tmp += (A[j] >> i) & 1;
			}
			tmp %= 3;
			result |= tmp << i;
		}
		return result * (sign == 0 ? 1 : -1);
	}

	public static void main(String[] args) {
		int[] vs = { 1, 1, 1, 2 };
		// int[] vs = { -2, -2, 1, 1, -3, 1, -3, -3, -4, -2 };
		SingleNumberII o = new SingleNumberII();
		System.out.println(o.singleNumber(vs));
	}
}
