package myUtils;

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
	 * {-1, 1, 2, 3, #, 4, #, 5}
	 * 
	 * 			 1
	 * 		   /  \
	 *        2    3
	 *       / \  / \
	 *      #  4 #   5
	 * */
	public static TreeNode generateBinaryTree(int [] vs) {
		if (vs.length == 0) return null;
		TreeNode root = new TreeNode(vs[1]);
		generateBinaryTreeHelper(root, vs, 1);
		return root;
	}
	private static void generateBinaryTreeHelper(TreeNode root, int [] vs, int index) {
		int left = index * 2;
		int right = left + 1;

		if (left >= vs.length) return;
		else {
			int vl = vs[left];
			root.left = vl == -1 ? null : new TreeNode(vl);			
		}
		
		if (right >= vs.length) return;
		else {
			int vr = vs[right];
			root.right = vr == -1 ? null : new TreeNode(vr);			
		}
		
		if (root.left != null) generateBinaryTreeHelper(root.left, vs, left);
		if (root.right != null) generateBinaryTreeHelper(root.right, vs, right);
	}
	
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
	
	public static void main(String [] args) {
		// Test For generateBinaryTree
		// int [] vs = {1, 2, 3, -1, 4, -1, 5};
		/*
		int [] vs = {-1, 5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, -1, 1};
		TreeNode root = generateBinaryTree(vs);
		print(root);
		*/
		
		// int[] vs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; // , 5, 6, 7, 8, 9
		
		int N = 31;
		int[] vs = new int[N];
		for (int i = 1; i <= N; i++) {
			vs[i - 1] = i;
		}
		
		TreeNode root = generateCompleteBinarySearchTree(vs);
		print(root);
	}
}