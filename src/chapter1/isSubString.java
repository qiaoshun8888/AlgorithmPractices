package chapter1;

public class isSubString {
	
	public static boolean checkIsSubstring(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0) return false;
		
		String ss = s1 + s1;
		if (ss.contains(s2)) return true;
		else return false;
	}
	
	public static void main(String args[]) {
		String s1 = "HelloWorld";
		String s2 = "rldHelloWo";
		
		System.out.println("isSubstring: " + (isSubString.checkIsSubstring(s1, s2) ? "YES" : "NO"));
	}
}
