package crackingProgrammingInterviewYouTuBe;

public class N08VerifyBinarySearchTree {

	/**
	 * Verify if a binary tree is a binary search tree (BST)
	 * 
	 * */

	/**
	 * Difference between binary tree and binary search tree: 1. binary search
	 * tree's left node less than or equal to its parent, and right node greater
	 * than its parent.
	 * */
	public static boolean verify(Node root) {
		if (root == null) return true;
		boolean left = true, right = true;
		if (root.left != null) {
			left = root.left.v <= root.v && verify(root.left);
		}
		if (root.right != null) {
			right = root.right.v > root.v && verify(root.right);
		}
		return left & right;
	}
	
	static class Node {
		Node left, right;
		int v;
		
		public Node(int v) {
			this.v = v;
		}
	}
	
	public static void main(String [] args) {
		/**
		 * 			5
		 * 		  /   \
		 *       4     8
		 *      / \   / \
		 *     2     6    
		 * 
		 * */
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.right.left = new Node(6);
		System.out.println(verify(root));
	}
}
