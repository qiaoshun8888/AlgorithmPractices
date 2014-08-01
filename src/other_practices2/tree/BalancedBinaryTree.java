package other_practices2.tree;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {

	/*
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int calledTimes = 0;
	private final Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
	
	public boolean isBalanced(TreeNode root) {
		if (root == null || isLeaf(root))
			return true;
		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int height(TreeNode node) {
		calledTimes++;
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

	public boolean isBalancedImproved(TreeNode root) {
		if (root == null || isLeaf(root))
			return true;
		return checkHeight(root) != -1;
	}

	private int checkHeight(TreeNode node) {
		calledTimes++;
		if (node == null)
			return 0;
		int leftHeight = checkHeight(node.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(node.right);
		if (rightHeight == -1)
			return -1;
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
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

		node3.left = new TreeNode(1);
		node4.left = new TreeNode(1);

		node5.right = new TreeNode(2);
		node6.right = new TreeNode(2);
		node6.right.left = new TreeNode(2);

		BalancedBinaryTree o = new BalancedBinaryTree();
		System.out.println(o.isBalanced(root));
		System.out.println("calledTimes: " + o.calledTimes);
		o.calledTimes = 0;
		System.out.println(o.isBalancedImproved(root));
		System.out.println("calledTimes: " + o.calledTimes);
	}
}
