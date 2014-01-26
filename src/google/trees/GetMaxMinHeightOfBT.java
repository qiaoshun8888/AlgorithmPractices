package google.trees;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 *	GetMaxMinHeightOfBT.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 24, 2014
 */

public class GetMaxMinHeightOfBT {

	private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	
	public static void getMinMaxHeight(TreeNode root) {
		getMinMaxHeightHelper(root, 1);
	}
	private static void getMinMaxHeightHelper(TreeNode node, int level) {
		if (isLeaf(node)) {
			min = Math.min(min, level);
			max = Math.max(max, level);
			return;
		}
		getMinMaxHeightHelper(node.left, level + 1);
		getMinMaxHeightHelper(node.right, level + 1);
	}
	private static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 1, 2, 3, 4, 5, -1, -1, 1, 2, 3, 4, -1, -1, -1, -1};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		getMinMaxHeight(root);
		TreeUtils.print(root);
		System.out.println();
		System.out.println("min: " + min + "  max: " + max);
	}
}
