package leetcode;

public class RomanToInteger {

	/**
	 * 
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * 4 IV 3 IIV 6 VI
	 * 
	 * 123 CXXIII 1139 MCXXXIX
	 */
	public int romanToInt(String s) {
		char[] value = new char[255];
		value['I'] = 1;
		value['V'] = 5;
		value['X'] = 10;
		value['L'] = 50;
		value['C'] = 100;
		value['D'] = 500;
		value['M'] = 1000;

		char[] cc = s.toCharArray();
		int sum = value[cc[cc.length - 1]];

		for (int i = cc.length - 1; i > 0; i--) {
			if (value[cc[i]] <= value[cc[i - 1]]) {
				sum += value[cc[i - 1]];
			} else {
				sum -= value[cc[i - 1]];
			}
		}

		return sum;
	}
}
