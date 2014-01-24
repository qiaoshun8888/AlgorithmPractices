package google;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * CheckBinaryTreeIsBalance.java
 * 
 * Description: Implement a function to check if a binary tree is balanced. For
 * the purposes of this question, a balanced tree is defined to be a tree such
 * that the heights of the two subtrees of any node never differ by more than
 * one.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 23, 2014
 */

public class CheckBinaryTreeIsBalance {

	public static boolean check(TreeNode root) {
		if (root == null) return true;
		return getHeight(root) != -1;
	}
	
	private static int getHeight(TreeNode node) {
		if (node == null) return 0;
		
		int left = getHeight(node.left);
		if (left == -1) return -1;
		
		int right = getHeight(node.right);
		if (right == -1) return -1;
		
		if (Math.abs(left - right) > 1) return -1;
		
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		int [] vs = {-1,
				        1, 
				      -1, 3, 
				  -1, -1, -1, 6, 
		  -1, -1, -1, -1, -1, -1, 2, -1};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		System.out.println("Is tree a Balanced Binary Tree? " + check(root));
		TreeUtils.print(root);
		
	}
}
