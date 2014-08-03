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

	private static int preIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length)
			return null;
		preIndex = 0;
		return build(preorder, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd) {
		if (inEnd < inStart)
			return null;
		TreeNode node = new TreeNode(preorder[preIndex++]);
		if (inStart == inEnd)
			return node;
		int rootIndex = searchIndex(inorder, inStart, inEnd, node.val);
		node.left = build(preorder, inorder, inStart, rootIndex - 1);
		node.right = build(preorder, inorder, rootIndex + 1, inEnd);
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
		int[] preorder = { 1, 2 ,3,4};
		int[] inorder = { 1,2,3,4};
		ConstructBinaryTtreeFromPreorderAndInorderTraversal o = new ConstructBinaryTtreeFromPreorderAndInorderTraversal();
		TreeNode root = o.buildTree(preorder, inorder);
		TreeUtils.print(root);
	}
}
