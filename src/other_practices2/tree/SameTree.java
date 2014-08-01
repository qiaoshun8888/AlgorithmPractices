package other_practices2.tree;

import java.util.Stack;

public class SameTree {

	/*
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	public boolean isSameTreeIteratively(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(p);
		stack.push(q);
		while (!stack.isEmpty()) {
			TreeNode n1 = stack.pop();
			TreeNode n2 = stack.pop();
			if (n1 == null && n2 == null)
				continue;
			if (n1 == null || n2 == null || (n1.val != n2.val))
				return false;
			stack.push(n1.left);
			stack.push(n2.left);
			stack.push(n1.right);
			stack.push(n2.right);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(4);

		TreeNode node1 = new TreeNode(2);

		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(5); // 3 -> 5

		TreeNode node2 = new TreeNode(6);

		TreeNode node5 = new TreeNode(3); // 5 - > 3
		TreeNode node6 = new TreeNode(7);

		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		TreeNode root2 = new TreeNode(4);

		root2.left = node1;
		root2.right = node2;

		SameTree o = new SameTree();
		System.out.println(o.isSameTree(root1, root2));
		System.out.println(o.isSameTreeIteratively(root1, root2));
	}
}
