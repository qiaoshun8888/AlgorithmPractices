package leetcode;

public class FlattenBinaryTreeToLinkedList {

	/**
	 * Given a binary tree, flatten it to a linked list in-place.
	 * 
	 * For example, Given
	 * 
				      1
			        /   \
			       2     5
			      / \     \
			     3   4     6
			    / \   \   /
			   7   8   9 0
	 * 
	 * 
					   1
					    \
					     2
					      \
					       3
					        \
					         4
					          \
					           5
					            \
					             6
	 * 
	 * */
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public void flatten(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) flatten(root.left);
		if (root.right != null) flatten(root.right);
		
		if (!isLeaf(root) && root.left != null) flattenHelper(root);
	}
	
	private void flattenHelper(TreeNode parent) {
		TreeNode temp = parent.right;
		parent.right = parent.left;
		parent.left = null;
		rightBottom(parent.right).right = temp;
	}
	
	private TreeNode rightBottom(TreeNode node) {
		while (node.right != null) node = node.right;
		return node;
	}
	
	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.right = new TreeNode(6);
		
		FlattenBinaryTreeToLinkedList o = new FlattenBinaryTreeToLinkedList();
		o.flatten(root);
		
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
	}
}
