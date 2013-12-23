package chapter1;

public class PermutationOfString {
	
	public static String sort(String s) {
		char [] chars = s.toCharArray();
		java.util.Arrays.sort(chars);;
		return new String(chars);
	}
	
	public static boolean isPermutation(String s, String t) {
		if (s.length() != t.length()) return false;
		return sort(s).equals(sort(t));
	}
	
	public static boolean isPermutation2(String s, String t) {
		if (s.length() != t.length()) return false;
		
		int [] letters = new int[256];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
			System.out.print(letters[s.charAt(i)] + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < t.length(); i++) {
			if (--letters[t.charAt(i)] < 0) return false;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		String s = "helloworld";
		String t = "dlrowolllh";
		System.out.println(PermutationOfString.isPermutation(s, t));
		System.out.println(PermutationOfString.isPermutation2(s, t));
	}
}
