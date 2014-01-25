package google;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TrackArrayMedian.java
 * 
 * Description: Numbers are randomly generated and stored into an (expanding)
 * array. How would you keep track of the median?
 * 
 * A heap is really good at basic ordering and keeping track of max and mins.
 * This is actually interesting - if you had two heaps, you could keep track of
 * the biggest half and the smallest half of the elements. The biggest half is
 * kept in a min heap, such that the smallest element in the biggest half is at
 * the root. The smallest half is kept in a max heap, such that the biggest
 * element of the smallest half is at the root. Now, with these data structures,
 * you have the median elements at the roots. If the heaps are no longer the
 * same size, you can quickly "rebalance" the heaps by popping an element off
 * the one heap and pushing it onto the other.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 25, 2014
 */

public class TrackArrayMedian {

	final int SIZE = 20;

	PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>(SIZE,
			new RightMinComparator());
	PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>(SIZE,
			new LeftMaxComparator());

	public double getMedian() {
		if (rightMinHeap.size() == 0) {
			return leftMaxHeap.peek();
		} else {
			if (leftMaxHeap.size() > rightMinHeap.size())
				return leftMaxHeap.peek();
			else if (leftMaxHeap.size() < rightMinHeap.size())
				return rightMinHeap.peek();
			else
				return ((float) leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
		}
	}

	public double add(int n) {
		if (leftMaxHeap.size() == 0) {
			leftMaxHeap.offer(n);
		} else {
			if (n <= leftMaxHeap.peek()) {
				leftMaxHeap.offer(n);
			} else {
				rightMinHeap.offer(n);
			}
			swap();
		}
		return getMedian();
	}

	private void swap() {
		if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
			rightMinHeap.offer(leftMaxHeap.poll());
		} else if (leftMaxHeap.size() - rightMinHeap.size() < -1) {
			leftMaxHeap.offer(rightMinHeap.poll());
		}
	}

	class LeftMaxComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	}

	class RightMinComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	}

	public static void main(String[] args) {
		TrackArrayMedian o = new TrackArrayMedian();

		int[] vs = { 1, 2, 3, 4, 5, 6, 7 };
		for (int v : vs) {
			System.out.println(o.add(v));
		}

		System.out.println();
		System.out.println(o.leftMaxHeap + "  peek: " + o.leftMaxHeap.peek());
		System.out.println(o.rightMinHeap + "  peek: " + o.rightMinHeap.peek());
	}
}
