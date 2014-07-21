package other_practices2.array;

public class PlusOne {

	/*
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 */

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return null;

		int carry = 0;
		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += carry;
			if (digits[i] >= 10) {
				digits[i] -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
		}
		if (carry > 0) {
			int[] result = new int[digits.length + 1];
			result[0] = carry;
			for (int i = 1; i < digits.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] vs = { 9, 9, 9, 9 };
		PlusOne o = new PlusOne();
		vs = o.plusOne(vs);
		for (int v : vs) {
			System.out.print(v + " ");
		}
	}
}
