package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class ConstructBinaryTtreeFromInorderAndPostorderTraversal {

	/*
	 * Given inorder and postorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */

	private static int postIndex = -1;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null
				|| inorder.length != postorder.length)
			return null;
		postIndex = postorder.length - 1;
		return build(postorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode build(int[] postorder, int[] inorder, int inStart, int inEnd) {
		if (inEnd < inStart || postIndex < 0)
			return null;
		TreeNode node = new TreeNode(postorder[postIndex--]);
		if (inStart == inEnd)
			return node;
		int rootIndex = searchIndex(inorder, inStart, inEnd, node.val);
		node.right = build(postorder, inorder, rootIndex + 1, inEnd);
		node.left = build(postorder, inorder, inStart, rootIndex - 1);
		return node;
	}

	private int searchIndex(int[] inorder, int inStart, int inEnd, int target) {
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == target)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] postorder = { 4, 5, 2, 6, 7, 8, 3, 1 };
		ConstructBinaryTtreeFromInorderAndPostorderTraversal o = new ConstructBinaryTtreeFromInorderAndPostorderTraversal();
		TreeNode root = o.buildTree(inorder, postorder);
		TreeUtils.print(root);
	}
}
