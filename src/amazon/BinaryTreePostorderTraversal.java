package amazon;

import java.util.*;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class BinaryTreePostorderTraversal {

	/**
	 * Postorder traverse a binary tree recursively & iteratively.
	 * 
	 * */

	public static void postorderRecursive(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null)
			postorderRecursive(root.left);
		if (root.right != null)
			postorderRecursive(root.right);
		System.out.print(root.val + " ");
	}

	public static void postorderIterative(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> leftStack = new Stack<TreeNode>();
		Stack<TreeNode> rightStack = new Stack<TreeNode>();

		if (root.left != null)
			leftStack.push(root.left);
		if (root.right != null)
			rightStack.push(root.right);

		Stack<Integer> valueStack = new Stack<Integer>();

		// traverse the left sub-tree
		postorderIterativeHelper(leftStack, valueStack);
		// print the left sub-tree
		print(valueStack);
		
		// traverse the right sub-tree
		postorderIterativeHelper(rightStack, valueStack);
		// print the left sub-tree
		print(valueStack);

		// print the root node
		System.out.println(root.val);
	}

	private static void postorderIterativeHelper(Stack<TreeNode> stack,
			Stack<Integer> valueStack) {
		// traverse right sub-tree
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			valueStack.push(node.val);
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
	}

	private static void print(Stack<Integer> valueStack) {
		// print the sub-tree
		while (!valueStack.isEmpty()) {
			System.out.print(valueStack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		int[] vs = { -1, 3, 5, 7, 1, 2, 4, 4 };
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		postorderRecursive(root);
		System.out.println();
		postorderIterative(root);
	}
}
