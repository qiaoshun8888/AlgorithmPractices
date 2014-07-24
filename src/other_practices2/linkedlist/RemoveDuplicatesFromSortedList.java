package other_practices2.linkedlist;

public class RemoveDuplicatesFromSortedList {

	/*
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode runner1 = head, runner2 = head.next;
		while (runner2 != null) {
			// 1 -> 1 -> 1 -> 2 -> 2 -> 3 -> 3
			// r1  r2
			if (runner2.val != runner1.val) {
				runner1.next = runner2;
				runner1 = runner2;
			}
			runner2 = runner2.next;
		}
		runner1.next = null;
		return head;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 1, 1, 2, 2, 3, 4, 5, 5 };
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
		RemoveDuplicatesFromSortedList o = new RemoveDuplicatesFromSortedList();
		runner = o.deleteDuplicates(head);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
