package crackingProgrammingInterviewYouTuBe;

public class N50InsertValueIntoSortedCircularLinkedList {

	/**
	 * Insert value into sorted circular linked list
	 *
	 * Sorted circular linked list:
	 * 1. Head points to smallest value node
	 * 2. Each next node value is larger than current node except tail
	 * 3. Tail's next points to head, forming a circle
	 * 
	 * */
	
	static class Node {
		Node next;
		int v;
		public Node(int v) {
			this.v = v;
		}
	}
	
	/**
	 * -> 1  3  5  7 ->
	 * 
	 * 
	 * */
	public static void insert(Node head, Node n) {
		Node tail = null, runner = head;
		while (tail == null) {
			// Found the insertion position
			if (n.v > runner.v && n.v < runner.next.v) {
				n.next = runner.next;
				runner.next = n;
				break;
			}
			
			// Found the tail
			if (runner.next == head) {
				tail = runner;
			}
			// Advance head to the next node
			else {
				runner = runner.next;
			}
		}
		
		if (tail != null) {
			n.next = tail.next;
			tail.next = n;
		}
	}
	
	public static void print(Node head) {
		Node runner = head;
		while (true) {
			System.out.print(runner.v + " -> ");
			if (runner.next == head ) break;
			runner = runner.next;
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		Node head = new Node(1);
		Node n3 = new Node(3);
		Node n5 = new Node(5);
		Node n7 = new Node(7);
		head.next = n3;
		n3.next = n5;
		n5.next = n7;
		n7.next = head;
		
		print(head);
		
		
		Node n = new Node(-2);
		insert(head, n);
		print(head);
		
		/*
		n = new Node(8);
		insert(head, n);
		print(head);
		*/
		
		/*
		n = new Node(4);
		insert(head, n);
		print(head);
		*/
	}
}
