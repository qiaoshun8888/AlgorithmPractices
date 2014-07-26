package other_practices2.string;

public class AddBinary {

	/*
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, a = "11" b = "1" Return "100".
	 */

	public String addBinary(String a, String b) {
		if (a == null && b == null)
			return null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		int len_a = a.length(), len_b = b.length();
		// let's assume len_a always great than len_b
		if (len_a < len_b)
			return addBinary(b, a);
		char[] cc_a = a.toCharArray();
		char[] cc_b = b.toCharArray();
		char[] cc = new char[len_a + 1];
		int carry = 0;
		for (int i = len_a - 1, j = len_b - 1; i >= 0; i--) {
			int v = carry + cc_a[i] - '0';
			carry = 0;
			if (j >= 0) {
				v += cc_b[j] - '0';
				j--;
			}
			if (v > 1) {
				carry = 1;
				v -= 2;
			}
			cc[i + 1] = (char) (v + '0');
		}
		cc[0] = (char) (carry + '0');
		String result = new String(cc);
		if (cc[0] == '0')
			return result.substring(1);
		else
			return result;
	}

	public static void main(String[] args) {
		String a = "1011", b = "111";
		AddBinary o = new AddBinary();
		System.out.println(o.addBinary(a, b));
	}
}
