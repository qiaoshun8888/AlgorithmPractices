package crackingProgrammingInterviewYouTuBe;

public class N38InterweaveLinkedList {

	/**
	 * Interweave a linked list with constant space and linear time.
	 * 
	 * i.e. 1 > 2 > 3 > 4 > 5 
	 * After: 1 > 5 > 2 > 4 > 3
	 * 
	 * */
	static class Node {
		Node next;
		int v;

		public Node(int v) {
			this.v = v;
		}
	}
	
	public static Node reverse(Node head) {
		if (head.next == null) return head;
		
		Node n = reverse(head.next);
		
		Node runner = n;
		while (runner.next != null) {
			runner = runner.next;
		}
		runner.next = head;
		head.next = null;
		return n;
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		Node runner = n;
		for (int i = 2; i < 11; i++) {
			runner.next = new Node(i);
			runner = runner.next;
		}

		/**
		 * Find the mid point
		 * 
		 * 1 2 3 4 5 6 7 8 9 10 
		 *         ^       ^
		 *         |       |
		 *       slow     fast
		 * 
		 * */
		Node runner_fast = n, runner_slow = n;
		while (runner_fast.next != null && runner_fast.next.next != null) {
			runner_slow = runner_slow.next;
			runner_fast = runner_fast.next.next;
		}

		// The 2nd part of the linked list
		Node part2 = runner_slow.next;
		part2 = reverse(part2);

		// Remove the tail of the 1nd part
		runner_slow.next = null;
		// The 1nd part of the linked list
		Node part1 = n;

		// Interweave two linked lists
		while (part2 != null) {
			Node temp = part1.next;
			part1.next = part2;
			part2 = part2.next;
			part1.next.next = temp;
			part1 = temp;
		}

		while (n != null) {
			System.out.print(n.v + " ");
			n = n.next;
		}
	}
}
