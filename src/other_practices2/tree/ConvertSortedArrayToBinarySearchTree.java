package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 **/

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null) return null;
		return build(num, 0, num.length - 1);
	}
	private TreeNode build(int[] num, int left, int right) {
		if (left > right) return null;
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = build(num, left, mid - 1);
		node.right = build(num, mid + 1, right);
		return node;
	}

	public static void main(String[] args) {
		int[] vs = {1,2,3,4,5};
		ConvertSortedArrayToBinarySearchTree o = new ConvertSortedArrayToBinarySearchTree();
		TreeNode root = o.sortedArrayToBST(vs);
		TreeUtils.print(root);
	}
}
