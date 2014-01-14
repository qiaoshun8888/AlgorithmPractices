package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7}
	 * 
				3
			   / \
			  9  20
			    /  \
			   15   7
	 * 
	 * return its level order traversal as:
	 * 
		    [
			  [3],
			  [9,20],
			  [15,7]
			]
	 * 
	 * 
	 * */

	static class TreeNode {
		TreeNode left, right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	static class TreeNodeWrapper {
		TreeNode node;
		int level;

		public TreeNodeWrapper(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNodeWrapper> queue = new LinkedList<TreeNodeWrapper>();
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		queue.add(new TreeNodeWrapper(root, 0));
		while (!queue.isEmpty()) {
			TreeNodeWrapper node = queue.poll();
			ArrayList<Integer> list = null;
			if (!map.containsKey(node.level)) {
				map.put(node.level, new ArrayList<Integer>());
			}
			list = map.get(node.level);
			list.add(node.node.val);

			if (node.node.left != null) {
				queue.add(new TreeNodeWrapper(node.node.left, node.level + 1));
			}
			if (node.node.right != null) {
				queue.add(new TreeNodeWrapper(node.node.right, node.level + 1));
			}
		}

		for (int i = 0; i < map.size(); i++) {
			result.add(map.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		ArrayList<ArrayList<Integer>> result = levelOrder(root);
		for (ArrayList<Integer> list : result) {
			for (int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
