package leetcode;

import java.util.Stack;

public class VerifySemmetricTreeIteratively {

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 / \ / \ / \ / \ 5 6 7 8 8 7 6 5
	 * 
	 * 
	 * But the following is not:
	 * 
	 * 1 / \ 2 2 \ \ 3 3
	 * 
	 * 
	 * Note: Bonus points if you could solve it both recursively and
	 * iteratively.
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
	
	public boolean isSymmetricIteratively(TreeNode root) {
		if (root == null) return true;
        if (isLeaf(root)) return true;
        
        Stack<TreeNode> leftTreeStack = new Stack<TreeNode>();
        Stack<TreeNode> rightTreeStack = new Stack<TreeNode>();
        
        leftTreeStack.push(root.left);
        rightTreeStack.push(root.right);
        
        while (!leftTreeStack.isEmpty() && !rightTreeStack.isEmpty()) {
            TreeNode leftTree = leftTreeStack.pop();
            TreeNode rightTree = rightTreeStack.pop();
            
            if ((leftTree == null && rightTree != null) || (leftTree != null && rightTree == null)) {
                return false;
            }
            else if ((leftTree != null && rightTree != null)) {
                if (leftTree.val != rightTree.val) {
                    return false;
                }
                else {
                    leftTreeStack.push(leftTree.left);
                    rightTreeStack.push(rightTree.right);
                    
                    leftTreeStack.push(leftTree.right);
                    rightTreeStack.push(rightTree.left);
                }
            }
        }
        
        return true;
    }
    
	private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
