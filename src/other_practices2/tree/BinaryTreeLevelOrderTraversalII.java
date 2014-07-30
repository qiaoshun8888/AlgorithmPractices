package other_practices2.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {

	/*
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
	 * return its bottom-up level order traversal as: [ [15,7], [9,20], [3] ]
	 * confused what "{1,#,2,3}" means?
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> levelStack = new Stack<Integer>();
		nodeStack.push(root);
		levelStack.push(1);
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			int level = levelStack.pop();
			if (level > result.size()) {
				result.add(new ArrayList<Integer>());
			}
			List<Integer> list = result.get(level - 1);
			list.add(node.val);
			if (node.right != null) {
				nodeStack.push(node.right);
				levelStack.push(level + 1);
			}
			if (node.left != null) {
				nodeStack.push(node.left);
				levelStack.push(level + 1);
			}
		}
		Collections.reverse(result);
		return result;
	}

	public List<List<Integer>> levelOrderBottomRecursively(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		levelOrderBottomRecursivelyHelper(root, 1, result);
		Collections.reverse(result);
		return result;
	}

	private void levelOrderBottomRecursivelyHelper(TreeNode node, int level,
			List<List<Integer>> result) {
		if (level > result.size()) {
			result.add(new ArrayList<Integer>());
		}
		List<Integer> list = result.get(level - 1);
		list.add(node.val);
		if (node.left != null) {
			levelOrderBottomRecursivelyHelper(node.left, level + 1, result);
		}
		if (node.right != null) {
			levelOrderBottomRecursivelyHelper(node.right, level + 1, result);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		BinaryTreeLevelOrderTraversalII o = new BinaryTreeLevelOrderTraversalII();
		// List<List<Integer>> list = o.levelOrder(root);
		List<List<Integer>> list = o.levelOrderBottom(root);
		for (List<Integer> l : list) {
			System.out.println(l);
		}
		list = o.levelOrderBottomRecursively(root);
		for (List<Integer> l : list) {
			System.out.println(l);
		}
	}
}
