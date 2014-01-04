package leetcode;

import leetcode.BinaryTreeInorderTraversalNoRecursion.TreeNode;

public class VerifySemmetricTreeRecursion {

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
	 * 
			    1
			   / \
			  2   2
			 / \ / \
			3  4 4  3
	 * 
	 * 
	 * But the following is not:

				1
			   / \
			  2   2
			   \   \
			   3    3
			   
	 *
	 * Note:
	 * Bonus points if you could solve it both recursively and iteratively.
	 * 
	 * */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean isSymmetricRecursively(TreeNode root) {
        if (root == null) return true;
        if (isLeaf(root)) return true;
        return verify(root.left, root.right);
    }
    
    private boolean verify(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        else if ((leftTree == null && rightTree != null) || (leftTree != null && rightTree == null)) return false;
        if (leftTree.val != rightTree.val) return false;
        return verify(leftTree.left, rightTree.right) && verify(leftTree.right, rightTree.left);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
