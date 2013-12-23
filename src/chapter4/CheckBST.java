package chapter4;

import chapter4.BuildBinaryTree.Node;

public class CheckBST {

	Node root;
	
	static class Node {
		Node left, right;
		int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public CheckBST() {
		root = new Node(5);
		
		root.left = new Node(2);
		root.right = new Node(7);
		
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		root.right.left = new Node(4); // 4 / 6
		root.right.right = new Node(8);
	}
	
	public static boolean check(Node root) {
		int [] array = new int[7];
		copy(root, array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] >= array[i + 1]) return false;
		}
		return true;
	}
	
	public static int index = 0;
	public static void copy(Node root, int [] array) {
		if (root == null) return;
		copy(root.left, array);
		array[index++] = root.value;
		copy(root.right, array);
	}
	
	public static int last_traversed = Integer.MIN_VALUE;
	public static boolean check2(Node root) {
		if (root == null) return true;
		
		System.out.printf("1 root.vlaue: %d  last_traversed: %d\n", root.value, last_traversed);
		if (!check2(root.left)) return false;
		
		System.out.printf("2 root.vlaue: %d  last_traversed: %d\n", root.value, last_traversed);
		if (root.value <= last_traversed) return false;
		last_traversed = root.value;
		
		if (!check2(root.right)) return false;
		// System.out.printf("3 root.vlaue: %d  last_traversed: %d\n", root.value, last_traversed);
		
		return true;
	}
	
	public static boolean checkMinMax(Node root) {
		return checkMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean checkMinMax(Node root, int min, int max) {
		if (root == null) return true;
		if (root.value <= min || root.value >= max) return false;
		if (!checkMinMax(root.left, min, root.value) || !checkMinMax(root.right, root.value, max)) {
			return false;
		}
		return true;
	}
	
	public static boolean checkMinMax2(Node node, int min, int max) {
		if (node == null) return true;
		if (node.value <= min || node.value > max) return false;
		if (!checkMinMax2(node.left, min, node.value) || checkMinMax2(node.right, node.value, max)) {
			return false;
		}
		return true;
	}
	
	/* Wrong!
	public static boolean check(Node root) {
		if (root == null || root.left == null || root.right == null) return true;
		if (root.value < root.left.value || root.value >= root.right.value) {
			return false;
		}
		return check(root.left) && check(root.right);
	}
	*/
	
	public static void main(String [] args) {
		CheckBST bst = new CheckBST();
//		System.out.println(CheckBST.check2(bst.root));
		System.out.println(CheckBST.checkMinMax(bst.root));
	}
}




