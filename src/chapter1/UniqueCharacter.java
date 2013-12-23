package chapter1;

public class UniqueCharacter {

	public static boolean isUniqueCharacter(String str) {
		if (str.length() > 256) return false;
		
		boolean [] flags = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int v = str.charAt(i);
			if(flags[v]) {
				return false;
			}
			flags[v] = true;
		}
		return true;
	}
	
	/*
	 * Assuming 'str' only contains lower case letter a through z
	 * 
	 * */
	public static boolean isUniqueCharacter2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int v = str.charAt(i) - 'a';
			System.out.println(v + "\t\t" + (1 << v) + "\t\t" + (checker & (1 << v)));
			if ((checker & (1 << v)) > 0) return false;
			checker |= (1 << v);
		}
		return true;
	}
	
	public static void main(String [] args) {
		String str = "fsneiy";
		System.out.println(UniqueCharacter.isUniqueCharacter(str));
		System.out.println(UniqueCharacter.isUniqueCharacter2(str));
	}
}
