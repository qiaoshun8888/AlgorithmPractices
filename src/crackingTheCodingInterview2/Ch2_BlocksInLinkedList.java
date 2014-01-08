package crackingTheCodingInterview2;

public class Ch2_BlocksInLinkedList {

	/**
	 * You are given a doubly linked list and an array of references to nodes on
	 * the linked list. How many "blocks" are there present in the linked list?
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
	
	public static int blocks(Node head, Node [] nodes) {
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
			}
			else {
				runner = runner.next;
			}
		}
		
		return count;
	}
	
	public static void main(String [] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node [] nodes = {head.next, head.next.next.next, head.next.next.next.next};
		
		System.out.println(blocks(head, nodes));
	}
}
