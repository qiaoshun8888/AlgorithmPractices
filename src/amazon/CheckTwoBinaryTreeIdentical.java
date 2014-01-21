package amazon;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

public class CheckTwoBinaryTreeIdentical {

	/**
	 * Find whether two given binary trees are identical are not.
	 * 
	 * */

	public static boolean checkBinaryTreeIdentical(TreeNode root1,
			TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}

		return root1.val == root2.val
				&& checkBinaryTreeIdentical(root1.left, root2.left)
				&& checkBinaryTreeIdentical(root1.right, root2.right);
	}

	public static void main(String[] args) {
		int[] vs1 = { -1, 3, 5, 1, -1, 2, -1, 2 };
		int[] vs2 = { -1, 3, 5, 1, -1, 2, -1, 1 };
		TreeNode root1 = TreeUtils.generateBinaryTree(vs1);
		TreeNode root2 = TreeUtils.generateBinaryTree(vs2);
		System.out.println(checkBinaryTreeIdentical(root1, root2));
	}
}
