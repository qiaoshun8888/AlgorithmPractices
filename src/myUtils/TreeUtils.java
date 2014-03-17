package myUtils;

import java.util.Arrays;

import myUtils.datastructure.TreeNode;

/**
	TreeUtils.java
	
	Description: 
		Features:
			1. Generate a Binary Tree from a given array
			2. Print Binary Tree graph
	
	@author John Qiao <qiaoshun8888@gmail.com>
	Date: Jan 22, 2014
*/

public class TreeUtils {

	/**
	 * Generate a binary tree based on the given array. 
	 * (!important: using '-1' to indicate null node)
	 * 
	 * @param int[] vs: an integer array
	 * 
	 * 
	 * {0, 1, 2, 3, -1, 4, -1}
	 * 
	 * 			 0
	 * 		   /  \
	 *        1    2
	 *       / \  / \
	 *      3  # 4   #
	 * */
	public static TreeNode generateBinaryTree(int[] vs) {
		if (vs == null || vs.length == 0) return null;
		TreeNode root = new TreeNode(vs[0]);
		generateBinaryTreeHelper(root, vs, 0);
		return root;
	}
	private static void generateBinaryTreeHelper(TreeNode root, int [] vs, int index) {
		int left = index * 2 + 1;
		int right = left + 1;

		if (left >= vs.length) return;
		else {
			int vl = vs[left];
			if (vl == -1) {
				root.left = null;
			}
			else {
				root.left = new TreeNode(vl);
				root.left.parent = root;
			}
		}
		
		if (right >= vs.length) return;
		else {
			int vr = vs[right];
			if (vr == -1) {
				root.right = null;
			}
			else {
				root.right = new TreeNode(vr);
				root.right.parent = root;
			}
		}
		
		if (root.left != null) generateBinaryTreeHelper(root.left, vs, left);
		if (root.right != null) generateBinaryTreeHelper(root.right, vs, right);
	}
	
	/**
	 * Generate a balanced binary search tree based on the given array. 
	 * (!important: using '-1' to indicate null node)
	 * 
	 * @param int[] vs: an integer array
	 * 
	 * {4, 5, 5, 7, 2, 1, 3}
	 * 
	 * 			 4
	 * 		   /  \
	 *        2    5
	 *       / \  / \
	 *      1  3 5   7
	 * */
	public static TreeNode generateBinarySearchTree(int[] vs) {
		if (vs == null || vs.length == 0) return null;
		Arrays.sort(vs);
		TreeNode root = generateBinarySearchTreeHelper(vs, 0, vs.length - 1);
		return root;
	}
	private static TreeNode generateBinarySearchTreeHelper(int[] vs, int left, int right) {
		if (left > right) return null;
		int mid = left + (right - left) / 2;
		if (vs[mid] != -1) {
			TreeNode node = new TreeNode(vs[mid]);
			node.left = generateBinarySearchTreeHelper(vs, left, mid - 1);
			if (node.left != null) node.left.parent = node;
			node.right = generateBinarySearchTreeHelper(vs, mid + 1, right);
			if (node.right != null) node.right.parent = node;
			return node;
		}
		return null;
	}
	
	/**
	 * Generate a not balanced binary search tree based on the given array. 
	 * 
	 * @param int[] vs: an integer array
	 * 
	 * {3, 5, 5, 7, 4, 1, 2}
	 * 
	 * 			 3
	 * 		   /   \
	 *        1     5
	 *         \   / \
	 *          2 5   7
	 *           /
	 *          4
	 * */
	public static TreeNode generateBinarySearchTreeNotBalanced(int[] vs) {
		if (vs == null || vs.length == 0) return null;
		TreeNode root = new TreeNode(vs[0]);
		for (int i = 1; i < vs.length; i++) {
			TreeNode runner = root;
			int val = vs[i];
			while (true) {
				if (val <= runner.val) {
					if (runner.left == null) {
						runner.left = new TreeNode(val);
						runner.left.parent = runner;
						break;
					}
					else {
						runner = runner.left;
					}
				}
				else {
					if (runner.right == null) {
						runner.right = new TreeNode(val);
						runner.right.parent = runner;
						break;
					}
					else {
						runner = runner.right;
					}
				}
			}
		}
		return root;
	}
	
	/**
	 * Generate a complete binary search tree based on the given array. Array is already sorted 
	 * 
	 * @param int[] vs: an integer array
	 * 
	 * {1, 2, 3, 4, 5}
	 * 
	 * 			 4
	 * 		   /   \
	 *        2     5
	 *       / \
	 *      1   3 
	 * */
	public static TreeNode generateCompleteBinarySearchTree(int[] vs) {
		if (vs == null || vs.length == 0) return null;
		return generateCompleteBinarySearchTreeHelper(vs, 0, vs.length - 1);
	}
	private static TreeNode generateCompleteBinarySearchTreeHelper(int[] vs, int left, int right) {
		if (left > right) return null;
		if (left == right) return new TreeNode(vs[left]);
		if (left + 1 == right) {
			TreeNode node = new TreeNode(vs[right]);
			node.left = new TreeNode(vs[left]);
			return node;
		}
		int i = getRootIndex(left, right);
		TreeNode node = new TreeNode(vs[i]);
		if (left < right) {
			node.left = generateCompleteBinarySearchTreeHelper(vs, left, i - 1);
			node.right = generateCompleteBinarySearchTreeHelper(vs, i + 1, right);
		}
		return node;
	}
	private static int getRootIndex(int left, int right) {
		left++;right++;
		int n = right - left + 1;
		int h_left = (int) Math.floor(log2(n));
		int h_right = (h_left - 1) == 0 ? 1 : (h_left - 1);
		// case 1 - right last level empty
		if (n <= 1 + Math.pow(2, h_left) - 1 + Math.pow(2, h_right) - 1) {
			return (right - 1) - ((int)Math.pow(2, h_right) - 1);			
		}
		else {
			return (left - 1) + ((int)Math.pow(2, h_left) - 1);
		}
	}
	private static double log2(double v) {
		return Math.log(v) / Math.log(2);
	}
	
	/**
	 * Print a binary tree
	 * */
	public static void print(TreeNode root) {
		print(root, 0);
	}
	public static void print(TreeNode root, int level) {
		if (root == null)
			return;
		print(root.right, level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
			System.out.println("|-------" + root.val);

		} else {
			System.out.println(root.val);
		}
		print(root.left, level + 1);
	}
}