package other_practices2.tree;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * Given a singly linked list where elements are sorted in ascending order, 
	 * convert it to a height balanced BST.
	 */

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	private static ListNode h = null;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		h = head;
		int len = length(head);
		return build(0, len - 1);
	}

	private int length(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

	private TreeNode build(int start, int end) {
		if (end < start) return null;
		int mid = start + (end - start) / 2;
		TreeNode left = build(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = build(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}

	public static void main(String[] args) {
		int[] vs = {1,2,3,4,5,6,7};
		ListNode dummy = new ListNode(-1);
		ListNode runner = dummy;
		for (int v : vs) {
			runner.next = new ListNode(v);
			runner = runner.next;
		}
		ConvertSortedListToBinarySearchTree o = new ConvertSortedListToBinarySearchTree();
		TreeNode node = o.sortedListToBST(dummy.next);
		TreeUtils.print(node);
	}
}
