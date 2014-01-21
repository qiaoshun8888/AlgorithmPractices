package amazon;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class BinarySearchTreeDigitOccurrence {

	/**
	 * Given a binary search tree whose nodes are integers, find the frequency
	 * of occurrence of each digit in the tree.
	 * 
	 * */
	
	public static int [] frequency(TreeNode root) {
		int [] digits = new int[10];
		if (root == null) return digits;
		traverseTree(root, digits);
		return digits;
	}
	private static void traverseTree(TreeNode root, int [] digits) {
		int v = root.val;
		while (v != 0) {
			int d = v % 10;
			digits[d]++;
			v /= 10;
		}
		if (root.left != null) traverseTree(root.left, digits);
		if (root.right != null) traverseTree(root.right, digits);
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, 27, 11, 141, 5, 18, 90, 368};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		int [] digits = frequency(root);
		for (int i = 0; i < digits.length; i++) {
			System.out.println(i + " - " + digits[i]);
		}
	}
}
