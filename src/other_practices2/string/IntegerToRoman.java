package other_practices2.string;

public class IntegerToRoman {

	/*
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */

	public String intToRoman(int num) {
		int[] radix = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; num > 0; i++) {
			int count = num / radix[i];
			num %= radix[i];
			while (count-- > 0) {
				sb.append(symbol[i]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int num = 0;
		IntegerToRoman o = new IntegerToRoman();
		System.out.println(o.intToRoman(num));
	}
}
