package crackingTheCodingInterview2;

public class Ch2_BlocksInLinkedList {

	/**
	 * You are given a doubly linked list and an array of references to nodes on
	 * the linked list. How many "blocks" are there present in the linked list?
	 * 
	 * A "block" is defined as a group of nodes on the list with references
	 * directed at them and adjacent to each other.
	 * 
	 * 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
	 * 
	 * {2, 4, 5}
	 * 
	 * */

	static class Node {
		Node pre, next;
		int v;

		public Node(int v) {
			this.v = v;
		}
	}

	public static int blocks(Node head, Node[] nodes) {
		Node runner = head;
		int count = 0;
		if (nodes == null) {
			while (runner != null) {
				count++;
				runner = head.next;
			}
			return count;
		}

		int index = 0;
		boolean flag = false; // indicates nodes are continued
		while (runner != null) {

			if (!flag) {
				flag = true;
				count++;
			}

			if (index < nodes.length && runner == nodes[index]) {
				while (index < nodes.length && runner == nodes[index]) {
					runner = runner.next;
					index++;
				}
				flag = false;
			} else {
				runner = runner.next;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		node2.pre = head;
		node3.pre = node2;
		node4.pre = node3;
		node5.pre = node4;
		node6.pre = node5;

		Node[] nodes = { head, node2, node6 };

		System.out.println(blocks(head, nodes));
		
	}
}
