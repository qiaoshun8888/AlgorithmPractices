package other_practices2.tree;

import java.util.Stack;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class MaximumDepthOfBinaryTree {

	/**
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest 
	 * path from the root node down to the farthest leaf node.
	 */

	// Time: O(n), Space: O(lg(n))
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}

	// Time: O(n), Space: O(lg(n))
	public int maxDepthIterative(TreeNode root) {
		if (root == null) return 0;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		int maxDepth = 0;
		TreeNode pre = null;
		while (!s.isEmpty()) {
			maxDepth = Math.max(maxDepth, s.size());
			TreeNode cur = s.peek();
			// traverse down the tree
			if (pre == null || pre.left == cur || pre.right == cur) {
				if (cur.left != null) {
					s.push(cur.left);
				}else if (cur.right != null) {
					s.push(cur.right);
				} else {
					s.pop();
				}
			}
			// traverse up the tree from left
			else if (cur.left == pre) {
				if (cur.right != null) {
					s.push(cur.right);
				} else {
					s.pop();
				}
			}
			// traverse up the tree from right
			else if (cur.right == pre) {
				s.pop();
			}
			pre = cur;
		}
		return maxDepth;
	}

	public static void main(String[] args) {
		//		int[] vs = {1,6,8,3,2,15,32,11,7,90};
		int[] vs = {1};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		MaximumDepthOfBinaryTree o = new MaximumDepthOfBinaryTree();
		System.out.println("\n=============");
		System.out.println(o.maxDepth(root));
		System.out.println("\n=============");
		System.out.println(o.maxDepthIterative(root));
	}
}
