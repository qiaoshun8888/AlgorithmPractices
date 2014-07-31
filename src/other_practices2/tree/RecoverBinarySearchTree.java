package other_practices2.tree;

public class RecoverBinarySearchTree {

	/*
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * 
	 * Recover the tree without changing its structure.
	 * 
	 * Note: A solution using O(n) space is pretty straight forward. Could you
	 * devise a constant space solution? confused what "{1,#,2,3}" means?
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode pre = null, first = null, second = null;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		inorder(root);

		System.out.println("first: " + first.val + "\tsecond: " + second.val);
		int v = first.val;
		first.val = second.val;
		second.val = v;
	}

	private void inorder(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null)
			inorder(node.left);
		if (pre == null) {
			pre = new TreeNode(Integer.MAX_VALUE);
		} else if (pre.val > node.val) {
			if (first == null)
				first = pre;
			second = node;
		}
		pre = node;
		if (node.right != null)
			inorder(node.right);
	}

	public void recoverTreeMorris(TreeNode root) {
		TreeNode[] brokenPair = new TreeNode[2];
		TreeNode pre = null, cur = root;
		while (cur != null) {
			if (cur.left == null) {
				detect(brokenPair, pre, cur);
				pre = cur;
				cur = cur.right;
			} else {
				TreeNode node = cur.left;
				while (node.right != null && node.right != cur)
					node = node.right;
				if (node.right == null) {
					node.right = cur;
					cur = cur.left;
				} else {
					detect(brokenPair, pre, cur);
					node.right = null;
					pre = cur;
					cur = cur.right;
				}
			}
		}
		System.out.println(brokenPair[0].val + "  " + brokenPair[1].val);
		swap(brokenPair[0], brokenPair[1]);
	}

	private void detect(TreeNode[] brokenPair, TreeNode pre, TreeNode cur) {
		if (pre != null && pre.val > cur.val) {
			if (brokenPair[0] == null)
				brokenPair[0] = pre;
			brokenPair[1] = cur;
		}
	}

	private void swap(TreeNode first, TreeNode second) {
		int v = first.val;
		first.val = second.val;
		second.val = v;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);

		TreeNode node1 = new TreeNode(2);

		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(5); // 3 -> 5

		TreeNode node2 = new TreeNode(6);

		TreeNode node5 = new TreeNode(3); // 5 - > 3
		TreeNode node6 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		RecoverBinarySearchTree o = new RecoverBinarySearchTree();
		// o.recoverTree(root);
		o.recoverTreeMorris(root);
	}
}
