package other_practices2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {

	/*
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is
	 * not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 */

	// Time complexity: O(2^n) (read: "2-to-the-n")
	public List<Integer> grayCode(int n) {
		List<Integer> result = Arrays.asList(0);
		for (int i = 0; i < n; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int v : result) {
				v |= 0 << i;
				tmp.add(v);
			}
			for (int j = result.size() - 1; j >= 0; j--) {
				int v = result.get(j);
				v |= 1 << i;
				tmp.add(v);
			}
			result = tmp;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 2;
		GrayCode o = new GrayCode();
		for (int v : o.grayCode(n)) {
			System.out.println(v);
		}
	}

}
