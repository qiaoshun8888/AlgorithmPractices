package leetcode;

import java.util.*;

public class GrayCode {

	/**
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 * 
	 * Note: For a given n, a gray code sequence is not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 * 
	 * */

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		if (n == 0)
			return list;

		int val = 1;
		boolean b = true;
		list.add(1);
		if (n == 1)
			return list;

		while (true) {
			// 改变右起第一个为1的位元的左边位元
			if (b) {
				int i = val, j = 0;
				while ((i & 1) == 0) {
					i >>= 1;
					j++;
				}
				if (j + 1 >= n)
					break;
				i = 1 << (j + 1);
				// 1 -> 0
				if ((val & i) > 0) {
					val &= ~i;
				}
				// 0 -> 1
				else {
					val |= i;
				}
			}
			// 改变最右边的位元
			else {
				// 1 -> 0
				if ((val & 1) > 0) {
					val &= ~1;
				}
				// 0 -> 1
				else {
					val |= 1;
				}
			}
			list.add(val);
			b = !b;
		}

		return list;
	}

	public static void main(String[] args) {
		GrayCode o = new GrayCode();
		ArrayList<Integer> list = o.grayCode(3);
		for (int i : list) {
			System.out.println(Integer.toBinaryString(i));
		}
	}
}
