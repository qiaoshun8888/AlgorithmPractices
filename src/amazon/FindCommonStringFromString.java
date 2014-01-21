package amazon;

import java.util.*;

public class FindCommonStringFromString {

	/**
	 * Find common strings from two arrays of strings given
	 * 
	 * */

	public static List<String> commonStrings(String [] strArray1, String [] strArray2) {
		List<String> result = new ArrayList<String>();
		
		if (strArray1 == null || strArray1.length == 0 || strArray2 == null || strArray2.length == 0) return result;
	
		Set<String> set = new HashSet<String>();
		
		for (String s : strArray1) {
			set.add(s);
		}
		
		for (String s : strArray2) {
			if (set.contains(s)) {
				result.add(s);
				set.remove(s);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String [] strArray1 = {"hello", "hello", "good", "bal", "petter", "puppy", "pretty", "pretty"};
		String [] strArray2 = {"hello", "kitty", "pretty", "puppy", "dog", "boy", "pretty", "puppy"};
		
		for (String s : commonStrings(strArray1, strArray2)) {
			System.out.print(s + " ");
		}
	}
}
