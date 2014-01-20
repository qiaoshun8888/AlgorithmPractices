package amazon;

public class FindCommonCharacters {

	/**
	 * Given two different strings, find the common characters between the two
	 * 
	 * For example:
	 * 
	 * If string A is "hello" and string B is "elbow" 
	 * 
	 * the common characters would be ['e', 'l', 'o'].
	 * 
	 * */
	
	public static char [] commonChars(String str1, String str2) {
		if (str1 == null || str2 == null) return null;
		if (str1.length() == 0 || str2.length() == 0) return new char [0];
		
		int [] ascii = new int[256];
		
		char [] cc1 = str1.toCharArray();
		char [] cc2 = str2.toCharArray();
		
		for (char c : cc1) {
			if (ascii[c] == 0) ascii[c] = 1;
		}
		
		int size = 0;
		
		for (char c : cc2) {
			if (ascii[c] == 1) {
				ascii[c] = 2;
				size++;
			}
		}
		
		char [] cc = new char[size];
		
		for (int i = 0, j = 0; i < ascii.length; i++) {
			if (ascii[i] == 2) cc[j++] = (char)i;
		}
		
		return cc;
	}
	
	public static void main(String [] args) {
		String str1 = "hello", str2 = "elbow";
		for (char c : commonChars(str1, str2)) {
			System.out.print(c + " ");
		}
	}
}
