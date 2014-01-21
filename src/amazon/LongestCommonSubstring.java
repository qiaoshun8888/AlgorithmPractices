package amazon;

public class LongestCommonSubstring {

	/**
	 * Find the longest common substring of two given strings
	 * 
	 * */
	
	// aaa12345ffff
	// ccccc12345kk
	private static int gStart = 0, gLength = 0;
	public static String LCS_Naive(String str1, String str2) {
		if (str1 == null || str2 == null) return null;
		if (str1.length() == 0 || str2.length() == 0) return new String();
		
		char [] cc1 = str1.toCharArray();
		char [] cc2 = str2.toCharArray();
		
		for (int i = 0; i < cc1.length; i++) {
			for (int j = 0; j < cc2.length; j++) {
				if (cc1[i] == cc2[j]) check(cc1, i, cc2, j);
			}
		}
		
		return str1.substring(gStart, gStart + gLength);
	}
	private static void check(char [] cc1, int start1, char [] cc2, int start2) {
		int start = start1, length = 0;
		while (start1 < cc1.length && start2 < cc2.length) {
			if (cc1[start1++] == cc2[start2++]) length++;
			else break;
		}
		if (length > gLength) {
			gStart = start;
			gLength = length;
		}
	}
	
	public static String LCS_Improve(String str1, String str2) {
		if (str1 == null || str2 == null) return null;
		if (str1.length() == 0 || str2.length() == 0) return new String();

		char [] cc1 = str1.toCharArray();
		char [] cc2 = str2.toCharArray();
		
		int [][] matrix = new int[cc1.length + 1][cc2.length + 1];
		
		/**
		 * 		a b c a
		 * 		d b c a
		 * 
		 *    a b c a
		 *  d 0 0 0 0   
		 *  b 0 1 0 0
		 *  c 0 0 2 0
		 *  a 1 0 0 3
		 * 
		 * */
		int end = 0, length = 0;
		
		for (int i = 0; i < cc1.length; i++) {
			for (int j = 0; j < cc2.length; j++) {
				if (cc1[i] == cc2[j]) {
					int v = matrix[i][j] + 1;
					matrix[i + 1][j + 1] = v;
					if (v > length) {
						end = i;
						length = v;
					}
				}
			}
		}
		
		return str1.substring(end - length + 1, end + 1);
	}
	
	public static void main(String[] args) {
		String str1 = "aaa12345ffff";
		String str2 = "ccccc12345kk";
		System.out.println(LCS_Naive(str1, str2));
		System.out.println(LCS_Improve(str1, str2));
	}
}
