package mitHackingAGoogleInterview;

public class BinarySearchTreeValidity {

	/**
	 * Write a function to determine whether a given binary tree of distinct
	 * integers is a valid binary search tree. Assume that each node contains a
	 * pointers to its left child, a pointer to its right child, and an integer,
	 * but not a pointer to its parent.
	 * 
	 * The original code in Hacking a google interview practice questions - person B has a bug.
	 * 
	 * line #31 & #37
	 * 
	 * */
	
	static class Node {
		Node left, right;
		int v;
		public Node(int v) {
			this.v = v;
		}
	}
	
	public static boolean verify(Node root) {
		if (root == null) return true;
		return verify(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean verify(Node n, int min, int max) {
		if (n.left != null) {
			// bug fixed n.v < n.right.v
			if (n.v < n.left.v || n.left.v < min || !verify(n.left, min, n.v)) {
				return false;
			}
		}
		if (n.right != null) {
			// bug fixed n.v >= n.right.v
			if (n.v > n.right.v || n.right.v > max || !verify(n.right, n.v, max)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args) {
		/**
		 *           5
		 *         /   \
		 *        3     7
		 *       / \   / \
		 *      1   4 6   8
		 * 
		 * */
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		
		System.out.println(verify(root));
	}
}
