package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * CreateLinkedListOfBT.java
 * 
 * Description: Given a binary tree, design an algorithm which creates a linked
 * list of all the nodes at each depth (e.g., if you have a tree with depth D,
 * you'll have D linked lists).
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 24, 2014
 */

public class CreateLinkedListOfBT {

	public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		if (root == null) return result;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		q.add(root);
		level.offer(1); // add
		
		Map<Integer, LinkedList<TreeNode>> map = new HashMap<Integer, LinkedList<TreeNode>>();
		
		int maxDepth = 0;
		
		while (!q.isEmpty()) {
			TreeNode node = q.poll(); // remove
			int depth = level.poll();
			
			maxDepth = Math.max(depth, maxDepth);
			
			addToMap(node, depth, map);
			
			if (node.left != null) {
				q.offer(node.left);
				level.offer(depth + 1);
			}
			if (node.right != null) {
				q.offer(node.right);
				level.offer(depth + 1);
			}
		}
		
		for (int i = 1; i <= maxDepth; i++) {
			result.add(map.get(i));
		}
		
		return result;
	}
	private static void addToMap(TreeNode node, int level, Map<Integer, LinkedList<TreeNode>> map) {
		LinkedList<TreeNode> list = null;
		if (map.containsKey(level)) {
			list = map.get(level);
		}
		else {
			list = new LinkedList<TreeNode>();
			map.put(level, list);
		}
		list.add(node);
	}
	
	// BFS Improved Method
	public static ArrayList<LinkedList<TreeNode>> createLinkedListImproved(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		if (root == null) return result;
		
		LinkedList<TreeNode> link = new LinkedList<TreeNode>();
		link.add(root);
		
		while(!link.isEmpty()) {
			result.add(link);
			LinkedList<TreeNode> parents = link;
			link = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null) link.add(parent.left);
				if (parent.right != null) link.add(parent.right);
			}
		}
		
		return result;
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedListRecursively(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		createLinkedListRecursivelyHelper(root, 1, result);
		
		return result;
	}
	private static void createLinkedListRecursivelyHelper(TreeNode node, int level, ArrayList<LinkedList<TreeNode>> result) {
		if (node == null) return;
		
		LinkedList<TreeNode> list = null;
		if (level > result.size()) {
			list = new LinkedList<TreeNode>();
			result.add(list);
		}
		else {
			list = result.get(level - 1);
		}
		
		list.add(node);
		
		if (node.left != null) {
			createLinkedListRecursivelyHelper(node.left, level + 1, result);
		}
		
		if (node.right != null) {
			createLinkedListRecursivelyHelper(node.right, level + 1, result);
		}
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 1, 2, 3, 4, 5, 6, 7};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		
		TreeUtils.print(root);
		
		System.out.println();
		System.out.println("=== Iteratively (BFS) ===");
		ArrayList<LinkedList<TreeNode>> result = createLinkedList(root);
		for (LinkedList<TreeNode> list : result) {
			for (TreeNode node : list) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("=== Iteratively (BFS Improved) ===");
		result = createLinkedListImproved(root);
		for (LinkedList<TreeNode> list : result) {
			for (TreeNode node : list) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("=== Recursively (Pre-order) ===");
		result = createLinkedListRecursively(root);
		for (LinkedList<TreeNode> list : result) {
			for (TreeNode node : list) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}
}
