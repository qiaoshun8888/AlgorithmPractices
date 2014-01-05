package crackingTheCodingInterview2;

public class Ch1_ReplaceSpaces {

	/**
	 * Write a method to replace all spaces in a string with '%20'. You may
	 * assume that the string has sufficient space at the end of the string to
	 * hold the additional characters, and that you are given the "true" length
	 * of the string. (Note: if implementing in Java, please use a character
	 * array so that you can perform this operation in place.)
	 * 
	 * */
	
	/**
	 * H__el_lo_!
	 *           ________
	 * H%20%20el%20lo%20!
	 * 
	 * _ -> %20
	 * */
	public static void replace(char [] cc, int length) {
		if (cc == null) return;
		
		int numOfSpaces = 0;
		for (char c : cc) {
			if (c == ' ') numOfSpaces++;
		}
		int endIndex = length + 2 * numOfSpaces - 1;
		
		for (int i = length - 1; i >= 0; i--) {
			if (cc[i] == ' ') {
				cc[endIndex--] = '0';
				cc[endIndex--] = '2';
				cc[endIndex--] = '%';
			}
			else {
				cc[endIndex--] = cc[i];
			}
		}
	}
	
	public static void main(String [] args) {
		char [] cc = new char[30];
		String str = "H  el lo !";
		char [] ccStr = str.toCharArray();
		for (int i = 0; i < ccStr.length; i++) {
			cc[i] = ccStr[i];
		}
		
		replace(cc, str.length());
		
		for (char c : cc) {
			System.out.print(c);
		}
	}
}
