package google.linkedlists;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

/**
 *	ReverseLinkedList.java
 *
 *	Description: Reverse a given linked list (Iteratively, Recursively)
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 25, 2014
 */

public class ReverseLinkedList {

	public static LinkedNode reverseRecursively(LinkedNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		LinkedNode temp = reverseRecursively(head.next);
		
		LinkedNode runner = temp;
		while (runner.next != null) {
			runner = runner.next;
		}
		
		runner.next = head;
		head.next = null;
		
		return temp;
	}
	
	public static LinkedNode reverseIteratively(LinkedNode head) {
		if (head == null) return null;
		LinkedNode temp = null, currentNode = head, nextNode = head.next;
		currentNode.next = null; // erase the circle link between currentNode and nextNode
		while (nextNode != null) {
			temp = nextNode.next;
			nextNode.next = currentNode;
			currentNode = nextNode;
			nextNode = temp;
		}
		return currentNode;
	}
	
	public static void main(String[] args) {
		int [] vs = {1,2,3,4,5};
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		head = reverseRecursively(head);
		LinkedListUtils.print(head);
		
		head = reverseIteratively(head);
		LinkedListUtils.print(head);
	}
}
