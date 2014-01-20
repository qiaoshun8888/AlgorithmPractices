package amazon;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class FindMaxDepthOfBinaryTree {

	/**
	 * Find maximum depth of a tree
	 * 
	 * */
	
	public static int depth(TreeNode root) {
		return depthHelper(root, 0);
	}
	private static int depthHelper(TreeNode root, int height) {
		if (root == null) return height;
		
		return Math.max(depthHelper(root.left, height + 1), depthHelper(root.right, height + 1));
	}
	
	public static void main(String [] args) {
		/**
		 * 		   3
		 *    	 /   \
		 *   	3     2
		 *     / \   / \
		 *    #   # #   5
		 *               \
		 *                2
		 * */
		
		int [] vs = {-1, 3, 3, 2, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, 2};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		System.out.println("Height is: " + depth(root));
	}
}
