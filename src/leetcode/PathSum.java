package leetcode;

import leetcode.BinaryTreePreorderTraversalNoRecursion.TreeNode;

public class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 * For example: Given the below binary tree and sum = 22,
	 * 
	 *  	  5
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
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private static boolean emptyRoot = true;
	
	public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            if (sum != 0) return false;
            if (emptyRoot) return false;
            return true;
        }
        else {
            sum -= root.val;
        }
        
        boolean flag = false;
        
        if (root.left != null) {
            emptyRoot = false;
            flag = hasPathSum(root.left, sum);
            if (flag) return true;
        }
        if (root.right != null) {
            emptyRoot = false;
            return hasPathSum(root.right, sum);
        }
        return root.left == null && root.right == null && sum == 0;
    }
	
	public static void main(String [] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(hasPathSum(root, 1));
	}
}
