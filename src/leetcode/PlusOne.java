package leetcode;

public class PlusOne {

	/**
	 * Given a number represented as an array of digits, plus one to the number.
	 * 
	 * */
	public static int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i];
            if (i == digits.length - 1)
            	v += 1 + carry;
            else v += carry;
            if (v >= 10) {
                v -= 10;
                carry = 1;
            }
            else carry = 0;
            digits[i] = v;
        }
        if (carry == 0) return digits;
        else {
            int [] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
    }
	
	public static void main(String [] args) {
		int [] vs = {9, 9, 9};
		vs = plusOne(vs);
		for (int v : vs) {
			System.out.print(v + " ");
		}
	}
}
