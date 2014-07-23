package other_practices2.linkedlist;


public class AddTwoNumbers {

	/*
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, runner = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int v = carry;
			carry = 0;
			if (l1 != null) {
				v += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				v += l2.val;
				l2 = l2.next;
			}
			if (v >= 10) {
				v -= 10;
				carry = 1;
			}
			if (head == null) {
				head = new ListNode(v);
				runner = head;
			} else {
				runner.next = new ListNode(v);
				runner = runner.next;
			}
		}

		if (carry > 0) {
			runner.next = new ListNode(1);
		}

		return head;
	}

	public static void main(String[] args) {
		// int[] vs1 = { 1, 2, 3, 4 };
		// int[] vs2 = { 9, 8, 7, 6, 5 };
		int[] vs1 = { 9, 8 };
		int[] vs2 = { 1 };
		ListNode l1 = null, l2 = null, runner = null;
		for (int v : vs1) {
			if (l1 == null) {
				l1 = new ListNode(v);
				runner = l1;
			} else {
				runner.next = new ListNode(v);
				runner = runner.next;
			}
		}
		for (int v : vs2) {
			if (l2 == null) {
				l2 = new ListNode(v);
				runner = l2;
			} else {
				runner.next = new ListNode(v);
				runner = runner.next;
			}
		}

		AddTwoNumbers o = new AddTwoNumbers();
		ListNode result = o.addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
