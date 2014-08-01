package other_practices2.tree;

public class FlattenBinaryTreeToLinkedList {

	/*
	 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
     
The flattened tree should look like:
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
*/

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int calledTimes = 0;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		calledTimes++;
		if (root.left != null) {
			TreeNode node = rightMost(root.left);
			node.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		flatten(root.left);
		if (root.right != null) {
			flatten(root.right);
		}
	}

	private TreeNode rightMost(TreeNode node) {
		calledTimes++;
		while (node.right != null)
			node = node.right;
		return node;
	}
	
	public void flattenImproved(TreeNode root) {
		flattenT(root);
	}

	private TreeNode flattenT(TreeNode node) {
		if (node == null || isLeaf(node))
			return node;
		calledTimes++;
		TreeNode n1 = flattenT(node.left);
		TreeNode n2 = flattenT(node.right);
		if (n1 != null) {
			n1.right = node.right;
		}
		if (node.left != null) {
			node.right = node.left;
		}
		node.left = null;
		return n2 != null ? n2 : n1;
	}

	private boolean isLeaf(TreeNode node) {
		calledTimes++;
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode node1 = new TreeNode(2);

		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		TreeNode node2 = new TreeNode(5);

		TreeNode node5 = new TreeNode(6);

		// root.left = node1;
		// root.right = node2;
		// node1.left = node3;
		// node1.right = node4;
		// node2.right = node5;

		root.left = node1;
		node1.left = node2;
		node2.left = node3;
		node3.left = node4;
		node4.left = node5;

		FlattenBinaryTreeToLinkedList o = new FlattenBinaryTreeToLinkedList();
		// o.flatten(root);
		o.flattenImproved(root);

		while (root != null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
		System.out.println("\ncalledTimes: " + o.calledTimes);
	}
}
