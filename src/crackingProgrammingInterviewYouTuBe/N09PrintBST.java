package crackingProgrammingInterviewYouTuBe;

import java.util.LinkedList;

public class N09PrintBST {

	/**
	 * Print all elements at a given level in the binary tree
	 * 
	 * */
	
	/**
	 * 			5
	 * 		  /   \
	 *       4     8
	 *      / \   / \
	 *     2     6    
	 * 
	 * 	Using BFS to print out the BST as: 5 4 8 2 6
	 * */
	public static void printBST(Node root, int level) {
		LinkedList<Node> list = new LinkedList<Node>();
		LinkedList<Integer> levels = new LinkedList<Integer>();
		list.add(root);
		levels.add(0);
		while (!list.isEmpty()) {
			Node n = list.remove(); // remove() / removeFirst() / pop() / poll() / pollFirst()
			int l = levels.poll();
			if (n.left != null) {
				list.add(n.left);
				levels.add(l + 1);
			}
			if (n.right != null) {
				list.add(n.right);
				levels.add(l + 1);
			}
			
			if (l == level) {
				System.out.printf("%2d", n.v);
			}
			if (l > level) break;
		}
	}
	
	public static void printBSTRecursively(Node root, int level, int cur_level) {
		if (root == null || cur_level > level) return;
		if (root.left != null) {
			printBSTRecursively(root.left, level, cur_level + 1);
		}
		if (root.right != null) {
			printBSTRecursively(root.right, level, cur_level + 1);
		}
		if (level == cur_level) {
			System.out.printf("%2d", root.v);
		}
	}
	
	static class Node {
		Node left, right;
		int v;
		
		public Node(int v) {
			this.v = v;
		}
	}
	
	public static void main(String [] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.right.left = new Node(6);
		printBST(root, 1);
		System.out.println();
		printBSTRecursively(root, 2, 0);
		System.out.println();
	}
}
