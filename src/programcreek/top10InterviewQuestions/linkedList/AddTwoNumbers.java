package programcreek.top10InterviewQuestions.linkedList;

public class AddTwoNumbers {

	/**
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 
	 * Output: 7 -> 0 -> 8
	 * 
	 * */
	
	static class ListNode {
		ListNode next;
		int val;
		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(0);
		ListNode runner = head;
		
		// (2 -> 4 -> 3) + (5 -> 6 -> 4)
		int carry = 0;
		while (l1 != null || l2 != null) {
			runner.next = new ListNode(0);
			runner = runner.next;
			
			int a = 0, b = 0, v = 0;
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			}
			v = a + b + carry;
			if (v >= 10) {
				v -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			runner.val = v;
		}
		
		if (carry > 0) {
			runner.next = new ListNode(carry);
		}
		
		return head.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		AddTwoNumbers o = new AddTwoNumbers();
		ListNode result = o.addTwoNumbers(l1, l2);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
