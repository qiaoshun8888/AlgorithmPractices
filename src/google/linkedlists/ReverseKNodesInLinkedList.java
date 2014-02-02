package google.linkedlists;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

/**
 *	ReverseKNodesInLinkedList.java
 *
 *	Description: reverse each k nodes in linked list 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Feb 2, 2014
 */

public class ReverseKNodesInLinkedList {

	// 1 2 3 4 5 6  (k = 3)
	// 3 2 1 4 5 6
	public static LinkedNode reverse(LinkedNode head, int k) {
		if (k <= 1 || head == null) return head;
		
		LinkedNode runner = head.next, temp = null, newHead = head, newTail = newHead;
		int n = 1;
		
		newHead.next = null;
		
		while (runner != null && n < k) {
			temp = runner.next;
			runner.next = newHead;
			newHead = runner;
			runner = temp;
			n++;
		}
		
		newTail.next = temp;
		
		return newHead;
	}
	
	public static void main(String[] args) {
		int[] vs = {1, 2, 3, 4, 5, 6};
		int k = 2;
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		LinkedListUtils.print(reverse(head, k));
	}
}
