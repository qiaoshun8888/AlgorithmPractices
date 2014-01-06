package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_StringPermutation {

	/**
	 * String permutation
	 * 
	 * e.g.
	 * 
	 * Input:
	 * 		abc
	 * 
	 * Output:
	 * 		abc  bac  cba  
	 * 		abc  acb  bac  bca  cab  cba
	 * 
	 * */
	
	private static int calledTimes = 0;
	
	public static List<String> permutation(String str) {
		List<String> list = new ArrayList<String>();
		if (str == null) return list;
		if (str.length() == 1) {
			list.add(str);
			return list;
		}
		Stack<Integer> stack = new Stack<Integer>();
		char [] cc = str.toCharArray();
		
		permutationHelper(cc, 0, stack, list);
		
		return list;
	}
	
	private static void permutationHelper(char [] cc, int start, Stack<Integer> stack, List<String> list) {
		if (start == cc.length) {
			StringBuilder sb = new StringBuilder();
			Stack<Integer> tempStack = new Stack<Integer>();
			tempStack.addAll(stack);
			while(!tempStack.isEmpty()) {
				calledTimes++;
				sb.append((char)(int)tempStack.pop());
			}
			list.add(sb.toString());
			return;
		}
		/**
		 *  start(i)     cc       stack
		 * 	  0(0)		abc			|a		BEGIN
		 * 
		 * 	  1(0)	 	abc	  		|ab		BEGIN
		 * 	  2(0)     	abc		  	|abc	BEGIN	->  add 'abc' into the list
		 *    2(0)     	abc			|ab    	END
		 *    1(0)		abc			|a		END
		 *    
		 *    1(1)		acb			|ac		BEGIN
		 *    2(0)		acb			|acb	BEGIN	->	add 'acb' into the list
		 *    2(0)		acb			|ac		END
		 *    1(1)		abc			|a		END
		 *    
		 *    0(0)		abc			|		END
		 *    
		 *    ----
		 *    
		 *    0(1)		bac			|b		BEGIN
		 *    
		 *    1(0)		bac			|ba		BEGIN	
		 *    2(0)		bac			|bac	BEGIN	->	add 'bac' into the list
		 *    2(0)		bac			|ba		END
		 *    1(0)		bac			|b		END
		 *    
		 *    1(1)		bca			|bc		BEGIN
		 *    2(0)		bca			|bca	BEGIN	->	add 'bca' into the list
		 *    2(0)		bca			|bc		END
		 *    1(1)		bac			|b		END
		 *    
		 *    0(1)		abc			|		END
		 *    
		 *    ----
		 *    
		 *    0(2)		cba			|c		BEGIN
		 *    
		 *    1(0)		cba			|cb		BEGIN
		 *    2(0)		cba			|cba	BEGIN	-> add 'cba' into the list
		 *    2(0)		cba			|cb		END
		 *    1(0)		cba			|c		END
		 *    
		 *    1(1)		cab			|ca		BEGIN
		 *    2(0)		cab			|cab	BEGIN	-> add 'cab' into the list
		 *    2(0)		cab			|ca		END
		 *    1(1)		cba			|c		END	
		 *    
		 * 		
		 * */
		for (int i = 0; i < cc.length - start; i++) {
			swap(cc, start, start + i);
			stack.push((int)cc[start]);
			permutationHelper(cc, start + 1, stack, list);
			stack.pop();
			swap(cc, start, start + i);
		}
	}
	
	private static void swap(char [] cc, int i, int j) {
		if (i != j) {
			cc[i] ^= cc[j];
			cc[j] ^= cc[i];
			cc[i] ^= cc[j];
		}
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
