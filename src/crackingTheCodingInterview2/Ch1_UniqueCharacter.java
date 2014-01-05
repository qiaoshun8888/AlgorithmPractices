package crackingTheCodingInterview2;

public class Ch1_UniqueCharacter {

	/**
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you cannot use additional data structures
	 * 
	 * */
	
	/*
	 * abccdef 
	 * */
	public static boolean verifyUniqueString(String str) {
		if (str == null) return true;
		
		boolean [] set = new boolean[128];
		char [] cc = str.toCharArray();
		
		for (int i = 0; i < cc.length; i++) {
			if (set[cc[i]]) return false;
			set[cc[i]] = true;
		}
		
		return true;
	}
	
	
	public static void main(String [] args) {
		String str = "abcedef";
		System.out.println("Is unique string? " + verifyUniqueString(str));
	}
}
