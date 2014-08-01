package other_practices2.tree;

import java.util.Stack;

public class SymmetricTree {

	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following is not: 1 / \ 2 2 \ \ 3 3
	 * Note: Bonus points if you could solve it both recursively and
	 * iteratively.
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null || isLeaf(root))
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.right);
		stack.push(root.left);
		while (!stack.isEmpty()) {
			TreeNode left = stack.pop();
			TreeNode right = stack.pop();
			if (left == null && right == null)
				continue;
			if (left == null || right == null || left.val != right.val)
				return false;
			stack.push(right.right);
			stack.push(left.left);
			stack.push(right.left);
			stack.push(left.right);
		}
		return true;
	}

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);

		TreeNode node1 = new TreeNode(9);

		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(8);

		TreeNode node2 = new TreeNode(9);

		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(2);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		SymmetricTree o = new SymmetricTree();
		System.out.println(o.isSymmetric(root));
	}
}
