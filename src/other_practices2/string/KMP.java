package other_practices2.string;

public class KMP {

	/*
	 * KMP
	 */

	public String kmp(String text, String pattern) {
		if (text == null || pattern == null)
			return null;
		if (pattern.length() == 0)
			return text;
		int len_t = text.length(), len_p = pattern.length();
		char[] cc_t = text.toCharArray(), cc_p = pattern.toCharArray();
		int[] n = computePrefix(cc_p);
		int j = 0; // index of cc_p
		for (int i = 0; i < len_t; i++) {
			// find the prefix
			while (j > 0 && cc_t[i] != cc_p[j]) {
				j = n[j - 1];
			}
			// if two character match, then increase j.
			if (cc_t[i] == cc_p[j]) {
				j++;
			}
			// if all the pattern has been matched, return the result.
			//             a b a b a c a
			//                     v  ---->
			// b a c b a b a b a b a c a c a
			//                   ^
			//         a b a b a c a
			if (j == len_p)
				return text.substring(i - j + 1);
		}
		return null;
	}
	
	// a b a b a c a
	private int[] computePrefix(char[] p) {
		int[] n = new int[p.length];
		n[0] = 0;
		int k = 0; // the # of the longest prefix char
		for (int i = 1; i < p.length; i++) {
			// if current char at i does not match char at postition k.
			// we back up and check again, util k is zero which means
			// there is no prefix in the string.
			while (k > 0 && p[i] != p[k]) {
				k = n[k - 1];
			}
			// found prefix, increse k.
			if (p[i] == p[k]) {
				k++;
			}
			// remember that the longest prefix at position i is k.
			n[i] = k;
		}
		return n;
	}

	public static void main(String[] args) {
		String haystack = "wefj3eu1092ewifwiej";
		String needle = "1092e";
		KMP o = new KMP();
		System.out.println(o.kmp(haystack, needle));
	}
}
