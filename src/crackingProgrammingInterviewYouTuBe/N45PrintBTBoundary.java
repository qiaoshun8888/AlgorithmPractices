package crackingProgrammingInterviewYouTuBe;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class N45PrintBTBoundary {
	
	/**
	 * Print a full binary tree's boundary in counterclockwise order
	 * 
	 * */
	
	static class Node {
		Node left, right;
		int v;
		public Node (int v) {
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
	 * Output:  5 3 2 9 0 1 11 8 6 
	 * 
	 * */
	public static void printBinaryTree(Node root) {
		Set<Node> set = new HashSet<Node>();
		// Pre-store the left-most leaves and right-most leaves
		Node runner = root;
		while (runner.left != null) {
			set.add(runner.left);
			runner = runner.left;
		}
		runner = root;
		while (runner.right != null) {
			set.add(runner.right);
			runner = runner.right;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		print(root);
		
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			if ((set.contains(n) || isLeaf(n)) && n != root.right) {
				print(n);
				set.remove(n);
			}
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		
		print(root.right);
		
	}
	private static void print(Node n) {
		System.out.print(n.v + " ");
	}
	private static boolean isLeaf(Node n) {
		return n.left == null && n.right == null; 
	}
	
	public static void main(String [] args) {
		 Node root = new Node(5);

		 root.left = new Node(3);
		 root.left.left = new Node(2);
		 root.left.right = new Node(4);
		 root.left.right.left = new Node(9);
		 root.left.right.right = new Node(0);
		 
		 root.right = new Node(6);
		 root.right.left = new Node(7);
		 root.right.left.left = new Node(1);
		 root.right.left.left = new Node(11);
		 root.right.right = new Node(8);
		 
		 printBinaryTree(root);
	}
}
