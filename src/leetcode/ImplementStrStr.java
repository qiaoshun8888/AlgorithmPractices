package leetcode;

public class ImplementStrStr {

	/**
	 * Implement strStr().
	 * 
	 * Returns a pointer to the first occurrence of needle in haystack, or null
	 * if needle is not part of haystack.
	 * 
	 * */
	
	/**
	 * a b c d e f g x y z
	 * 
	 *     c d e
	 *     
	 *     c d f
	 * 
	 * */
	public String strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) return haystack;
		if (haystack == null || haystack.length() == 0) return null;
		
		for (int i = 0; i < haystack.length(); i++) {
			int end = i + needle.length() - 1;
			if (end < haystack.length()) {
				for (int j = i; j <= end; j++) {
					if (haystack.charAt(j) == needle.charAt(j - i)) {
						if (j == end)
							return haystack.substring(i);
					}
					else break;
				}
			}
		}
		
		return null;
    }
	
	public static void main(String[] args) {
		ImplementStrStr o = new ImplementStrStr();
		
		 String haystack = "abcdefgxyz", needle = "cde";
//		 String haystack = "mississippi", needle = "issipi";
		System.out.println(o.strStr(haystack, needle));
	}
}
