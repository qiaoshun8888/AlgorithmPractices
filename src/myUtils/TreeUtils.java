package myUtils;

import myUtils.datastructure.TreeNode;

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
		if (left >= vs.length || right >= vs.length) return;
		int vl = vs[left], vr = vs[right];
		root.left = vl == -1 ? null : new TreeNode(vl);
		root.right = vr == -1 ? null : new TreeNode(vr);
		if (root.left != null) generateBinaryTreeHelper(root.left, vs, left);
		if (root.right != null) generateBinaryTreeHelper(root.right, vs, right);
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
		int [] vs = {-1, 5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, -1, 1};
		TreeNode root = generateBinaryTree(vs);
		print(root);
	}
}