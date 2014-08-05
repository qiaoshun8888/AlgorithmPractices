package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;


public class BinaryTreeMaximumPathSum {

	/**
	 * Given a binary tree, find the maximum path sum.

		The path may start and end at any node in the tree.

		For example:
		Given the below binary tree,

		       1
		      / \
		     2   3
		Return 6.
	 */

	private static int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		traverse(root);
		return max;
	}

	private int traverse(TreeNode node) {
		int left = 0, right = 0, sum = node.val;
		if (node.left != null) {
			left = traverse(node.left);
		}
		if (node.right != null) {
			right = traverse(node.right);
		}
		// case 1: left + cur + right
		if (left > 0 && right > 0) {
			sum += left + right;
		}
		// case 2: left + cur
		else if (left > 0) {
			sum += left;
		}
		// case 3: right + cur
		else if (right > 0) {
			sum += right;
		}
		max = Math.max(max, sum);
		if (left < 0 && right < 0) return node.val;
		return left > right ? node.val + left : node.val + right;
	}

	public static void main(String[] args) {
		int[] vs = {8,9,-6,-1,-1,5,9};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		BinaryTreeMaximumPathSum o = new BinaryTreeMaximumPathSum();
		System.out.println("max: " + o.maxPathSum(root));
	}
}
