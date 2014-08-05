package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class SumRootToLeafNumbers {

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

		An example is the root-to-leaf path 1->2->3 which represents the number 123.

		Find the total sum of all root-to-leaf numbers.

		For example,

		    1
		   / \
		  2   3
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.

		Return the sum = 12 + 13 = 25.

	 */

	public int sumNumbers(TreeNode root) {
		return traverse(root, 0);
	}
	private int traverse(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}

		if (isLeaf(node)) {
			return node.val + sum * 10;
		}

		return traverse(node.left, node.val + sum * 10) + traverse(node.right, node.val + sum * 10);
	}

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		int[] vs = {1, 2, 3};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		SumRootToLeafNumbers o = new SumRootToLeafNumbers();
		System.out.println(o.sumNumbers(root));
	}
}
