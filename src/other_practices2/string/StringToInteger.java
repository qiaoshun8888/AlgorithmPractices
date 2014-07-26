package other_practices2.string;

public class StringToInteger {

	/*
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 * 
	 * spoilers alert... click to show requirements for atoi.
	 * 
	 * Requirements for atoi: The function first discards as many whitespace
	 * characters as necessary until the first non-whitespace character is
	 * found. Then, starting from this character, takes an optional initial plus
	 * or minus sign followed by as many numerical digits as possible, and
	 * interprets them as a numerical value.
	 * 
	 * The string can contain additional characters after those that form the
	 * integral number, which are ignored and have no effect on the behavior of
	 * this function.
	 * 
	 * If the first sequence of non-whitespace characters in str is not a valid
	 * integral number, or if no such sequence exists because either str is
	 * empty or it contains only whitespace characters, no conversion is
	 * performed.
	 * 
	 * If no valid conversion could be performed, a zero value is returned. If
	 * the correct value is out of the range of representable values, INT_MAX
	 * (2147483647) or INT_MIN (-2147483648) is returned.
	 */

	public int atoi(String str) {
		if (str == null || str.length() == 0) return 0;
		char[] cc = str.toCharArray();
		char signal = '/'; // '+', '-', '/'
		int j = -1, k = -1; // start and end indexes of the string.
		boolean whitespace = false;
		for (int i = 0; i < cc.length; i++) {
			if (cc[i] == ' ' && j == -1 && signal == '/') {
				whitespace = true;
				continue;
			}
			if (cc[i] == '+' || cc[i] == '-') {
				if (j != -1) {
					k = i;
					break;
				}
				if (signal != '/')
					return 0;
				signal = cc[i];
				j = -1;
			} else if (cc[i] >= '0' && cc[i] <= '9') {
				j = j == -1 ? i : j;
				k = i + 1;
			} else {
				if (j != -1) {
					k = i;
					break;
				}
				return 0;
			}
		}
		if (j == -1 && k == -1)
			return 0;
		String str_num = str.substring(j, k);
		int signal_i = signal == '/' || signal == '+' ? 1 : -1;
		long result_l = Long.parseLong(str_num) * signal_i;
		return result_l > Integer.MAX_VALUE ? Integer.MAX_VALUE
				: (result_l < Integer.MIN_VALUE ? Integer.MIN_VALUE
						: (int) result_l);
	}

	public static void main(String[] args) {
		// String str = "ejw we ww -200 weu";
		String[] strs = { "  -0012a42", "a", "", "     -200 weu", "2",
				"++++--212", "2147483648", "-2147483648", "   - 321",
				"    010", " b11228552307" };
		StringToInteger o = new StringToInteger();
		for (String str : strs) {
			System.out.println(o.atoi(str));			
		}
	}
}
