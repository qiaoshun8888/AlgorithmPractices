package leetcode;

import java.util.*;

public class BinaryTreePreorderTraversalNoRecursion {

	/**
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}

		return list;
	}
}
