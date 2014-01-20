package amazon;

public class ReverseString {

	/**
	 * Reverse a string, iteratively and recursively
	 * 
	 * */
	
	// abcdefg
	public static String reverseRecursively(String str) {
		char [] cc = str.toCharArray();
		reverseHelper(cc, 0, cc.length - 1);
		return new String(cc);
	}
	private static void reverseHelper(char [] cc, int start, int end) {
		if (start > end) return;
		swap(cc, start, end);
		reverseHelper(cc, start + 1, end - 1);
	}
	private static void swap(char [] cc, int a, int b) {
		if (a != b) {
			cc[a] ^= cc[b];
			cc[b] ^= cc[a];
			cc[a] ^= cc[b];
		}
	}
	
	public static String reverseIteratively(String str) {
		if (str == null) return null;
		if (str.length() == 0) return new String();
		
		char [] cc = str.toCharArray();
		int start = 0, end = cc.length - 1;
		
		while (start < end) {
			swap(cc, start++, end--);
		}
		
		return new String(cc);
	}
	
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(reverseRecursively(str));
		System.out.println(reverseIteratively(str));
	}
}
