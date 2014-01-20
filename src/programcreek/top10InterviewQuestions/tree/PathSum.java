package programcreek.top10InterviewQuestions.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 * For example: 
	 * 
	 * Given the below binary tree and sum = 22,
	 * 
			 		  5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
	 * 
	 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * 
	 * */
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		
		sum -= root.val;
		
		if (isLeaf(root) && sum == 0) return true;
		
		boolean flag = false;
		
		if (root.left != null) {
			flag = hasPathSum(root.left, sum);
			if (flag) return true;
		}
		
		if (root.right != null) {
			return hasPathSum(root.right, sum);
		}
		
		return false;
	}
	
	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public static void main(String [] args) {
		PathSum o = new PathSum();
		
		int [] vs = {-1, 5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, -1, 1};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		
		 System.out.println(o.hasPathSum(root, 22));
	}
}
