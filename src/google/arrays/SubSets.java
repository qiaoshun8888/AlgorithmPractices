package google.arrays;

import java.util.*;

/**
 * SubSets.java
 * 
 * Description: Write a method to return all subsets of aset.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 27, 2014
 */

public class SubSets {

	// {abc} -> {}, {a}, {b}, {c}, {ab}, {ac}, {bc}, {abc}
	public static List<String> subsets(String str) {
		List<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0) return result;
		boolean [] used = new boolean[str.length()];
		subsetsHelper(str.toCharArray(), 0, used, result);
		return result;
	}
	private static void subsetsHelper(char [] cc, int start, boolean [] used, List<String> result) {
		if (start == cc.length) {
			result.add(generateString(cc, used));
			return;
		}
		
		// used current char
		used[start] = false;
		subsetsHelper(cc, start + 1, used, result);
		
		// undo last step, not used current char
		used[start] = true;
		subsetsHelper(cc, start + 1, used, result);
	}
	private static String generateString(char [] cc, boolean [] used) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < used.length; i++) {
			if (used[i]) sb.append(cc[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "abc";
		List<String> result = subsets(str);
		for (String s : result) {
			System.out.print("{" + s + "}  ");
		}
		System.out.println();
	}
}
