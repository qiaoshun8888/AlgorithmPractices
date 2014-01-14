package leetcode;

import java.util.*;

public class BinaryTreePostorderTraversal {
	
	/**
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * */

	/*
			    5
			  /   \
			 3     8
			/ \   / \
		   1   2 7   9
		  / \       / \
		 4   0     7   8
			
		3 2 1 0 4
		
		8 9 8 7 7
	*/
	
	static class TreeNode {
		TreeNode left, right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		Stack<TreeNode> node_stack = new Stack<TreeNode>();
		Stack<Integer> val_stack = new Stack<Integer>();

		val_stack.push(root.val);

		if (root.right != null) {
			node_stack.push(root.right);
			while (!node_stack.isEmpty()) {
				TreeNode node = node_stack.pop();
				val_stack.push(node.val);
				if (node.left != null)
					node_stack.push(node.left);
				if (node.right != null)
					node_stack.push(node.right);
			}
		}

		if (root.left != null) {
			node_stack.push(root.left);
			while (!node_stack.isEmpty()) {
				TreeNode node = node_stack.pop();
				val_stack.push(node.val);
				if (node.left != null)
					node_stack.push(node.left);
				if (node.right != null)
					node_stack.push(node.right);
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>(val_stack);
		Collections.reverse(list);
		return list;
	}
	
	public static void main(String [] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		ArrayList<Integer> list = postorderTraversal(root);
		for (int v : list) {
			System.out.print(v + " ");
		}
	}
}
