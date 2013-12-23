package crackingProgrammingInterviewYouTuBe;

public class N25FindMidPointOfLinkedList {

	/**
	 * Find the mid point of a linked list
	 * 
	 * */
	
	static class Node {
		Node next;
		int v;
		public Node(int v) {
			this.v = v;
		}
		
		@Override
		public String toString() {
			return "Node(" + v + ")";
		}
	}
	
	/**
	 * 1 2 3 4
	 * */
	public static Node find(Node root) {
		// Using fast-runner and slow-runner
		Node fast_runner = root, slow_runner = root;
		while (fast_runner.next != null && fast_runner.next.next != null) {
			fast_runner = fast_runner.next.next;
			slow_runner = slow_runner.next;
		}
		return slow_runner;
	}
	
	// 1 2 3 4 5 6
	public static void main(String [] args) {
		Node root = new Node(1);
		Node runner = root;
		for (int i = 0; i < 7; i++) {
			runner.next = new Node(i + 2);
			runner = runner.next;
		}
		System.out.println("Mid node is: " + find(root));;
	}
}
