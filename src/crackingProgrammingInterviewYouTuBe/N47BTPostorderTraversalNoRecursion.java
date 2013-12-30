package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

import crackingProgrammingInterviewYouTuBe.N45PrintBTBoundary.Node;

public class N47BTPostorderTraversalNoRecursion {

	/**
	 * Binary Tree Post-order Traversal without recursion (using stack)
	 * 
	 * */
	
	static class Node {
		Node left, right;
		int v;
		public Node(int v) {
			this.v = v;
		}
	}
	
	/**
	 * 			  5
	 * 		  /      \
	 *       3        6
	 *      / \      / \
	 *     2   4    7   8
	 *        / \  / \
	 *       9  0 1   11
	 * 
	 * Output:  2 9 0 4 3    1 11 7 8 6    5 
	 * 
	 * */
	public static void postOrderTraversal(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack.push(root.right);
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			stack2.push(n);

			if (n.left != null) {
				stack.push(n.left);
			}
			if (n.right != null) {
				stack.push(n.right);
			}
		}
		
		stack.push(root.left);
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			stack2.push(n);
			
			if (n.left != null) {
				stack.push(n.left);
			}
			if (n.right != null) {
				stack.push(n.right);
			}
		}
		
		while (!stack2.isEmpty()) {
			print(stack2.pop());
		}
		print(root);
	}
	private static void print(Node n) {
		System.out.print(n.v + " ");
	}
	
	public static void main(String [] args) {
		/**
		 * 			  5
		 * 		  /      \
		 *       3        6
		 *      / \      / \
		 *     2   4    7   8
		 *        / \  / \
		 *       9  0 1   11
		 * 
		 * Output:  2 9 0 4 3 1 11 7 8 6 5 
		 * 
		 * */
		Node root = new Node(5);

		 root.left = new Node(3);
		 root.left.left = new Node(2);
		 root.left.right = new Node(4);
		 root.left.right.left = new Node(9);
		 root.left.right.right = new Node(0);
		 
		 root.right = new Node(6);
		 root.right.left = new Node(7);
		 root.right.left.left = new Node(1);
		 root.right.left.right = new Node(11);
		 root.right.right = new Node(8);
		 
		 postOrderTraversal(root);
	}
}
