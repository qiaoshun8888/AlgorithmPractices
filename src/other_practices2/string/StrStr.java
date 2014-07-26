package other_practices2.string;

public class StrStr {

	/*
	 * Implement strStr().
	 * 
	 * Returns a pointer to the first occurrence of needle in haystack, or null
	 * if needle is not part of haystack.
	 */

	// O(m*n)
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		if (needle.length() == 0)
			return haystack;
		char[] ccAll = haystack.toCharArray();
		char[] cc = needle.toCharArray();
		for (int i = 0; i < ccAll.length - cc.length + 1; i++) {
			int j_start = i, j_end = i + cc.length - 1, k_start = 0, k_end = cc.length - 1;
			boolean flag = true;
			while (k_start <= k_end) {
				if (ccAll[j_start++] != cc[k_start++]
						|| ccAll[j_end--] != cc[k_end--]) {
					flag = false;
					break;
				}
			}
			if (flag)
				return haystack.substring(i);
		}
		return null;
	}

	public static void main(String[] args) {
		String haystack = "wefj3eu1092ewifwiej";
		String needle = "1092e";
		StrStr o = new StrStr();
		System.out.println(o.strStr(haystack, needle));
	}
}
