package other_practices2.tree;

import java.util.Stack;

public class PopulatingNextRightPointersInEachNodeII {

	/*
	 * Follow up for problem "Populating Next Right Pointers in Each Node".
	 * 
	 * What if the given tree could be any binary tree? Would your previous
	 * solution still work?
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. For example, Given the following
	 * binary tree, 1 / \ 2 3 / \ \ 4 5 7 After calling your function, the tree
	 * should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \ \ 4-> 5 -> 7 -> NULL
	 */

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null || isLeaf(root))
			return;
		TreeLinkNode runner = root;
		while (runner != null) {
			runner = linkNext(runner);
		}
	}

	private boolean isLeaf(TreeLinkNode node) {
		return node.left == null && node.right == null;
	}

	private TreeLinkNode linkNext(TreeLinkNode node) {
		// link children first
		TreeLinkNode p = null, next = null;
		while (node != null) {
			if (next == null) {
				next = node.left != null ? node.left : node.right;
			}
			if (node.left != null) {
				if (p == null) {
					p = node.left;
				} else {
					p.next = node.left;
					p = p.next;
				}
			}
			if (node.right != null) {
				if (p == null) {
					p = node.right;
				} else {
					p.next = node.right;
					p = p.next;
				}
			}
			node = node.next;
		}
		return next;
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node1 = new TreeLinkNode(2);
		TreeLinkNode node2 = new TreeLinkNode(3);
		TreeLinkNode node3 = new TreeLinkNode(4);
		TreeLinkNode node4 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node6;

		PopulatingNextRightPointersInEachNodeII o = new PopulatingNextRightPointersInEachNodeII();
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
