package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class ConstructBinaryTtreeFromPreorderAndInorderTraversal {

	/*
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int ps, int pe, int[] inorder,
			int is, int ie) {
		if (ie < is || pe < ps)
			return null;
		TreeNode node = new TreeNode(preorder[ps]);
		if (ps == pe && is == ie)
			return node;
		int inIndex = searchIndex(inorder, is, ie, node.val);
		int numInLeft = inIndex - ps + 1;
		node.left = build(preorder, ps + 1, pe + numInLeft, inorder, is,
				inIndex - 1);
		node.right = build(preorder, ps + numInLeft + 1, pe, inorder,
				inIndex + 1, ie);
		return node;
	}

	private int searchIndex(int[] inorder, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == target)
				return i;
		}
		return -1;
	}


	public static void main(String[] args) {
		// int[] preorder = { 4, 2, 1, 3, 6, 5, 7 };
		// int[] inorder = { 1, 2, 3, 4, 5, 6, 7 };
		int[] preorder = { 1, 2 };
		int[] inorder = { 2, 1 };
		ConstructBinaryTtreeFromPreorderAndInorderTraversal o = new ConstructBinaryTtreeFromPreorderAndInorderTraversal();
		TreeNode root = o.buildTree(preorder, inorder);
		TreeUtils.print(root);
	}
}
