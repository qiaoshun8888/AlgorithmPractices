package crackingTheCodingInterview2;

public class Ch1_VerifyPermutationOfString {

	/**
	 * Given two strings, write a method to decide if one is a permutation of
	 * the other.
	 * 
	 * */
	
	/**
	 * str1: abbc
	 * str2: bcba
	 * */
	public static boolean verifyPermutation(String str1, String str2) {
		if ((str1 == null && str2 != null) || (str1 != null && str2 == null) || str1.length() != str2.length()) {
			return false;
		}
		char [] ccStr1 = str1.toCharArray(); 
		java.util.Arrays.sort(ccStr1);
		
		char [] ccStr2 = str2.toCharArray();
		java.util.Arrays.sort(ccStr2);
		
		return new String(ccStr1).equals(new String(ccStr2));
	}
	
	public static boolean verifyPermutation2(String str1, String str2) {
		if ((str1 == null && str2 != null) || (str1 != null && str2 == null) || str1.length() != str2.length()) {
			return false;
		}
		
		byte [] count1 = new byte[128];
		byte [] count2 = new byte[128];
		
		for (char c : str1.toCharArray()) {
			count1[c] += 1;
		}
		for (char c : str2.toCharArray()) {
			count2[c] += 1;
		}
		
		for (int i = 0; i < 128; i++) {
			if (count1[i] != count2[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) {
		String str1 = "bca";
		String str2 = "abc";
		// System.out.println(verifyPermutation(str1, str2));
		System.out.println(verifyPermutation2(str1, str2));
	}
}
