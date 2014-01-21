package amazon;

import java.util.*;
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
	
	public static void depthNoRecursion(TreeNode root) {
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> depthStack = new Stack<Integer>();
		
		nodeStack.push(root);
		depthStack.push(1);
		
		int maxDepth = 0, minDepth = Integer.MAX_VALUE;
		
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			int depth = depthStack.pop();
			
			if (node.right != null) {
				nodeStack.push(node.right);
				depthStack.push(depth + 1);
			}
			if (node.left != null) {
				nodeStack.push(node.left);
				depthStack.push(depth + 1);
			}
			
			if (depth > maxDepth) maxDepth = depth;
			if (node.right == null && node.left == null && depth < minDepth) minDepth = depth;
		}
		
		System.out.println("maxDepth: " + maxDepth + "\tminDepth: " + minDepth);
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
		depthNoRecursion(root);
	}
}
