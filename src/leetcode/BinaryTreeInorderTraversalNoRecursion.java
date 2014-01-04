package leetcode;

import java.util.*;

public class BinaryTreeInorderTraversalNoRecursion {

	/**
	 * Given a binary tree, return the inorder traversal of its nodes' values.
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

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		pushNodes(stack, root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				pushNodes(stack, node.right);
			}
		}

		return list;
	}

	private void pushNodes(Stack<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
