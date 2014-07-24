package other_practices2.linkedlist;


public class RotateList {

	/*
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0)
			return head;
		ListNode fast = head, slow = head;
		while (n > 0) {
			fast = fast.next;
			if (fast == null)
				fast = head;
			n--;
		}
		if (fast == head)
			return head;
		// 1 2 3 4 5
		//     ^   ^
		//   slow fast
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		return newHead;
	}

	// Or we can calculate the length of the list first.

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3 };
		int n = 3;
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
		RotateList o = new RotateList();
		runner = o.rotateRight(head, n);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
