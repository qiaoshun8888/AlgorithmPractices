package crackingTheCodingInterview2;

public class Ch2_MergeKSortedDataStream {

	/**
	 * How can you merge k sorted data streams using O(1) RAM? Also, explain in
	 * detail how will you define the data stream object and its related
	 * functions/operations.
	 * 
	 * 
	 * e.g.
	 * 
	 * {
	 * 		2 -> 4 -> 8
	 * 		1 -> 5 -> 7 (*)
	 * 		3 -> 6 -> 12
	 * }
	 * 
	 * Output:
	 * 
	 * 		1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 12
	 * 
	 * */
	
	static class Node {
		Node next;
		int v;
		public Node (int v) {
			this.v = v;
		}
	}
	
	public static Node merge(Node [] nodes) {
		if (nodes == null) return null;
		// Find the linked list which has the smallest head
		Node result = new Node(Integer.MAX_VALUE);
		int N = 0;
		for (int i = 0; i < nodes.length; i++) {
			Node n = nodes[i];
			if (n.v < result.v) {
				result = n;
				N = i;
			}
		}
		
		Node runner = result.next, preRunner = result;
		while (runner != null) {
			for (int i = 0; i < nodes.length; i++) {
				if (i == N) continue;
				Node node = nodes[i];
				if (node != null) {
					if (node.v <= runner.v) {
						preRunner.next = insert(runner, nodes, i);
						runner = preRunner.next;
					}
					else if (runner.next == null) {
						nodes[i] = node.next;
						node.next = null;
						runner.next = node;
					}
				}
			}
			preRunner = runner;
			runner = runner.next;
		}
		
		return result;
	}
	
	private static Node insert(Node head, Node [] nodes, int i) {
		Node node = nodes[i];
		nodes[i] = node.next;
		node.next = head;
		return node;
	}
	
	public static void main(String [] args) {
		Node n1 = new Node(2);
		n1.next = new Node(4);
		n1.next.next = new Node(8);
		
		Node n2 = new Node(1);
		n2.next = new Node(5);
		n2.next.next = new Node(7);
		
		Node n3 = new Node(3);
		n3.next = new Node(6);
		n3.next.next = new Node(12);
		
		Node [] nodes = {
			n1, n2, n3
		};
		
		Node result = merge(nodes);
		
		while (result != null) {
			System.out.print(result.v + "->");
			result = result.next;
		}
	}
}
