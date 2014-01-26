package google.linkedlists;

import java.util.Stack;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

/**
	PalindromeLinkedList.java

	Description: Implement a function to check if a linked list is a palindrome. 

	@author John Qiao <qiaoshun8888@gmail.com>
	Date: Jan 22, 2014
 */

public class PalindromeLinkedList {

	// 1 1 2 3 3 2 1 1
	public static boolean check(LinkedNode head) {
		if (head == null) return true;
		
		LinkedNode fast = head, slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(head.val);
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			stack.push(slow.val);
			fast = fast.next.next;
		}
		
		boolean odd = fast.next == null;
		
		if (!odd) slow = slow.next;
		while (!stack.isEmpty()) {
			if (stack.pop() != slow.val) return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	public static boolean checkReverse(LinkedNode head) {
		if (head == null || head.next == null) return true;
		
		LinkedNode fast = head, slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		boolean odd = fast.next == null;
		
		if (!odd) slow = slow.next;
		
		slow = reverse(slow);
		
		
		while (slow != null) {
			if (slow.val != head.val) return false;
			slow = slow.next;
			head = head.next;
		}

		return true;
	}
	private static LinkedNode reverse(LinkedNode head) {
		if (head.next == null) return head;
		
		LinkedNode temp = reverse(head.next), runner = temp;
		
		while (runner.next != null) {
			runner = runner.next;
		}
		
		runner.next = head;
		head.next = null;
		
		return temp;
	}
	
	static class Result {
		LinkedNode node;
		boolean result;
		public Result(LinkedNode node, boolean result) {
			this.node = node;
			this.result = result;
		}
	}
	public static boolean checkRecursively(LinkedNode head) {
		if (head == null || head.next == null) return true;
		
		int length = 0;
		
		LinkedNode runner = head;
		
		while (runner != null) {
			runner = runner.next;
			length++;
		}
		
		return checkRecursivelyHelper(head, length).result;
	}
	private static Result checkRecursivelyHelper(LinkedNode head, int length) {
		// 7:  0 1 2 3 2 1 0
		// 8:  0 1 2 3 3 2 1 0
		if (length == 1) return new Result(head.next, true);
		else if (length == 2) return new Result(head.next.next, head.val == head.next.val);
		
		Result result = checkRecursivelyHelper(head.next, length - 2);
		
		if (!result.result || result.node == null) {
			return result;
		}
		else {
			result.result = head.val == result.node.val;
			result.node = result.node.next;
			return result;
		}
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 1, 1, 3, 3, 1, 1, 1};
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		LinkedListUtils.print(head);
		
		System.out.println("Check by using recursion: " + checkRecursively(head));
		
		System.out.println("Check by using Stack: " + check(head));
		
		System.out.println("Check by using reverse: " + checkReverse(head));
	}
}
