package other_practices2.linkedlist;

public class ReverseNodesInKGroup {

	/*
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 */
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode runner = head, pre = dummy;
		int n = 1;
		while (runner != null) {
			while (n != k) {
				// when the while loop is done, runner will be the last node of
				// a group
				runner = runner.next;
				// not enough nodes to reverse for a group
				if (runner == null)
					return dummy.next;
				// since runner move forward, we increase n to indicate the
				// runner's position in a group.
				n++;
			}
			// remember the next node of the runner, and cut the list at runner
			ListNode tmp = runner.next;
			runner.next = null;
			// move runner to the first node of the second half of the list
			runner = tmp;
			// cut all the nodes before the head of the first half of the list
			tmp = pre.next;
			pre.next = null;
			// reverse the first half of the list
			ListNode[] headTail = reverse(tmp);
			// connect head and tail of the list
			pre.next = headTail[0];
			headTail[1].next = runner;
			// move pre the end of the first half list (one node before the
			// second half list)
			pre = headTail[1];
			// reset n = 1
			n = 1;
		}
		// runner now is the last node of the last group
		return dummy.next;
	}

	private ListNode[] reverse(ListNode head) {
		ListNode p1 = head, p2 = head.next;
		p1.next = null;
		// 1 2 3 4 5
		while (p2.next != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		p2.next = p1;
		ListNode[] headTail = new ListNode[2];
		headTail[0] = p2;
		headTail[1] = head;
		return headTail;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 2;
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
		ReverseNodesInKGroup o = new ReverseNodesInKGroup();
		runner = o.reverseKGroup(head, k);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
