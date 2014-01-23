package myUtils;

import myUtils.datastructure.LinkedNode;

/**
	LinkedListUtils.java
	
	Description: 
		Features:
			1. Generate a LinkedList from a given array
			2. Generate a Circular LinkedList from a given array and an index.
			3. Print a LinkedList
			4. Print a Circular LinkedList
	
	@author John Qiao <qiaoshun8888@gmail.com>
	Date: Jan 22, 2014
*/

public class LinkedListUtils {

	public static LinkedNode generateLinkedNode (int [] vs) {
		if (vs == null || vs.length == 0) return null;
		LinkedNode head = new LinkedNode(vs[0]);
		LinkedNode runner = head;
		for (int i = 1; i < vs.length; i++) {
			runner.next = new LinkedNode(vs[i]);
			runner = runner.next;
		}
		return head;
	}
	
	public static LinkedNode generateCircularLinkedList (int [] vs, int index) {
		if (vs == null || vs.length == 0 || index < 0) return null;
		LinkedNode head = generateLinkedNode(vs);
		LinkedNode runner = head;
		int i = 0;
		LinkedNode circularNode = null;
		while (runner.next != null) {
			if (i++ == index) {
				circularNode = runner;
			}
			runner = runner.next;
		}
		runner.next = circularNode;
		return head;
	}
	
	public static void print(LinkedNode head) {
		if (head == null) return;
		LinkedNode circularNode = checkCircularLinkedList(head);
		if (circularNode == null) {
			printLinkedList(head);
		}
		else {
			printCircularLinkedList(head, circularNode);
			
		}
	}
	private static LinkedNode checkCircularLinkedList(LinkedNode head) {
		if (head == null) return null;
		LinkedNode slowRunner = head, fastRunner = head;
		boolean isCircularLinkedNode = false;
		while (fastRunner.next != null && fastRunner.next.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if (slowRunner == fastRunner) {
				isCircularLinkedNode = true;
				break;
			}
		}
		if (isCircularLinkedNode) {
			slowRunner = head;
			while (slowRunner != fastRunner) {
				slowRunner = slowRunner.next;
				fastRunner = fastRunner.next;
			}
			return slowRunner;
		}
		return null;
	}
	private static void printLinkedList(LinkedNode head) {
		StringBuilder sb = new StringBuilder();
		while (head.next != null) {
			sb.append(head.val + " -> ");
			head = head.next;
		}
		sb.append(head.val);
		System.out.println(sb.toString());
	}
	private static void printCircularLinkedList(LinkedNode head, LinkedNode circularNode) {
		StringBuilder sb = new StringBuilder();
		int times = 0;
		final int MAX_TIMES = 3;
		while (true) {
			sb.append(head.val);
			head = head.next;
			if (head == circularNode) {
				if (times++ != 0) {
					sb.append(")");
				}
				if (times == MAX_TIMES) {
					System.out.println(sb.toString() + " -> ... ");
					return;
				}
				else {
					sb.append(" -> ");
				}
				sb.append("(");
			}
			else {
				sb.append(" -> ");
			}
		}
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 3};
		LinkedNode head = generateLinkedNode(vs);
		print(head);
		
		LinkedNode headC = generateCircularLinkedList(vs, 1);
		print(headC);
	}
}
