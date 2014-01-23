package google;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

public class CircularLinkedList {

	/**
	 * Check a linked list is a circular linked list or not.
	 * 
	 * Given a circular linked list, implement an algorithm which returns the
	 * node at the beginning of the loop.
	 * 
	 * 
	 * */
	
	public static boolean isCircularLinkedList(LinkedNode head) {
		if (head == null) return false;
		LinkedNode slowRunner = head, fastRunner = head;
		while (fastRunner.next != null && fastRunner.next.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if (slowRunner == fastRunner) return true;
		}
		return false;
	}
	
	public static LinkedNode findCircularNode(LinkedNode head) {
		if (head == null) return null;
		LinkedNode slowRunner = head, fastRunner = head;
		while (fastRunner.next != null && fastRunner.next.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if (slowRunner == fastRunner) break;
		}
		
		slowRunner = head;
		while (slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		
		return slowRunner;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 3, 4, 5, 6, 7};
		LinkedNode headC = LinkedListUtils.generateCircularLinkedList(vs, 3);
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		
		System.out.println("Is circular linked list? " + isCircularLinkedList(headC));
		LinkedListUtils.print(headC);
		System.out.println("Circular Node is: " + findCircularNode(headC));
		
		System.out.println();
		
		System.out.println("Is circular linked list? " + isCircularLinkedList(head));
		LinkedListUtils.print(head);
	}
}
