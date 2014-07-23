package other_practices2.linkedlist;



public class ReverseLinkedListII {

	/*
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ² m ² n ² length of
	 * list.
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 *       m              n
	 *  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
	 *  ^    ^    ^    ^
	 * pre  cur   p1   p2
	 * 
	 *  1 -> 2 <- 3    4 -> 5 -> 6 -> 7
	 *  ^         ^    ^    ^
	 * pre       cur   p1   p2
	 * 
	 *  1 -> 2 <- 3 <- 4    5 -> 6 -> 7
	 *  ^              ^    ^    ^
	 * pre            cur  p1   p2
	 * 
	 *  1 -> 2 <- 3 <- 4 <- 5 -> 6 -> 7
	 *  ^                   ^    ^    ^
	 * pre                 cur  p1   p2
	 * 
	 *       m              n
	 *  1 -> 2 <- 3 <- 4 <- 5 -> 6 -> 7
	 *  ^               
	 * pre
	 *  
	 * */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head.next == null || m == n)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy, cur = head, p1 = null, p2 = null;
		// First, find pre & cur
		for (int i = 1; i < m; i++) {
			pre = cur;
			cur = cur.next;
		}
		// p1 is cur's next
		if (cur.next != null) {
			p1 = cur.next;
		}
		// p2 is p1's next
		if (p1 != null) {
			p2 = p1.next;
		}
		// point p1's next to cur
		// move forward cur, p1, p2
		for (int i = m; i < n; i++) {
			p1.next = cur;
			cur = p1;
			p1 = p2;
			if (p2 != null) {
				p2 = p2.next;
			}
		}
		// link reversed segment
		pre.next.next = p1;
		pre.next = cur;
		return dummy.next;
	}

	public static void main(String[] args) {
		int[] vs = { 9, 8, 7, 6, 5 };
		int m = 2, n = 3;
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
		ReverseLinkedListII o = new ReverseLinkedListII();
		runner = o.reverseBetween(head, m, n);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
