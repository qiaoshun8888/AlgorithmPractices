package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_StringPermutation2 {

	/**
	 * String permutation
	 * 
	 * e.g.
	 * 
	 * Input:
	 * 		abc
	 * 
	 * Output:
	 * 		abc  acb  bac  bca  cab  cba
	 * 
	 * */
	
	private static int calledTimes = 0;
	
	public static List<String> permutation(String str) {
		if (str == null) return null;
		
		List<String> list = new ArrayList<String>();
		if (str.length() == 1) return list;
		
		
		return permutationHelper(str);
	}
	private static List<String> permutationHelper(String str) {
		List<String> newList = new ArrayList<String>();
		
		if (str.length() == 1) {
			newList.add(str);
			return newList;
		}
		
		char lastChar = str.toCharArray()[str.length() - 1];
		
		List<String> list = permutationHelper(str.substring(0, str.length() - 1));
		
		for (String s : list) {
			newList.addAll(combinate(s.toCharArray(), lastChar));
		}
		
		return newList;
	}
	// _a_b_  insert c
	private static List<String> combinate(char [] cc, char c) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= cc.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < cc.length; j++) {
				calledTimes++;
				if (i == j) sb.append(c);
				sb.append(cc[j]);
			}
			if (i == cc.length) sb.append(c);
			list.add(sb.toString());
		}
		return list;
	}
	
	public static void main(String [] args) {
		String str = "abc";
		List<String> list = permutation(str);
		System.out.println("list size is: " + list.size() + "  calledTimes: " + calledTimes);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
