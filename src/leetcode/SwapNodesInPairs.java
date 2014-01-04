package leetcode;

public class SwapNodesInPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
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

	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode runner = head;
		head = runner.next;

		runner.next = head.next;
		head.next = runner;

		ListNode lastNode = runner;
		runner = runner.next;

		while (runner != null && runner.next != null) {
			swap(runner, lastNode);
			lastNode = runner;
			runner = runner.next;
		}

		return head;
	}

	// ...2->3->4... (lastNode null)
	// ...1->(2->3)->(4->5)->6 (lastNode 1)
	private void swap(ListNode node, ListNode lastNode) {
		ListNode temp = node.next;
		node.next = node.next.next;
		temp.next = node;
		lastNode.next = temp;
	}
}
