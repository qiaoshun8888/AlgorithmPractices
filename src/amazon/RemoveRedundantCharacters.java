package amazon;

public class RemoveRedundantCharacters {

	/**
	 * Write a function to remove all redundant characters in a given string
	 * with minimum space and time complexity
	 * 
	 * */
	
	public static String removeRedundantChars(String str) {
		if (str == null || str.length() == 0) return str;
		
		char [] cc = str.toCharArray();
		int [] ascii = new int[256];
		boolean [] t = new boolean[cc.length];
		int length = cc.length;
		
		for (int i = 0; i < cc.length; i++) {
			if (ascii[cc[i]] == 1) {
				t[i] = true;
				length--;
			}
			else ascii[cc[i]] = 1;
		}
		
		char [] ccTemp = new char[length];
		for (int i = 0, index = 0; i < cc.length; i++) {
			if (!t[i]) ccTemp[index++] = cc[i];
		}
		
		return new String(ccTemp);
	}
	
	public static void main(String[] args) {
		String str = "http://tanao.net"; // expected: htp:/ano.e
		System.out.println(removeRedundantChars(str));
	}
}
