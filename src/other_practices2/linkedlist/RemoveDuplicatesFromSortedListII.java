package other_practices2.linkedlist;

public class RemoveDuplicatesFromSortedListII {

	/*
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given
	 * 1->1->1->2->3, return 2->3.
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
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head, pre = dummy;
		while (cur != null) {
			boolean duplicate = false;
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
				duplicate = true;
			}
			if (duplicate) {
				cur = cur.next;
				continue;
			}
			pre.next = cur;
			pre = pre.next;
			cur = cur.next;
		}
		pre.next = null;
		return dummy.next;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 1, 1, 2, 2, 3, 4, 5 };
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
		RemoveDuplicatesFromSortedListII o = new RemoveDuplicatesFromSortedListII();
		runner = o.deleteDuplicates(head);
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}
}
