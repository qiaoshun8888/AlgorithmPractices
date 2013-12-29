package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

public class N40TraverseBSTNoRecursion {

	/**
	 * Inorder and preorder Traversal of Binary Tree without using recursion.
	 * 
	 * */

	private static int calledTimes = 0;

	static class Node {
		Node left, right;
		int v;

		public Node(int v) {
			this.v = v;
		}
	}

	public static void preorderR(Node root) {
		if (root != null) {
			System.out.print(root.v + " ");
			preorderR(root.left);
			preorderR(root.right);
		}
	}

	public static void inorderR(Node root) {
		calledTimes++;
		if (root != null) {
			inorderR(root.left);
			System.out.print(root.v + " ");
			inorderR(root.right);
		}
	}

	public static void postorderR(Node root) {
		if (root != null) {
			postorderR(root.left);
			postorderR(root.right);
			System.out.print(root.v + " ");
		}
	}

	public static void inorder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while (root != null || !stack.isEmpty()) {
			calledTimes++;
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.v + " ");
				root = root.right;
			}
		}
	}

	public static void preorder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while (root != null || !stack.isEmpty()) {
			calledTimes++;
			if (root != null) {
				System.out.print(root.v + " ");
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				root = root.right;
			}
		}
	}

	public static void main(String[] args) {
		Node node = new Node(5);
		node.left = new Node(3);
		node.right = new Node(7);
		node.left.left = new Node(1);
		node.left.right = new Node(4);
		node.right.left = new Node(6);
		node.right.right = new Node(8);

		System.out.println("Preorder traveral: ");
		// preorderR(node);
		// System.out.println("\ncalledTimes: " + calledTimes + "\n");
		// calledTimes = 0;
		preorder(node);
		System.out.println("\ncalledTimes: " + calledTimes);
		calledTimes = 0;
		System.out.println();

		System.out.println("Inorder traveral: ");
		// inorderR(node);
		// System.out.println("\ncalledTimes: " + calledTimes + "\n");
		// calledTimes = 0;
		inorder(node);
		System.out.println("\ncalledTimes: " + calledTimes);
		System.out.println();

		System.out.println("Postorder traveral: ");
		// postorderR(node);
	}
}
