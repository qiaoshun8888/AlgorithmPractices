package other_practices2.tree;

import java.util.LinkedList;
import java.util.Queue;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class MinimumDepthOfBinaryTree {

	/**
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path from the 
	 * root node down to the nearest leaf node.
	 */

	public int minDepth(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> counts = new LinkedList<Integer>();

		nodes.add(root);
		counts.add(1);

		while (!nodes.isEmpty()) {
			TreeNode cur = nodes.poll();
			int count = counts.poll();

			if (cur.left != null) {
				nodes.add(cur.left);
				counts.add(count + 1);
			}
			if (cur.right != null) {
				nodes.add(cur.right);
				counts.add(count + 1);
			}
			if (isLeaf(cur)) {
				return count;
			}
		}
		return 0;
	}

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		int[] vs = {1,6,8,3,2,15,32,11,7,90};
		//		int[] vs = {1,2};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		MinimumDepthOfBinaryTree o = new MinimumDepthOfBinaryTree();
		System.out.println("\n=============");
		System.out.println(o.minDepth(root));
	}
}
