package amazon.onlineTest;

/**
 * Question2.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 15, 2014
 */

import java.util.*;

public class Question2 {

	/**
	 * (3) Given two lists of integers, write a function that returns a list
	 * that contains only the intersection (elements that occur in both lists)
	 * of the two lists. The returned list should only contain unique integers,
	 * no duplicates.
	 * 
	 * For example, [4, 2, 73, 11, -5] and [-5, 73, -1, 9, 9, 4, 7] would return
	 * a list containing [-5, 4, 73] in no particular order.
	 * 
	 * You may use the JDK or the standard template library. Your solution will
	 * be evaluated on correctness, runtime complexity (big-O), and adherence to
	 * coding best practices. A complete answer will include the following:
	 * 
	 * Document your assumptions Explain your approach and how you intend to
	 * solve the problem Provide code comments where applicable Explain the
	 * big-O run time complexity of your solution. Justify your answer. Identify
	 * any additional data structures you used and justify why you used them.
	 * Only provide your best answer to each part of the question. Use one of
	 * the following skeletons for your solutions:
	 * 
	 * */
	
	public static List<Integer> intersection (List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<Integer>();
		if (a == null || b == null) return result;
		
		Set<Integer> set = new HashSet<Integer>();
		for (int v : a) {
			set.add(v);
		}
		
		for (int v : b) {
			if (set.contains(v)) {
				set.remove(v);
				result.add(v);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int [] vs1 = {4, 2, 73, 11, -5, 9};
		int [] vs2 = {-5, 73, -1, 9, 9, 4, 7};
		List<Integer> a = new ArrayList<Integer>();
		for (int v : vs1) {
			a.add(v);
		}
		List<Integer> b = new ArrayList<Integer>();
		for (int v : vs2) {
			b.add(v);
		}
		
		List<Integer> result = intersection(a, b);
		
		for (int v : result) {
			System.out.print(v + " ");
		}
	}
}
