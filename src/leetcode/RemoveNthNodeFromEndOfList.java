package leetcode;

public class RemoveNthNodeFromEndOfList {

	/**
	 * Given a linked list, remove the nth node from the end of list and return
	 * its head.
	 * 
	 * For example,
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one
	 * pass.
	 * 
	 * */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode runner_fast = head, runner_slow = head;

		if (head == null)
			return null;

		while (n-- > 0) {
			runner_fast = runner_fast.next;
		}

		// n = 2 1 2 3 (4) 5
		while (runner_fast != null && runner_fast.next != null) {
			runner_fast = runner_fast.next;
			runner_slow = runner_slow.next;
		}

		// remove the next node of runner_slow
		if (runner_slow == head && runner_fast == null)
			return runner_slow.next;
		runner_slow.next = runner_slow.next.next;

		return head;
	}
	
	public static void main(String [] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		int n = 1;
		
		head = removeNthFromEnd(head, n);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
