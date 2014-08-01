package other_practices2.tree;


public class BinaryTreeMaximumPathSum {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		traverse(root);
		return max;
	}

	private int traverse(TreeNode node) {
		if (node == null)
			return 0;
		int left = traverse(node.left);
		int right = traverse(node.right);
		int cur = node.val;
		if (left > 0)
			cur += left;
		if (right > 0)
			cur += right;
		max = Math.max(cur, max);
		return Math.max(left, right) > 0 ? Math.max(left, right) + node.val
				: node.val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(-2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(-1);
		TreeNode node6 = new TreeNode(2);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		BinaryTreeMaximumPathSum o = new BinaryTreeMaximumPathSum();
		System.out.println(o.maxPathSum(root));
	}
}
