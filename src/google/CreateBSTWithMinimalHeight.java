package google;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 * CreateBSTWithMinimalHeight.java
 * 
 * Description: Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 23, 2014
 */

public class CreateBSTWithMinimalHeight {

	// 1 2 3 4 5 6 7
	/**
	 * 		4
	 *    /   \
	 *   2     6
	 *  / \   / \
	 * 1   3 5   7
	 * 
	 * */
	public static TreeNode createBST(int [] vs) {
		if (vs == null) return null;
		return createBSTHelper(null, vs, 0, vs.length - 1);
	}
	private static TreeNode createBSTHelper(TreeNode node, int [] vs, int left, int right) {
		int mid = left + (right - left) / 2;
		
		if (left <= right) {
			if (node == null) node = new TreeNode(vs[mid]);
			
			node.left = createBSTHelper(node.left, vs, left, mid - 1);
			node.right = createBSTHelper(node.right, vs, mid + 1, right);
			return node;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = createBST(vs);
		TreeUtils.print(root);
	}
}
