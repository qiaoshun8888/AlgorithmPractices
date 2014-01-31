package google.binarysearch;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * MaxSubTree.java
 * 
 * Description: Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * Given the below binary tree,

       1
      / \
     2   3
     
     Return 6.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class MaxSubTree {

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		traverse(root);
		return max;
	}
	private int traverse(TreeNode node) {
		if (node == null) return 0;
		
		int left = traverse(node.left);
		int right = traverse(node.right);
		
		int sum = node.val;
		
		if (left > 0) sum += left;
		if (right > 0) sum += right;
		
		max = Math.max(sum, max);
		
		return Math.max(left, right) > 0 ? Math.max(left, right) + node.val : node.val;
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 1, 2, 3, -2, -3, 2, -2};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		MaxSubTree o = new MaxSubTree();
		System.out.println("Max sum: " + o.maxPathSum(root));
	}
}
