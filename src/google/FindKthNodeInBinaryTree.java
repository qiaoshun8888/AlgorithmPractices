package google;

/**
 * FindKthNodeInBinaryTree.java
 * 
 * Description: You have a binary tree where each node knows the number of nodes
 * in its sub-tree (including itself). Given a node n and an int k, write a
 * function to return the kth node in an in order traversal.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 25, 2014
 */

public class FindKthNodeInBinaryTree {

	static class TreeNode {
		int size, value;
		TreeNode left, right;
		public TreeNode(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node(" + value + ")";
		}
	}
	
	public static TreeNode find(TreeNode root, int n) {
		if (root == null) return null;
		
		if (root.right != null) {
			int left = root.size - root.right.size;
			if (left == n) return root;
			else if (left > n) return find(root.left, n);
			else return find(root.right, n - left);
		}
		
		if (root.left != null) {
			if (root.size == n) return root;
			else if (root.size > n) return find(root.left, n);
			else return null;
		}
		
		return n == 1 ? root : null;
	}
	
	public static TreeNode findNoRecursion(TreeNode root, int n) {
		if (root == null) return null;
		
		while (root != null) {
			if (root.right != null) {
				int left = root.size - root.right.size;
				if (left == n) return root;
				else if (left < n) {
					n -= left;
					root = root.right;
				}
				else root = root.left;
				continue;
			}
			if (root.left != null) {
				if (root.size == n) return root;
				else if (root.size > n) root = root.left;
				else break;
				continue;
			}
			if (n == 1) return root;
			break;
		}
		
		return null;
	}
	
	public static void printInorder(TreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root + "  ");
			printInorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.size = 7;
		
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(6);
		root.left = n1; root.right = n2;
		n1.size = 3; n2.size = 3;
		
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		n1.left = n3; n1.right = n4;
		n3.size = 1; n4.size = 1;
		
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(7);
		n2.left = n5; n2.right = n6;
		n5.size = 1; n6.size = 1;
		
		printInorder(root);
		System.out.println("\n");
		
		int [] Ns = {1,2,3,4,5,6,7};
		for (int N : Ns) {
			System.out.println("Find node " + N + ":  " + find(root, N));
			System.out.println("Find node " + N + ":  " + findNoRecursion(root, N) + "   (without recursion)");			
		}
	}
}
