package chapter1;

public class ReplaceSpaces {
	
	/*
	 * Not in-place, need extra space
	 **/
	public static String replaceSpace(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == ' ') sb.append("%20");
			else sb.append(c);
		}
		return sb.toString();
	}
	
	/*
	 * In-place implementation
	 * 
	 * x x x x x x x x _ _ _ _ _ _ _ _ _ _ ... (enough spaces in the end of the string)
	 * 
	 * 							^
	 * 							| need n extra space to replace ' ' to '%20'
	 * 
	 **/
	public static String replaceSpace2(char [] chars, int content_length) {
		int total_size = 0;
		for (int i = 0; i < content_length; i++) {
			if (chars[i]==' ') total_size += 3;
			else total_size++;
		}
		
		System.out.println("total_size is :" + total_size);
		
		for (int i = content_length - 1; i > 0; i--) {
			if (chars[i] == ' ') {
				chars[--total_size] = '0';
				chars[--total_size] = '2';
				chars[--total_size] = '%';
			}
			else {
				chars[--total_size] = chars[i];
			}
		}
		return new String(chars);
	}
	
	public static void main(String args []) {
		String s = "hello world! I'm John Qiao.";
		System.out.println(ReplaceSpaces.replaceSpace(s));
		
		char chars [] = new char[1024];
		for (int i = 0; i < s.length(); i++) {
			chars[i] = s.charAt(i);
		}
		
		System.out.println(ReplaceSpaces.replaceSpace2(chars, s.length()));
	}
}
