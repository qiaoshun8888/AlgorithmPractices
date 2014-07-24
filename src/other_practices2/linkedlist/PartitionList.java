package other_practices2.linkedlist;

public class PartitionList {

	/*
	 * Given a linked list and a value x, partition it such that all nodes less
	 * than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of
	 * the two partitions.
	 * 
	 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode less = new ListNode(-1);
		ListNode greater = new ListNode(-1);
		ListNode runner = head, runner_less = less, runner_greater = greater;
		while (runner != null) {
			if (runner.val < x) {
				runner_less.next = runner;
				runner_less = runner_less.next;
			} else {
				runner_greater.next = runner;
				runner_greater = runner_greater.next;
			}
			runner = runner.next;
		}
		runner_greater.next = null;
		runner_less.next = greater.next;
		return less.next;
	}

	public static void main(String[] args) {
		int[] vs = { 9, 8, 7, 6, 5 };
		int x = 6;
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
		PartitionList o = new PartitionList();
		runner = o.partition(head, x);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
