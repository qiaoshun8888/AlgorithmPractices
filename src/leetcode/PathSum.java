package leetcode;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

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
	
	/**
	 * Perfect solution
	 * Author: Xin Zhou
	 * 
	 * */
	public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false; // empty case
        if (root.left == null && root.right == null) return sum == root.val; // base case
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

	
	private static boolean emptyRoot = true;
	
	public static boolean hasPathSum2(TreeNode root, int sum) {
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
		int[] vs = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, -1, 4};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		System.out.println(hasPathSum(root, 22));
	}
}
