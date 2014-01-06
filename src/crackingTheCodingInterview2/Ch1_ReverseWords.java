package crackingTheCodingInterview2;

public class Ch1_ReverseWords {

	/**
	 * Reverse Words In Phrase Without Additional Memory
	 * 
	 * e.g.
	 * 
	 * 		Hello World!
	 * 
	 * 		World! Hello		
	 * 
	 * */
	
	public static String reverse(String str) {
		if (str == null || str.length() < 2) return str;
		
		char [] cc = str.toCharArray();
		reverseHelper(cc, 0, cc.length - 1);
		
		int start = 0;
		for (int i = 0; i < cc.length; i++) {
			if (cc[i] == ' ') {
				reverseHelper(cc, start, i - 1);
				start = i + 1;
			}
			else if (i == cc.length - 1) {
				reverseHelper(cc, start, i);
			}
		}
		
		return new String(cc);
	}
	private static void reverseHelper(char [] cc, int start, int end) {
		while (start < end) {
			cc[start] ^= cc[end];
			cc[end] ^= cc[start];
			cc[start] ^= cc[end];
			start++;
			end--;
		}
	}
	
	public static void main(String [] args) {
		String str = "Hello World!";
		System.out.println(reverse(str));
	}
}
