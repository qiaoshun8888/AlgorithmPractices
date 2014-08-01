package other_practices2.tree;

import java.util.Stack;



public class PopulatingNextRightPointersInEachNode {

	/*
	 * Given a binary tree
	 * 
	 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right;
	 * TreeLinkNode *next; } Populate each next pointer to point to its next
	 * right node. If there is no next right node, the next pointer should be
	 * set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. You may assume that it is a
	 * perfect binary tree (ie, all leaves are at the same level, and every
	 * parent has two children). For example, Given the following perfect binary
	 * tree, 1 / \ 2 3 / \ / \ 4 5 6 7 After calling your function, the tree
	 * should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
	 */

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		preorder(root);
	}

	private void preorder(TreeLinkNode node) {
		if (node == null || isLeaf(node))
			return;
		node.left.next = node.right;
		if (node.next != null) {
			node.right.next = node.next.left;
		}
		preorder(node.left);
		preorder(node.right);
	}

	private boolean isLeaf(TreeLinkNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node1 = new TreeLinkNode(2);
		TreeLinkNode node2 = new TreeLinkNode(3);
		TreeLinkNode node3 = new TreeLinkNode(4);
		TreeLinkNode node4 = new TreeLinkNode(5);
		TreeLinkNode node5 = new TreeLinkNode(6);
		TreeLinkNode node6 = new TreeLinkNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		PopulatingNextRightPointersInEachNode o = new PopulatingNextRightPointersInEachNode();
		o.connect(root);

		Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeLinkNode node = stack.pop();
			if (node.next != null)
				System.out.println("Node(" + node.val + "): " + node.next.val);
			else
				System.out.println("Node(" + node.val + "): " + "null");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
}
