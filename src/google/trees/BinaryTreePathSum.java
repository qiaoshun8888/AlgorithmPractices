package google.trees;

import java.util.*;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * BinaryTreePathSum.java
 * 
 * Description: You are given a binary tree in which each node contains a value.
 * Design an algorithm to print all paths which sum to a given value. The path
 * does not need to start or end at the root or a leaf.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 26, 2014
 */

public class BinaryTreePathSum {

	public static List<ArrayList<TreeNode>> findPaths(TreeNode root, int sum) {
		List<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		if (root == null) return result;
		findPathHelper(root, new ArrayList<TreeNode>(), sum, result);
		return result;
	}
	private static void findPathHelper(TreeNode node, ArrayList<TreeNode> path, int sum, List<ArrayList<TreeNode>> result) {
		if (node == null) return;
		path.add(node);
		
		// check if there is a sub-path's sum equals sum.
		ArrayList<TreeNode> tempPath = new ArrayList<TreeNode>();
		int tempSum = 0;
		for (int i = path.size() - 1; i >=0; i--) {
			tempSum += path.get(i).val;
			tempPath.add(path.get(i));
			if (tempSum == sum) {
				result.add(tempPath);
				tempPath = new ArrayList<TreeNode>(tempPath);
			}
		}

		if (node.left != null) {
			findPathHelper(node.left, new ArrayList<TreeNode>(path), sum, result);
		}
		
		if (node.right != null) {
			findPathHelper(node.right, new ArrayList<TreeNode>(path), sum, result);
		}
	}
	
	public static void main(String[] args) {
		int [] vs = {-1, -5, -7, 3, 4, 5, 7, -2, 9, 2, 1, 0, -4, -7, 7, 9, 4, 2, -5, 2};
		TreeNode root = TreeUtils.generateBinaryTree(vs);
		TreeUtils.print(root);
		System.out.println();
		
		int sum = 6;
		for (ArrayList<TreeNode> list : findPaths(root, sum)) {
			Collections.reverse(list);
			System.out.println(list);
		}
	}
}
