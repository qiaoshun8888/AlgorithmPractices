package google.queues_stacks;

import java.util.*;

/**
 * FindKthMagicNumber357.java
 * 
 * Description: Design an algorithm to find the kth number such that the only
 * prime factors are 3, 5, and 7.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 26, 2014
 */

public class FindKthMagicNumber357 {

	/**
	 * 3   3 * 1
	 * 5   5 * 1
	 * 7   7 * 1
	 * 
	 * 9   3 * 3
	 * 15  5 * 3
	 * 21  7 * 3
	 * 
	 * 25  5 * 5
	 * 27  3 * 9
	 * 35  5 * 7
	 * 
	 * ...
	 * 
	 * */
	
	/**
	 * 	Q3: 3,
	 *  Q5: 5, 
	 *  Q7: 7,
	 * <-3
	 *  Q3: 3*3,
	 *  Q5: 5, 5*3,
	 * 	Q7: 7, 7*3,
	 * <-5
	 *  Q3: 3*3,
	 *  Q5: 5*3, 5*5
	 *  Q7: 7, 7*3, 7*5
	 * <-7
	 *  Q3: 3*3
	 *  Q5: 5*3, 5*5
	 *  Q7: 7*3, 7*5, 7*7
	 * <-3*3
	 *  Q3: 3*3*3,
	 *  Q5: 5*3, 5*5, 5*3*3
	 *  Q7: 7*3, 7*5, 7*7, 7*3*3
	 *  ...
	 * */
	
	public static int find(int k) {
		if (k == 0) return 0;
		
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		
		q3.add(3);
		q5.add(5);
		q7.add(7);
		
		int min = 0;
		
		for (int i = 1; i <= k; i++) {
			int v3 = q3.peek(), v5 = q5.peek(), v7 = q7.peek();
			min = Math.min(v3, Math.min(v5, v7));
			if (min == v3) {
				q3.poll();
				q3.add(v3*3);
				q5.add(v5*3);
				q7.add(v7*3);
			}
			else if (min == v5) {
				q5.poll();
				q5.add(v5*5);
				q7.add(v7*5);
			}
			else {
				q7.poll();
				q7.add(v7*7);
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(find(12));
	}
}
