package other_practices2.linkedlist;

public class RemoveNthNodeFromEndOfList {

	/*
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
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0)
			return head;
		ListNode fast = head, slow = head;
		while (n > 0) {
			fast = fast.next;
			if (fast == null)
				return head.next;
			n--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		// slow will be a node before the node we want to remove.
		// if list is: 1 - 2, n = 2; or 1, n = 1
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3 };
		int n = 2;
		ListNode head = null, runner = null;
		for (int v : vs) {
			if (head == null) {
				head = new ListNode(v);
				runner = head;
			} else {
				runner.next = new ListNode(v);
				runner = runner.next;
			}
		}
		RemoveNthNodeFromEndOfList o = new RemoveNthNodeFromEndOfList();
		runner = o.removeNthFromEnd(head, n);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
