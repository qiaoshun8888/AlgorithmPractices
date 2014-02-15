package amazon.onlineTest;

/**
 * Question1.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 15, 2014
 */

import java.util.*;

public class Question1 {

	/**
	 * (10) Given a list of integers and a window size, return a new list of
	 * integers where each integer is the sum of all integers in the kth window
	 * of the input list. The kth window of the input list is the integers from
	 * index k to index k + window size – 1 (inclusive).
	 * 
	 * For example, [4, 2, 73, 11, -5] and window size 2 should return [6, 75,
	 * 84, 6]. For another example, [4, 2, 73, 11, -5] and window size 3 should
	 * return [79, 86, 79].
	 * 
	 * You may use the JDK or the standard template library. Your solution will
	 * be evaluated on correctness, runtime complexity (big-O), and adherence to
	 * coding best practices. A complete answer will include the following:
	 * 
	 * Document your assumptions Explain your approach and how you intend to
	 * solve the problem Provide code comments where applicable Explain the
	 * big-O run time complexity of your solution. Justify your answer. Identify
	 * any additional data structures you used and justify why you used them.
	 * Only provide your best answer to each part of the question.
	 * */
	
	public static List<Integer> calculateWindowSums(List<Integer> list, int windowSize) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if (list == null || windowSize == 0) return result;
		
		for (int i = 0; i <= list.size() - windowSize; i++) {
			int v  = 0;
			for (int j = i; j < i + windowSize; j++) {
				v += list.get(j);
			}
			result.add(v);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int [] vs = {4, 2, 73, 11, -5};
		List<Integer> list = new ArrayList<Integer>();
		for (int v : vs) {
			list.add(v);
		}
		
		List<Integer> result = calculateWindowSums(list, 3);
		
		for (int v : result) {
			System.out.print(v + " ");
		}
	}
}
