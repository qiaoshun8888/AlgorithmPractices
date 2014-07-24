package other_practices2.linkedlist;

public class SwapNodesInPairs {

	/*
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// 1->2->3->4->5->6
		// 2->1->4->3->6->5
		ListNode p1 = head, p2 = head.next, next = p2.next;
		swap(p1, p2);
		head = p2;
		while (next != null && next.next != null) {
			ListNode tmp = p1;
			p2 = next.next;
			p1 = next;
			next = next.next.next;
			swap(p1, p2);
			tmp.next = p2;
		}
		return head;
	}

	private void swap(ListNode p1, ListNode p2) {
		ListNode tmp = p2.next;
		p2.next = p1;
		p1.next = tmp;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3, 4, 5, 6 };
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
		SwapNodesInPairs o = new SwapNodesInPairs();
		runner = o.swapPairs(head);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
