package programcreek.top10InterviewQuestions.stringArray;

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
	 * */
	// String haystack = "mississippi", needle = "issipi";
	public String strStr(String haystack, String needle) {
		if (needle.length() == 0) return haystack;
		if (haystack.length() < needle.length()) return null;
		
		for (int i = 0; i < haystack.length(); i++) {
			if (needle.length() <= haystack.length() - i) {
				int end = i + needle.length() - 1;
				for (int j = i; j <= end; j++) {
					if (haystack.charAt(j) == needle.charAt(j - i)) {
						if (j == end) {
							return haystack.substring(i);
						}
					}
					else break;
				}
			}
		}
		
		return null;
	}
	
	public String strStr2(String haystack, String needle) {
	    if (needle.length() == 0) return haystack;
	    if (haystack.length()<needle.length()) return null;
	    for (int i = 0; i < haystack.length();i++){
	        int j = i;
	        // first judge if there is no enough length left to hit needle, very important to save time
	        // second obvious
	        // tracking needle in haystack
	        while (needle.length()+i <= haystack.length()&& j<haystack.length() && haystack.charAt(j) == needle.charAt(j-i)){
	            j++;
	            if (j-i == needle.length()){
	                return haystack.substring(i);
	            }
	        }

	    }
	    return null;
	}
	
	public static void main(String[] args) {
		ImplementStrStr o = new ImplementStrStr();
		
//		 String haystack = "abcdefgxyz", needle = "cde";
		 String haystack = "mississippi", needle = "issipi";
		System.out.println(o.strStr(haystack, needle));
		System.out.println(o.strStr2(haystack, needle));
	}
}
