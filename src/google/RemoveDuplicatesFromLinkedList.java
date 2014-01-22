package google;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

public class RemoveDuplicatesFromLinkedList {

	/**
	 * Remove duplicates from an unsorted linked list, no extra space allowed.
	 * 
	 * */
	
	public static LinkedNode removeDuplicates(LinkedNode head) {
		if (head == null) return null;
		
		LinkedNode runner = head;
		while (runner != null) {
			LinkedNode innerRunner = runner.next;
			LinkedNode pre = runner;
			// 2 2 2 4 5
			while (innerRunner != null) {
				if (runner.val == innerRunner.val) {
					pre.next = innerRunner.next;
				}
				else {
					pre = innerRunner;
				}
				innerRunner = innerRunner.next;
			}
			runner = runner.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 2, 2, 3, 3, 2, 5, 1, 5};
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		head = removeDuplicates(head);
		LinkedListUtils.print(head);
	}
}
