package leetcode;

public class SingleNumberII {

	/**
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 * 
	 * */

	/**
	 * 
	 * 2, 2, 2, 4,
	 * 
	 * 2 - 010 
	 * 4 - 100
	 * 
	 * 1st bit: 0 + 0 + 0 + 0 = 0 % 3 = 0 
	 * 2nd bit: 1 + 1 + 1 + 0 = 3 % 3 = 0 
	 * 3nd bit: 0 + 0 + 0 + 1 = 1 % 3 = 1
	 * 
	 * 100 = 4
	 * 
	 * */
	public int singleNumber(int[] A) {
		int num = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			int sum = 0;
			for (int v : A) {
				sum += ((v & (1 << i)) > 0) ? 1 : 0;
			}
			sum %= 3;
			if (sum == 1)
				num |= (1 << i);
		}
		return num;
	}

	public static void main(String[] args) {
		SingleNumberII o = new SingleNumberII();
		int[] vs = { 3, 3, 4, 3, 5, 5, 5 };
		System.out.println(o.singleNumber(vs));
	}
}
