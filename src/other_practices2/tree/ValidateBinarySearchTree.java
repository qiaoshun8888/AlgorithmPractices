package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class ValidateBinarySearchTree {

	/*
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 */

	public boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean validate(TreeNode node, int min, int max) {
		if (node == null)
			return true;
		return node.val > min && node.val < max
				&& validate(node.left, min, node.val)
				&& validate(node.right, node.val, max);
	}

	public static void main(String[] args) {
		int[] vs = { 4, 2, 6, 1, 3, 5, 7 };
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		ValidateBinarySearchTree o = new ValidateBinarySearchTree();
		System.out.println(o.isValidBST(root));
	}
}
