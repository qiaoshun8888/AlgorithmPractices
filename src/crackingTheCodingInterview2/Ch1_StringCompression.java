package crackingTheCodingInterview2;

public class Ch1_StringCompression {

	/**
	 * Implement a method to perform basic string compression using the counts
	 * of repeated characters. For example, the string aabcccccaaa
	 * would become a2blc5a3. If the "compressed" string would not become
	 * smaller than the original string, your method should return the original
	 * string.
	 * 
	 * */
	
	/**
	 * aabcccccaaa
	 * 
	 * a2b1c5a3
	 * */
	public static String compress(String str) {
		if (str == null || str.length() == 0) return new String();
		
		char [] cc = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int count = 1;
		char lastChar = cc[0];
		sb.append(lastChar);
		
		for (int i = 1; i < cc.length; i++) {
			if (cc[i] == lastChar) {
				count++;
			}
			else {
				lastChar = cc[i];
				sb.append(count);
				count = 1;
				sb.append(cc[i]);
			}
		}
		sb.append(count);
		
		String newString = sb.toString();
		return newString.length() < str.length() ? newString : str;
	}
	
	public static void main(String [] args) {
//		String str = "aabcccccaaa";
		String str = "abcdddddddddddddef";
		System.out.println(compress(str));
	}
}
