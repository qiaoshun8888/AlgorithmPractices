package google.trees;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * FindCommonAncestor.java
 * 
 * Description: Design an algorithm and write code to find the first common
 * ancestor of two nodes in a binary tree. Avoidstoring additional nodes in a
 * data structure.NOTE: This is not necessarily a binary search tree.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 26, 2014
 */

public class FindCommonAncestor {

	public static TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return null;
		if (!contains(root, p) && !contains(root, q))
			return null;
		return findHelper(root, p, q);
	}

	private static TreeNode findHelper(TreeNode node, TreeNode p, TreeNode q) {
		if (node.val == q.val || node.val == p.val)
			return node;
		boolean p_left = contains(node.left, p), q_right = contains(node.right,
				q);
		if (p_left && q_right)
			return node;
		else
			return findHelper(p_left ? node.left : node.right, p, q);
	}

	private static boolean contains(TreeNode root, TreeNode n) {
		if (root == null)
			return false;
		if (root.val == n.val)
			return true;
		return contains(root.left, n) || contains(root.right, n);
	}

	public static void main(String[] args) {
		int[] vs = { -1, 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		System.out.println(find(root, new TreeNode(4), new TreeNode(5)));
	}
}
