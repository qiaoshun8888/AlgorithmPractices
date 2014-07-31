package other_practices2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/*
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * confused what "{1,#,2,3}" means?
	 */

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left != null) {
				stack.push(node.left);
			} else {
				node = stack.pop();
				result.add(node.val);
				// System.out.println(node.val + " ");
				// pop the parents
				if (!stack.isEmpty()) {
					node = stack.pop();
					result.add(node.val);
					// System.out.println(node.val + " ");
					if (node.right != null) {
						stack.push(node.right);
					}
				}
			}
		}
		return result;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		pushLeftChildren(stack, root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) {
				pushLeftChildren(stack, node.right);
			}
		}
		return result;
	}

	private void pushLeftChildren(Stack<TreeNode> stack, TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public List<Integer> inorderTraversalMorris(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		TreeNode pre = null;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				result.add(cur.val);
				cur = cur.right;
			} else {
				// Find the inorder predecessor of current.
				pre = cur.left;
				while (pre.right != null && pre.right != cur)
					pre = pre.right;
				
				// Make the current as right child of its inorder predecessor. 
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				}
				// Reverse the changes made in if part to restore the original
				// tree. i.e, fix the right child of predecessor.
				else {
					pre.right = null;
					result.add(cur.val);
					cur = cur.right;
				} // End of if condition pre.right == null
			} // End of if condition current.left == null
		} // End of while
		return result;
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

		BinaryTreeInorderTraversal o = new BinaryTreeInorderTraversal();
		List<Integer> list = o.inorderTraversal(root);
		for (int v : list) {
			System.out.print(v + " ");
		}
		System.out.println();
		list = o.inorderTraversal2(root);
		for (int v : list) {
			System.out.print(v + " ");
		}
		System.out.println();
		list = o.inorderTraversalMorris(root);
		for (int v : list) {
			System.out.print(v + " ");
		}
	}
}
