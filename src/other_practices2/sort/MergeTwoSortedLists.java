package other_practices2.sort;


public class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 */

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode head = new ListNode(-1);
		ListNode runner = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				runner.next = l1;
				l1 = l1.next;
			} else {
				runner.next = l2;
				l2 = l2.next;
			}
			runner = runner.next;
		}
		while (l1 != null) {
			runner.next = l1;
			l1 = l1.next;
			runner = runner.next;
		}
		while (l2 != null) {
			runner.next = l2;
			l2 = l2.next;
			runner = runner.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(7);
		l1.next.next.next = new ListNode(9);

		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		l2.next.next.next = new ListNode(8);
		l2.next.next.next.next = new ListNode(15);

		MergeTwoSortedLists o = new MergeTwoSortedLists();
		ListNode head = o.mergeTwoLists(l1, l2);
		while (head != null) {
			System.out.print(head.val + " > ");
			head = head.next;
		}
	}
}
