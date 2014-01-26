package google.trees;

import java.util.*;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * CheckBinaryTreeisBinarySearchTree.java
 * 
 * Description: Implement a function to check if a binary tree is a binary
 * search tree. (Iteratively & Recursively)
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 26, 2014
 */

public class CheckBinaryTreeisBinarySearchTree {

	static class TreeNodeWrapper {
		int min, max;
		TreeNode node;
		
		public TreeNodeWrapper(int min, int max, TreeNode node) {
			this.min = min;
			this.max = max;
			this.node = node;
		}
		
		public boolean isValid() {
			return node.val > min && node.val <= max;
		}
	}
	
	public static boolean checkIteratively(TreeNode root) {
		if (root == null) return false;
		
		Queue<TreeNodeWrapper> queue = new LinkedList<TreeNodeWrapper>();
		queue.offer(new TreeNodeWrapper(Integer.MIN_VALUE, Integer.MAX_VALUE, root));
		
		while (!queue.isEmpty()) {
			TreeNodeWrapper n = queue.poll();
			if (n.node.left != null) {
				TreeNodeWrapper nl = new TreeNodeWrapper(n.min, n.node.val, n.node.left);
				if (!nl.isValid()) return false;
				queue.offer(nl);
			}
			if (n.node.right != null) {
				TreeNodeWrapper nr = new TreeNodeWrapper(n.node.val, n.max, n.node.right);
				if (!nr.isValid()) return false;
				queue.offer(nr);
			}
		}
		
		return true;
	}
	
	public static boolean checkRecursively(TreeNode root) {
		return checkRecursivelyHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean checkRecursivelyHelper(TreeNode node, int min, int max) {
		if (node == null) return true;
		if (node.val <= min || node.val > max) return false;
		if (!checkRecursivelyHelper(node.left, min, node.val) || 
			!checkRecursivelyHelper(node.right, node.val, max)) return false;
		return true;
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 4, 2, 6, 1, 3, 5, 7};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		System.out.println();
		System.out.println(checkIteratively(root));
		System.out.println(checkRecursively(root));
	}
}
