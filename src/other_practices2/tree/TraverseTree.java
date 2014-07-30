package other_practices2.tree;

import java.util.Stack;

public class TraverseTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void preorderTraverse(TreeNode root) {
		System.out.print(root.val + " ");
		if (root.left != null)
			preorderTraverse(root.left);
		if (root.right != null)
			preorderTraverse(root.right);
	}

	public void preorderTraverseIteratively(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			// push right first so we can visit left before visiting right.
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}

	public void inorderTraverse(TreeNode root) {
		if (root.left != null)
			inorderTraverse(root.left);
		System.out.print(root.val + " ");
		if (root.right != null)
			inorderTraverse(root.right);
	}

	public void inorderTraverseIteratively(TreeNode root) {
		if (root == null)
			return;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(node.val + " ");
				node = node.right;
			}
		}
	}

	public void inorderTraverseIteratively2(TreeNode root) {
		if (root == null)
			return;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			// for a node, keep looking for its left most child.
			while (node.left != null) {
				stack.push(node.left);
				node = node.left;
			}
			// every time we do the pop(), we print its value.
			node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				stack.push(node.right);
				node = node.right;
			}
		}
	}

	public void postorderTraverse(TreeNode root) {
		if (root.left != null)
			postorderTraverse(root.left);
		if (root.right != null)
			postorderTraverse(root.right);
		System.out.print(root.val + " ");
	}

	// space: O(n)
	public void postorderTraverseIteratively(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> valueStack = new Stack<Integer>();

		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			valueStack.push(node.val);
			if (node.left != null) {
				nodeStack.push(node.left);
			}
			if (node.right != null) {
				nodeStack.push(node.right);
			}
		}

		while (!valueStack.isEmpty()) {
			System.out.print(valueStack.pop() + " ");
		}
	}

	// space: O(lg(n))
	public void postorderTraverseIterativelyImprove(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			// traverse down the tree.
			if (pre == null || pre.left == cur || pre.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				} else {
					System.out.print(cur.val + " ");
					stack.pop();
				}
			}
			// traverse up the tree from left.
			else if (cur.left == pre) {
				if (cur.right != null) {
					stack.push(cur.right);
				} else {
					System.out.print(cur.val + " ");
					stack.pop();
				}
			}
			// traverse up the tree from right.
			else if (cur.right == pre) {
				System.out.print(cur.val + " ");
				stack.pop();
			}
			pre = cur; // remember previously traversed node.
		}
	}

	public static void main(String[] args) {
		/*
		 * 3 9 20 2 8 15 7
		 */

		TreeNode root = new TreeNode(3);

		TreeNode node1 = new TreeNode(9);

		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(8);

		TreeNode node2 = new TreeNode(20);

		TreeNode node5 = new TreeNode(15);
		TreeNode node6 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		TraverseTree o = new TraverseTree();
		System.out.println("===== Preorder Traversal =====");
		o.preorderTraverse(root);
		System.out.println();
		o.preorderTraverseIteratively(root);
		System.out.println();

		System.out.println("===== Inorder Traversal =====");
		o.inorderTraverse(root);
		System.out.println();
		o.inorderTraverseIteratively(root);
		System.out.println();
		o.inorderTraverseIteratively2(root);
		System.out.println();

		System.out.println("===== Postorder Traversal =====");
		o.postorderTraverse(root);
		System.out.println();
		o.postorderTraverseIteratively(root);
		System.out.println();
		o.postorderTraverseIterativelyImprove(root);
	}
}
