package other_practices2.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class PathSumII {

	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
	 */

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root.val);
		traverse(root, sum - root.val, stack, list);
		return list;
	}

	private void traverse(TreeNode node, int sum, Stack<Integer> stack, List<List<Integer>> list) {
		if (sum == 0 && isLeaf(node)) {
			List<Integer> l = new ArrayList<Integer>(stack);
			list.add(l);
			return;
		}
		if (node.left != null) {
			stack.push(node.left.val);
			traverse(node.left, sum - node.left.val, stack, list); 
			stack.pop();
		}
		if (node.right != null) {
			stack.push(node.right.val);
			traverse(node.right, sum - node.right.val, stack, list);
			stack.pop();
		}
	}

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		int[] vs = {5,4,8,11,-1,13,4,7,2,-1,-1,-1,-1,5,1,};
		int sum = 22;
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		PathSumII o = new PathSumII();
		List<List<Integer>> results = o.pathSum(root, sum);
		for (List<Integer> result : results) {
			System.out.println(result);
		}
	}
}
