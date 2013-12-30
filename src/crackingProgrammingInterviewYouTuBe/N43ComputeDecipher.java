package crackingProgrammingInterviewYouTuBe;

import java.util.*;

public class N43ComputeDecipher {

	/**
	 * Given a-z matching 1-26, compute number of possible decipher ways for a
	 * given integer array.
	 * 
	 * e.g {123} can be deciphered into {1, 2, 3} 'abc', {12, 3} 'cl', and {1,
	 * 23} 'aw'
	 * 
	 * */

	public static Set<StringBuilder> decode(int[] codes, int index) {
		System.out.println("index: " + index);
		Set<StringBuilder> set = new HashSet<StringBuilder>();
		StringBuilder sb = new StringBuilder();
		for (int i = index; i < codes.length; i++) {
			if (isValid(codes, index)) {
				sb.append(codeToChar(codes[index]));
			}
			if (isValid2(codes, index)) {
				sb.deleteCharAt(sb.length() - 1);
				sb.append(codeToChar2(codes, index));
				set.addAll(decode(codes, index + 2));
			}
		}
		set.add(sb);
		return set;
	}

	private static char codeToChar(int i) {
		return (char) (96 + i);
	}

	private static char codeToChar2(int[] codes, int index) {
		int v = codes[index] * 10 + codes[index + 1];
		return codeToChar(v);
	}

	private static boolean isValid(int[] codes, int index) {
		return codes[index] != 0;
	}

	private static boolean isValid2(int[] codes, int index) {
		if (index + 1 < codes.length) {
			int v = codes[index] * 10 + codes[index + 1];
			if (v >= 10 && v <= 26) {
				return true;
			}
		}
		return false;
	}

	static String alphabet="#abcdefghijklmnopqrstuvwxyz";
	private static void parseNumber(int i, int j, String string, String result) {
		if (j < i) {
			System.out.println(result);
			return;
		}

		int c = Integer.parseInt(string.charAt(j) + "");
		if (c <= 26) {
			parseNumber(i, j - 1, string, alphabet.charAt(c) + result);
		}

		if (j > 0) {
			c = Integer.parseInt(string.charAt(j - 1) + "" + string.charAt(j) + "");
			if (c <= 26) {
				parseNumber(i, j - 2, string, alphabet.charAt(c) + result);
			}
		}

	}

	public static void main(String[] args) {
		/**
		 * ASCII
		 * 
		 * 1 (49) A (65) a (97)
		 * 
		 * */
		parseNumber(0,3,"1123","");
		
		int[] codes = { 1, 2, 3 };
		System.out.println("Possible ways: " + decode(codes, 0));
	}
}
