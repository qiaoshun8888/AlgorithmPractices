package crackingProgrammingInterviewYouTuBe;

public class N27RotateNodes {

	
	/**
	 * Rotate nodes in a list from front to end
	 * 
	 * Given list: 1 > 2 > 3 > 4
	 * 
	 * after rotate(2) becomes 3 > 4 > 1 > 2
	 * 
	 * */
	
	static class Node {
		Node next;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void rotate(Node root, int pos) {
		Node tail = root;
		while(tail.next != null) {
			tail = tail.next;
		}
		tail.next = root;
		Node head = null;
		for (int i = 1; i < pos - 1; i++) {
			root = root.next;
		}
		head = root.next;
		root.next = null;
		
		// print the list
		while (head != null) {
			if (head.next == null) {
				System.out.print(head.value);
			}
			else {
				System.out.print(head.value + " > ");	
			}
			head = head.next;
		}
	}
	
	public static void main(String [] args) {
		Node root = new Node(1);
		Node runner = root;
		for (int i = 0; i < 3; i++) {
			runner.next = new Node(i + 2);
			runner = runner.next;
		}
		
		runner = root;
		while(runner != null) {
			if (runner.next != null) {
				System.out.print(runner.value + " > ");
			}
			else {
				System.out.print(runner.value);
			}
			runner = runner.next;
		}
		System.out.println();
		
		rotate(root, 2);
	}
}
