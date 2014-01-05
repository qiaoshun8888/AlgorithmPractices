package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7},
	 * 
			    3
			   / \
			  9  20
			    /  \
			   15   7
	 * 
	 * return its bottom-up level order traversal as:
	 * 
	 *      [
			  [15,7]
			  [9,20],
			  [3],
			]
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

	static class TreeNodeWrapper {
		TreeNode node;
		int level;

		public TreeNodeWrapper(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return result;

		LinkedList<TreeNodeWrapper> queue = new LinkedList<TreeNodeWrapper>();
		Stack<TreeNodeWrapper> stack = new Stack<TreeNodeWrapper>();
		int level = -1;

		queue.push(new TreeNodeWrapper(root, 0));

		while (!queue.isEmpty()) {
			TreeNodeWrapper wrapper = queue.pop();
			stack.push(wrapper);
			if (wrapper.node.left != null) {
				queue.push(new TreeNodeWrapper(wrapper.node.left,
						wrapper.level + 1));
			}
			if (wrapper.node.right != null) {
				queue.push(new TreeNodeWrapper(wrapper.node.right,
						wrapper.level + 1));
			}
		}

		ArrayList<Integer> list = null;
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		// System.out.println("stack size: " + stack.size());

		while (!stack.isEmpty()) {
			TreeNodeWrapper wrapper = stack.pop();
			// System.out.println("wrapper level: " + wrapper.level +
			// " node val: " + wrapper.node.val);

			level = Math.max(level, wrapper.level); // get the max level

			if (!map.containsKey(wrapper.level)) {
				list = new ArrayList<Integer>();
				map.put(wrapper.level, list);
			} else {
				list = map.get(wrapper.level);
			}

			list.add(wrapper.node.val);
		}

		while (level >= 0) {
			result.add(map.get(level));
			map.remove(level);
			level--;
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		BinaryTreeLevelOrderTraversalII o = new BinaryTreeLevelOrderTraversalII();
		ArrayList<ArrayList<Integer>> result = o.levelOrderBottom(root);

		for (ArrayList<Integer> list : result) {
			for (int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
