package google.trees;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * FindKthLargestNodeInBinarySearchTree.java
 * 
 * Description: Find kth largest node in a binary search tree
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 2, 2014
 */

public class FindKthLargestNodeInBinarySearchTree {

	// O(n)
	public static TreeNode find(TreeNode root, int k) {
		if (k <= 0)
			return null;
		return findHelper(root, k);
	}

	private static int n = 1;

	private static TreeNode findHelper(TreeNode node, int k) {
		if (node.right != null) {
			TreeNode temp = findHelper(node.right, k);
			if (temp != null)
				return temp;
			n++;
		}

		if (k == n)
			return node;

		if (node.left != null) {
			n++;
			TreeNode temp = findHelper(node.left, k);
			if (temp != null)
				return temp;
		}

		return null;
	}

	// If the node has the size of the left sub-tree and the size of the right
	// sub-tree, we can do this in average O(n)

	public static void main(String[] args) {
		int[] vs = { -1, 4, 2, 6, 1, 3, 5, 7 };
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		System.out.println(find(root, 5));
	}
}
