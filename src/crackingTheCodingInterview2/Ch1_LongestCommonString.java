package crackingTheCodingInterview2;

public class Ch1_LongestCommonString {

	/**
	 * Longest Common String
	 * 
	 * e.g.
	 * 
	 * 		wefuhLongestStringwewhe
	 * 
	 * 		12weLongestString11
	 * 
	 * */
	
	private static int gStart = 0, gLength = 0;
	private static int calledTimes = 0;
	
	public static String longestCommonString(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return null;
		
		char [] cc1 = str1.toCharArray();
		char [] cc2 = str2.toCharArray();
		
		for (int i = 0; i < cc1.length; i++) {
			for (int j = 0; j < cc2.length; j++) {
				check(cc1, cc2, i, j);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (gLength > 0) {
			sb.append(cc1[gStart++]);
			gLength--;
		}
		
		return sb.toString();
	}
	
	public static void check(char [] cc1, char [] cc2, int start1, int start2) {
		int start = start1, length = 0;
		while (start2 < cc2.length && start1 < cc1.length) {
			calledTimes++;
			if (cc1[start1] == cc2[start2]) {
				start1++;
				start2++;
				length++;
			}
			else {
				break;
			}
		}
		
		if (length > gLength) {
			gStart = start;
			gLength = length;
		}
		
	}
	
	public static String longestCommonStringImproved(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return null;
		
		char [] cc1 = str1.toCharArray();
		char [] cc2 = str2.toCharArray();
		
		int [][] table = new int[cc1.length + 1][cc2.length + 1];
		int startIndex = 0, maxLength = 0;
		
		for (int i = 0; i < cc1.length; i++) {
			for (int j = 0; j < cc2.length; j++) {
				calledTimes++;
				if (cc1[i] == cc2[j]) {
					if (i == 0 || j == 0) table[i + 1][j + 1] = 1;
					else {
						table[i + 1][j + 1] = table[i][j] + 1;
					}
					if (table[i + 1][j + 1] > maxLength) {
						maxLength = table[i + 1][j + 1];
						startIndex = i;
					}
				}
			}
		}
		
		// abcd  bcd
		return str1.substring(startIndex + 1 - maxLength, startIndex + 1);
	}
	
	public static void main(String [] args) {
		String str1 = "wefuh -- Longest String. w ewhe";
		String str2 = "12we -- Longest String, 1 1";
		System.out.println("Size of str1: " + str1.length() + ", size of str2: " + str2.length());
		
		System.out.println(longestCommonString(str1, str2));
		System.out.println("calledTimes: " + calledTimes);
		System.out.println();
		
		calledTimes = 0;
		
		System.out.println(longestCommonStringImproved(str1, str2));
		System.out.println("calledTimes: " + calledTimes);
	}
}
