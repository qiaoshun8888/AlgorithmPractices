package other_practices2.linkedlist;

public class ReverseLinkedList {

	/*
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL
	 * 
	 * return 5->4->3->2->1->NULL.
	 * 
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverse(ListNode head) {
		// three pointers reverse
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head, p1 = cur.next, p2 = null;
		if (p1.next != null) {
			p2 = p1.next;
		}
		while (p1 != null || p2 != null) {
			p1.next = cur;
			cur = p1;
			p1 = p2;
			if (p2 != null) {
				p2 = p2.next;
			}
		}
		head.next = null;
		return cur;
	}

	public ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// node here is the tail (also the head of the final result)
		ListNode node = reverseRecursively(head.next);
		// insert head at next's next (e.g. 1 -> 2 ==> 2 -> 1)
		head.next.next = head;
		head.next = null;
		return node;
	}

	public static void main(String[] args) {
		int[] vs = { 9, 8, 7, 6, 5 };
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
		ReverseLinkedList o = new ReverseLinkedList();
		// runner = o.reverse(head);
		runner = o.reverseRecursively(head);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
