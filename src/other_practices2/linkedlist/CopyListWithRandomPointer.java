package other_practices2.linkedlist;

public class CopyListWithRandomPointer {

	/*
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 */

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		// copy every node and put them next to each node in the original list
		RandomListNode runner = head;
		// 1 > 2 > 3 > 4
		while (runner != null) {
			RandomListNode newNode = new RandomListNode(runner.label);
			RandomListNode tmp = runner.next;
			runner.next = newNode;
			newNode.next = tmp;
			runner = tmp;
		}
		// 1 > 1 > 2 > 2 > 3 > 3 > 4 > 4
		runner = head;
		while (runner != null) {
			if (runner.random != null) {
				RandomListNode runnerCopy = runner.next;
				runnerCopy.random = runner.random.next;
			}
			runner = runner.next.next;
		}
		// separate the copies to another linked list.
		RandomListNode newHead = head.next;
		runner = newHead;
		while (runner.next != null) {
			head.next = head.next.next;
			head = head.next;
			runner.next = runner.next.next;
			runner = runner.next;
		}
		head.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n1.random = n3;
		n2.random = n4;
		CopyListWithRandomPointer o = new CopyListWithRandomPointer();
		RandomListNode l = o.copyRandomList(n1);
		System.out.println("==== original list ====");
		while (n1 != null) {
			if (n1.random != null)
				System.out.print(n1.label + "(" + n1.random.label + ")  ");
			else
				System.out.print(n1.label + "()  ");
			n1 = n1.next;
		}
		System.out.println("\n==== copied list ====");
		while (l != null) {
			if (l.random != null)
				System.out.print(l.label + "(" + l.random.label + ")  ");
			else
				System.out.print(l.label + "()  ");
			l = l.next;
		}
	}
}
