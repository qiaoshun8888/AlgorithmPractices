package google.trees;

import java.util.*;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * LevelTraverseBinaryTreeAndPrintLinkedListOfEachLevel.java
 * 
 * Description: Given a binary tree, design an algorithm which creates a linked
 * list of all the nodes at each depth (e.g., if you have a tree with depth D,
 * you'll have D linked lists)
 * 
 * FOLLOW UP: Iteratively & Recursively
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 26, 2014
 */

public class LevelTraverseBinaryTreeAndPrintLinkedListOfEachLevel {

	public static List<LinkedList<TreeNode>> traversalIteratively(TreeNode root) {
		List<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> queueLevel = new LinkedList<Integer>();

		queue.offer(root);
		queueLevel.offer(1);

		Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int level = queueLevel.poll();

			LinkedList<TreeNode> temp = null;
			if (!map.containsKey(level)) {
				temp = new LinkedList<TreeNode>();
				map.put(level, temp);
			} else {
				temp = map.get(level);
			}
			temp.add(node);

			if (node.left != null) {
				queue.offer(node.left);
				queueLevel.offer(level + 1);
			}
			if (node.right != null) {
				queue.offer(node.right);
				queueLevel.offer(level + 1);
			}
		}

		int maxLevel = map.size();

		for (int i = 1; i <= maxLevel; i++) {
			result.add(map.get(i));
			map.remove(i);
		}

		return result;
	}

	public static List<LinkedList<TreeNode>> traversalIterativelyImprove(
			TreeNode root) {
		List<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
		if (root == null)
			return result;

		LinkedList<TreeNode> parents = new LinkedList<TreeNode>();

		parents.offer(root);

		while (!parents.isEmpty()) {
			result.add(parents);
			LinkedList<TreeNode> children = new LinkedList<TreeNode>();
			for (TreeNode n : parents) {
				if (n.left != null)
					children.add(n.left);
				if (n.right != null)
					children.add(n.right);
			}
			parents = children;
		}

		return result;
	}

	public static List<LinkedList<TreeNode>> traversalRecursively(TreeNode root) {
		List<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
		if (root == null)
			return result;
		Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();

		traversalRecursivelyHelper(root, 1, map);

		int maxLevel = map.size();
		for (int i = 1; i <= maxLevel; i++) {
			result.add(map.get(i));
			map.remove(i);
		}

		return result;
	}

	private static void traversalRecursivelyHelper(TreeNode node, int level,
			Map<Integer, LinkedList<TreeNode>> map) {
		LinkedList<TreeNode> temp = null;
		if (!map.containsKey(level)) {
			temp = new LinkedList<TreeNode>();
			map.put(level, temp);
		} else {
			temp = map.get(level);
		}
		temp.add(node);

		if (node.left != null) {
			traversalRecursivelyHelper(node.left, level + 1, map);
		}
		if (node.right != null) {
			traversalRecursivelyHelper(node.right, level + 1, map);
		}
	}

	public static List<LinkedList<TreeNode>> traversalRecursivelyImprove(
			TreeNode root) {
		List<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
		if (root == null)
			return result;

		traversalRecursivelyImproveHelper(root, 1, result);

		return result;
	}

	private static void traversalRecursivelyImproveHelper(TreeNode node,
			int level, List<LinkedList<TreeNode>> result) {
		LinkedList<TreeNode> temp = null;
		if (result.size() >= level) {
			temp = result.get(level - 1);
		} else {
			temp = new LinkedList<TreeNode>();
			result.add(temp);
		}

		temp.add(node);

		if (node.left != null) {
			traversalRecursivelyImproveHelper(node.left, level + 1, result);
		}
		if (node.right != null) {
			traversalRecursivelyImproveHelper(node.right, level + 1, result);
		}
	}

	public static void main(String[] args) {
		int[] vs = { -1, 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeUtils.generateBinaryTree(vs);

		System.out.println(" === Iteratively ===");
		List<LinkedList<TreeNode>> result = traversalIteratively(root);
		for (LinkedList<TreeNode> list : result) {
			System.out.println(list);
		}

		System.out.println();

		System.out.println(" === Iteratively Improve ===");
		result = traversalIterativelyImprove(root);
		for (LinkedList<TreeNode> list : result) {
			System.out.println(list);
		}

		System.out.println();

		System.out.println(" === Recursively ===");
		result = traversalRecursively(root);
		for (LinkedList<TreeNode> list : result) {
			System.out.println(list);
		}

		System.out.println();

		System.out.println(" === Recursively Improve ===");
		result = traversalRecursivelyImprove(root);
		for (LinkedList<TreeNode> list : result) {
			System.out.println(list);
		}

	}
}
