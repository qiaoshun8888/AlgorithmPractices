package amazon;

import myUtils.LinkedNodeUtils;
import myUtils.datastructure.LinkedNode;

public class ReverseLinkedList {

	/**
	 * Reverse the linked list with both reverse and iterative
	 * 
	 * */
	// 1 -> 3 -> 5 -> 7
	// 7 -> 5 -> 3 -> 1
	public static LinkedNode reverseRecursively(LinkedNode head) {
		if (head.next == null) return head;
		
		LinkedNode nextNode = reverseRecursively(head.next);
		// add current node(head) to the end of the nextNode
		LinkedNode runner = nextNode;
		while (runner.next != null) {
			runner = runner.next;
		}
		
		head.next = null;
		runner.next = head;
		
		return nextNode;
	}
	
	public static LinkedNode reverseIteratively(LinkedNode head) {
		if (head == null) return null;
		LinkedNode pre = null, next = null, runner = head;
		while (true) {
			next = runner.next;
			runner.next = pre;
			pre = runner;
			if (next == null) break;
			runner = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 3, 5, 7};
		LinkedNode head = LinkedNodeUtils.generateLinkedNode(vs);
		// head = reverseRecursively(head);
		head = reverseIteratively(head);
		LinkedNodeUtils.print(head);
	}
}
