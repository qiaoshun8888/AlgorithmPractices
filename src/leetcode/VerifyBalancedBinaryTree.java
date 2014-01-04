package leetcode;

import java.util.*;

public class VerifyBalancedBinaryTree {

	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
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

	private Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

	public boolean isBalanced(TreeNode root) {
		if (root == null || isLeaf(root))
			return true;
		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;
		if (!map.containsKey(node)) {
			map.put(node, Math.max(height(node.left), height(node.right)) + 1);
		}
		return map.get(node);
	}

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
}
