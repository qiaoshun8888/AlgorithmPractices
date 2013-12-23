package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.List;

public class N15FindClosestValueInBST {

	/**
	 * Find a "closest" value to a given number in a binary search tree.
	 * 
	 * */

	static class Node {
		Node left, right;
		int value;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node: " + value;
		}
	}
	
	/**
	 *                  100 
	 *                 /  \ 
	 *                50  150 
	 *               / \   / \ 
	 *              25 70 125 190
	 * 
	 * */
	public static void search(Node root, int value, Node n) {
		if (root == null)
			return;

		if (Math.abs(value - n.value) > Math.abs(value - root.value)) {
			n.value = root.value;
		}

		if (root.left != null && value < root.value) {
			search(root.left, value, n);
		} 
		else if (root.right != null && value > root.value) {
			search(root.right, value, n);
		}
	}
	
	public static void add(Node node) {
		node = new Node(200);
	}

	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(50);
		root.left.left = new Node(25);
		root.left.right = new Node(70);
		root.right = new Node(150);
		root.right.left = new Node(125);
		root.right.right = new Node(190);


		StringBuilder sb = new StringBuilder();
		int [] test_case = {77, 140, 88, 15, 120, 300};
		for (int test : test_case) {
			Node n = new Node(Integer.MAX_VALUE);
			search(root, test, n);
			sb.append("Closest value in BST to " + test + " is " + n + " \n");
		}
		System.out.println(sb);
	}
}
