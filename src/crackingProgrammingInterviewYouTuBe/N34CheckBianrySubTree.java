package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

public class N34CheckBianrySubTree {

	/**
	 * Check if a binary tree is a sub-tree of another one.
	 * 
	 * e.g.
	 *      3                        1
	 *     / \   is sub-tree of     / \
	 *    4   5                    2   3
	 *                                / \
	 *                               4   5
	 * 
	 * */
	
	static class Node {
		Node left, right;
		int v;
		public Node(int v) {
			this.v = v;
		}
	}
	
	public static boolean check(Node bst1, Node bst2) {
		if (bst1 == null || bst2 == null) return true;
		
		int height1 = height(bst1, 0), height2 = height(bst2, 0);
		Stack<Node> stack = new Stack<Node>();
		// bst2 is smaller than bst1, bst2 could be sub-tree of bst1
		stack.push(height1 > height2 ? bst1 : bst2);
		Node n = null, sub_n = height1 > height2 ? bst2 : bst1;
		while (!stack.isEmpty()) {
			n = stack.pop();
			if (n.v == sub_n.v) {
				if (traverse(n, sub_n)) {
					return true;
				}
			}
			if (n.left != null) stack.push(n.left);
			if (n.right != null) stack.push(n.right);
		}
		return false;
	}
	private static boolean traverse(Node bst1, Node bst2) {
		if (bst1 == null && bst2 == null) return true;
		else if ((bst1 == null && bst2 != null) || (bst1 != null && bst2 == null)  || bst1.v != bst2.v) return false;
		return traverse(bst1.left, bst2.left) && traverse(bst1.right, bst2.right);
	}
	private static int height(Node bst, int level) {
		if (bst == null) return level;
		int level_left = height(bst.left, level) + 1, level_right = height(bst.right, level) + 1;
		return Math.max(level_left, level_right);
	}
	
	
	public static void main(String [] args) {
		/**
		 *        1
		 *      /   \
		 *     2     3
		 *          / \
		 *         4   7
		 *          \
		 *           5
		 * 
		 * */
		Node bst1 = new Node(3);
		bst1.left = new Node(2);
		bst1.right = new Node(3);
		bst1.right.left = new Node(4);
		bst1.right.right = new Node(7);
		bst1.right.left.right = new Node(5);
		
		// System.out.println(height(bst1, 0));
		
		/**
		 *           3
		 *          / \
		 *         4   7
		 *          \
		 *           5
		 * 
		 * */
		Node bst2 = new Node(3);
		bst2.left = new Node(4);
		bst2.right = new Node(7);
		bst2.left.right = new Node(5);
		
		// System.out.println(height(bst2, 0));
		
		System.out.println(check(bst1, bst2));
	}
}
