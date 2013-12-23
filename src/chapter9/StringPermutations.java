package chapter9;

import java.util.ArrayList;

public class StringPermutations {
	
	// Time: O(N!)  Space: O(N!)
	private static int called_times = 0;
	private static ArrayList<String> permutationOfString(String str) {
		int length = str.length();
		if (length == 1) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(str);
			return list;
		}
		
	    char last_char = str.toCharArray()[length-1];
	    
	    ArrayList<String> list = permutationOfString(str.substring(0, length - 1));
	    ArrayList<String> l = new ArrayList<String>();

	    for (String s : list) {
			char [] cc = s.toCharArray();
			for (int i = 0; i < s.length(); i++) {
				called_times++;
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < cc.length; j++) {
					if (i == j) {
						sb.append(last_char);
					}
					sb.append(cc[j]);
				}
				l.add(sb.toString());
				if (i == s.length() - 1) {
					l.add(s + last_char);
				}
			}
		}
		return l;
	}
	

	public static void main(String [] args) {
		String str = "ABCD";
		ArrayList<String> list = permutationOfString(str);
		
		System.out.println("size: " + list.size() + "  called_times: " + called_times + " -- - - - - - - -- -  -");
		for (String s : list) {
			System.out.print(s + " ");
		}
	}
}
