package other_practices2.tree;

import java.util.ArrayList;
import java.util.List;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class UniqueBinarySearchTreesII {

	/*
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means?
*/

	public List<TreeNode> generateTrees(int n) {
		return recursiveGenerateTrees(1, n);
	}

	private List<TreeNode> recursiveGenerateTrees(int lower, int upper) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		// empty tree
		if (lower > upper) {
			result.add(null);
			return result;
		}
		// take each value within the range as the root, generate all possible
		// left subtrees and right subtrees, and make each combination of them.
		for (int i = lower; i <= upper; i++) {
			List<TreeNode> leftSubtrees = recursiveGenerateTrees(lower, i - 1);
			List<TreeNode> rightSubtrees = recursiveGenerateTrees(i + 1, upper);
			// make each combination of the left subtrees, the right subtrees
			// and the root.
			for (TreeNode leftSubtree : leftSubtrees) {
				for (TreeNode rightSubtree : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftSubtree;
					root.right = rightSubtree;
					result.add(root);
				}
			}
		}
		return result;
	}

	public List<TreeNode> generateTreesDPS(int n) {
		return dps(1, n);
	}

	private List<TreeNode> dps(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (end < start) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubtrees = dps(start, i - 1);
			List<TreeNode> rightSubtrees = dps(i + 1, end);
			for (TreeNode leftSubtree : leftSubtrees) {
				for (TreeNode rightSubtree : rightSubtrees) {
					TreeNode node = new TreeNode(i);
					node.left = leftSubtree;
					node.right = rightSubtree;
					list.add(node);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII o = new UniqueBinarySearchTreesII();
		List<TreeNode> result = o.generateTrees(3);
		for (TreeNode node : result) {
			TreeUtils.print(node);
			System.out.println();
		}
	}
}
