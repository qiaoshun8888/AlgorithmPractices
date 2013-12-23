package crackingProgrammingInterviewYouTuBe;

public class N01ReverseLinkedList {

	static class Node {
		int v;
		Node next;
		public Node(int v) {
			this.v = v;
		}
	}
	
	public static Node reverse(Node head) {
		if (head == null || head.next == null) return head;
		
		Node n = reverse(head.next);
		
		Node runner = n;
		while (runner.next != null) {
			runner = runner.next;
		}
		head.next = null;
		runner.next = head;
		
		return n;
	}
	
	public static void printLinkedList(Node head) {
		Node temp = head;
		while (temp!=null) {
			System.out.print(temp.v + " -> ");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public static void main(String [] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		
		Node n = reverse(node);
		printLinkedList(n);
	}
}