package google.arrays;

import java.util.*;

/**
 * Permutations.java
 * 
 * Description: Write a method to compute all permutations of a string
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 27, 2014
 */

public class Permutations {

	/**
	 * Input: abc
	 * Output:
	 * 		abc (0 swap with 0, 1 swap with 1, 2 swap with 2
	 * 		bac (0 swap with 1, 1 swap with 1, 2 swap with 2
	 * 		bca (				1 swap with 2, 2 swap with 2
	 * 		cba (0 swap with 2, 1 swap with 1, 2 swap with 2
	 * 		cab (				1 swap with 2, 2 swap with 2
	 * 		acb (0 swap with 0, 1 swap with 2, 2 swap with 2
	 * */
	public static List<String> permutations(String str) {
		List<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0) return result;
		Stack<Integer> stack = new Stack<Integer>();
		permutationsHelper(str.toCharArray(), 0, stack, result);
		return result;
	}
	private static void permutationsHelper(char [] cc, int start, Stack<Integer> stack, List<String> result) {
		if (stack.size() == cc.length) {
			List<Integer> list = new ArrayList<Integer>(stack);
			Collections.reverse(list);
			StringBuilder sb = new StringBuilder();
			for (int v : list) {
				sb.append((char)v);
			}
			result.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < cc.length - start; i++) {
			swap(cc, start, start + i);
			stack.push((int)cc[start]);
			permutationsHelper(cc, start + 1, stack, result);
			stack.pop();
			swap(cc, start + i, start);
		}
	}
	private static void swap(char [] cc, int a, int b) {
		if (a != b) {
			cc[a] ^= cc[b];
			cc[b] ^= cc[a];
			cc[a] ^= cc[b];
		}
	}
	
	public static void main(String[] args) {
		String str = "abcd";
		List<String> result = permutations(str);
		System.out.println("Size: " + result.size() + "\n");
		for (String s : result) {
			System.out.print(s + " ");
		}
	}
}
