package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class N04PrintAllValidParenthesis {

	/**
	 * Print all valid combinations of groups of parenthesis.
	 * 
	 * Given: ((())) Print: ()()(), (())(), ()(()), ((())), (()())
	 * 
	 * */

	/**
	 * First, we count how many pair of parentheses does the given string have.
	 * (n pair of parentheses) Then we build the combination from 1 - n pair of
	 * parentheses. Here is how: 
	 * 1. () 
	 * 2. To get all the combinations of two
	 * pair parentheses, we can just add the second parenthesis to these two
	 * positions: _ ( _ ) That means both sides of '(' we can add a new
	 * parenthesis to create a combination (might have duplicates combinations)
	 * 3. Using hashtable to remember the combinations we already computed
	 * */
	private static int called_times = 0;
	public static void getCombinations(int n) {
		Set<String> set = combine(n);
		for (String s : set) {
			System.out.print(s + "  ");
		}
		System.out.println();
	}
	
	/**
	 * We use HastSet to eliminate the duplicates combinations.
	 * 
	 * The differences between HashSet and TreeSet is here:
	 * http://stackoverflow.com/questions/1463284/hashset-vs-treeset
	 * 
	 * Summary:
	 * HashSet: constant time for basic operations (lookup, add, remove), no order guarantee.
	 * TreeSet: log(N) time for basic operations (lookup, add, remove), elements will be ordered.
	 * */
	private static Set<String> combine(int n) {
		if (n == 1) {  // Base case, when n == 1, there is only one combination.
			Set<String> set = new HashSet<String>();
			set.add("()");
			return set;
		}
		
		Set<String> set = combine(n - 1); // compute n - 1 's combinations
		Set<String> n_set = new HashSet<String>(); // compute n 's combinations based on n - 1's.
		// For every combination of n parentheses, we compute its n + 1 combinations.
		for (String s : set) {
			char [] cc = s.toCharArray();
			int added_i = 0; // when use an integer to indicate which index has been computed. Since we add new parenthesis at '(' 's left & right. So in this case: '((', we will add [1] twice.  
			for (int i = 0; i < cc.length; i++) {
				char c = cc[i];
				if (c == '(') {
					// i = add in front of i
					if ((added_i & (1 << i)) == 0) { // to see if position [i] already added 
						n_set.add(generateAParenthesis(cc, i));
						added_i |= 1 << i;
					}
					// i + 1 = add behind of i
					if ((added_i & (1 << i + 1)) == 0) { // to see if position [i] already added 
						n_set.add(generateAParenthesis(cc, i + 1));
						added_i |= 1 << i + 1;
					}
				}
			}
		}
		return n_set;
	}
	
	private static String generateAParenthesis(char [] cc, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cc.length; i++) {
			called_times++;
			if (i == index) {
				sb.append("()");
			}
			sb.append(cc[i]);
		}
		// add () at the end of the string
		if (index == cc.length) {
			sb.append("()");
		}
		return sb.toString();
	}
	
	// =========================================================================
	// Recursive solution
	public static void getCombinationsRecursively(int left_remain, int right_remain, String s) {
		called_times += s.length();
		if (right_remain == 0) {
			System.out.print(s + " ");
			return;
		}
		if (left_remain > 0) {
			getCombinationsRecursively(left_remain - 1, right_remain, s + "(");
			if (left_remain < right_remain) {
				getCombinationsRecursively(left_remain, right_remain - 1, s + ")");
			}
		}
		else {
			getCombinationsRecursively(left_remain, right_remain - 1, s + ")");
		}
	}
	
	public static void getCombinationsRecursively2(int n, int open, int close, String s) {
		called_times += s.length();
		if (close == n) {
			System.out.print(s + " ");
			return;
		}
		if (open < n) getCombinationsRecursively2(n, open + 1, close, s + "(");
		if (close < open) getCombinationsRecursively2(n, open, close + 1, s + ")");
	}
	
	public static void main(String [] args) {
		int N = 3;
		getCombinations(N);
		System.out.println("called_times: " + called_times);
		called_times = 0;
		
		System.out.println();
		getCombinationsRecursively(N, N, "");
		System.out.println("\ncalled_times: " + called_times);
		called_times = 0;
		
		System.out.println();
		getCombinationsRecursively2(N, 0, 0, "");
		System.out.println("\ncalled_times: " + called_times);
	}
}
