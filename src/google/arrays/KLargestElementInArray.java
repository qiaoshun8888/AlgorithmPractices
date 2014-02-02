package google.arrays;

import java.util.*;

/**
 * KLargestElementInArray.java
 * 
 * Description: k largest(or smallest) elements in an array
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 1, 2014
 */

public class KLargestElementInArray {

	public static ArrayList<Integer> kLargestElements(int [] vs, int k) {
		Queue<Integer> minPQ = new PriorityQueue<Integer>(k, new MinPQComparator());
		for (int i = 0; i < vs.length; i++) {
			if (minPQ.size() < k) {
				minPQ.offer(vs[i]);
			}
			else if(minPQ.peek() < vs[i]) {
				minPQ.poll();
				minPQ.offer(vs[i]);
			}
		}
		return new ArrayList<Integer>(minPQ);
	}
	
	public static void main(String[] args) {
		int [] vs = {2, 7, 5, 4, 1, 8, 6, 3, 9};
		int k = 3;
		for (int v : kLargestElements(vs, k)) {
			System.out.print(v + " ");
		}
	}
	
	static class MinPQComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
		
	}
	
	static class MaxPQComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
		
	}
}
