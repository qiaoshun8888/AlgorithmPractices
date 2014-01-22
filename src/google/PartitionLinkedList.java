package google;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

public class PartitionLinkedList {

	/**
	 * Partition a linked list around a value x, such that all nodes less than x
	 * come before all nodes greater than or equal to x.
	 * */
	
	public static LinkedNode partition(LinkedNode head, int x) {
		if (head == null) return null;
		
		LinkedNode runner = head.next, pre = head;
		
		// x = 3    {1, 5, 7, 2, 5, 9}
		// === Order doesn't matter, insert the node less than x in the head ===
		while (runner != null) {
			if (runner.val < x) {
				pre.next = runner.next;
				LinkedNode temp = runner;
				runner = runner.next;
				temp.next = head;
				head = temp;
			}
			else {
				pre = runner;
				runner = runner.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 5, 2, 2, 3, 7, 0, 4};
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		head = partition(head, 3);
		LinkedListUtils.print(head);
		
		
	}
}
