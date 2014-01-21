package amazon;

import java.util.*;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class BinaryTreeInorderTraversal {

	/**
	 * Inorder traverse a binary tree recursively & iteratively.
	 * 
	 * */
	
	public static void inorderRecursive(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) inorderRecursive(root.left);
		System.out.print(root.val + " ");
		if (root.right != null) inorderRecursive(root.right);
	}
	
	public static void inorderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		// Find the leftmost node
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				TreeNode temp = node.right;
				stack.push(temp);
				while(temp.left != null) {
					stack.push(temp.left);
					temp = temp.left;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 3, 5, 7, 1, 2, 4, 4};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		inorderRecursive(root);
		System.out.println();
		inorderIterative(root);
	}
}
