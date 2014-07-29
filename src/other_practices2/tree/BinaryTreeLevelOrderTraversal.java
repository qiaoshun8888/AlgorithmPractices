package other_practices2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {

	/*
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
	 * return its level order traversal as: [ [3], [9,20], [15,7] ] confused
	 * what "{1,#,2,3}" means?
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> levelStack = new Stack<Integer>();
		stack.push(root);
		levelStack.push(1);
		while (!stack.isEmpty()) {
			List<Integer> list = null;
			TreeNode node = stack.pop();
			int level = levelStack.pop();
			if (level > result.size()) {
				list = new ArrayList<Integer>();
				result.add(list);
			} else {
				list = result.get(level - 1);
			}
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
				levelStack.push(level + 1);
			}
			if (node.left != null) {
				stack.push(node.left);
				levelStack.push(level + 1);
			}
		}
		return result;
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
		BinaryTreeLevelOrderTraversal o = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> list = o.levelOrder(root);
		for (List<Integer> l : list) {
			System.out.println(l);
		}
	}
}
