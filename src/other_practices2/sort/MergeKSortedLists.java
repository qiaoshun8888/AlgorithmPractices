package other_practices2.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. 
	 * Analyze and describe its complexity.
	 */

	public int calledTimes = 0;

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null) return null;
		return merge(lists, 0, lists.size() - 1, null);
	}

	private ListNode merge(List<ListNode> lists, int start, int end, ListNode node) {
		if (end < start) return node;
		if (end == start) return mergeTwoLists(lists.get(end), node);
		node = mergeTwoLists(mergeTwoLists(lists.get(start++), lists.get(end--)), node);
		return merge(lists, start, end, node);
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode head = new ListNode(-1);
		ListNode runner = head;

		while (l1 != null && l2 != null) {
			calledTimes++;
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
			calledTimes++;
			runner.next = l1;
			l1 = l1.next;
			runner = runner.next;
		}

		while (l2 != null) {
			calledTimes++;
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

		ListNode l3 = new ListNode(6);
		l3.next = new ListNode(13);
		l3.next.next = new ListNode(25);
		l3.next.next.next = new ListNode(28);

		ListNode l4 = new ListNode(9);
		l4.next = new ListNode(15);
		l4.next.next = new ListNode(22);
		l4.next.next.next = new ListNode(30);

		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);

		MergeKSortedLists o = new MergeKSortedLists();
		ListNode head = o.mergeKLists(lists);
		System.out.println("head: " + head);
		while (head != null) {
			System.out.print(head.val + " > ");
			head = head.next;
		}

		System.out.println("\ncallTimes: " + o.calledTimes);
	}
}
