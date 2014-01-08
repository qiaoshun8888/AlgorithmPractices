package crackingTheCodingInterview2;

public class Ch4_CeilingNodeInBST {

	/**
	 * A binary search tree is given. Find the ceiling value present in the BST
	 * of a given key.
	 * 
	 * e.g.
	 * 
	 * 			 8
	 * 		  /     \
	 * 	     3       12
	 *      /  \    /  \
	 *     2    6  10  15
	 *         /
	 *        4
	 * 
	 * key - 13 => 15 
	 * key - 4 => 6 
	 * key - 8 => 10
	 * 
	 * */
	
	static class Node {
		Node left, right;
		int v;
		public Node (int v) {
			this.v = v;
		}
		
		@Override
		public String toString() {
			return "Node: " + v;
		}
	}
	
	
	private static Node largest = null;
	public static Node findCeiling(Node root, int key) {
		if (root == null) return largest;
		
		if (key >= root.v) {
			return findCeiling(root.right, key);
		}
		else {
			largest = root;
			return findCeiling(root.left, key);
		}
	}
	
	public static void main(String [] args) {
		Node root = new Node(8);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.left.right.left = new Node(4);
		root.right = new Node(12);
		root.right.left = new Node(10);
		root.right.right = new Node(15);
		
		int [] keys = {13, 4, 8, 1, 11};
		for (int key : keys) {
			System.out.println(findCeiling(root, key));			
		}
	}
}
