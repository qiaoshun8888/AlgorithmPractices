package crackingTheCodingInterview.chapter4;

public class BinaryTreeTraversal {

	static class Node {
		Node left, right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void traversePreOrder(Node root) {
		if (root == null) return;
		System.out.print(root.value + " ");
		traversePreOrder(root.left);
		traversePreOrder(root.right);
	}
	
	public static void traverseInOrder(Node root) {
		if (root == null)
			return;
		traverseInOrder(root.left);
		System.out.print(root.value + " ");
		traverseInOrder(root.right);
	}
	
	public static void traversePostOrder(Node root) {
		if (root == null) return;
		traversePostOrder(root.left);
		traversePostOrder(root.right);
		System.out.print(root.value + " ");
	}
	

	public static Node generateMinHeightBST(int[] vs, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		Node node = new Node(vs[mid]);
		node.left = generateMinHeightBST(vs, start, mid - 1);
		node.right = generateMinHeightBST(vs, mid + 1, end);
		return node;
	}

	public static void printBinaryTree(Node root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.right, level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
			System.out.println("|-------" + root.value);

		} else {
			System.out.println(root.value);
		}
		printBinaryTree(root.left, level + 1);
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Node root = BinaryTreeTraversal.generateMinHeightBST(vs, 0, vs.length - 1);
		System.out.print("Traverse InOrder:\t");
		BinaryTreeTraversal.traverseInOrder(root);
		System.out.println();
		
		System.out.print("Traverse PreOrder:\t");
		BinaryTreeTraversal.traversePreOrder(root);
		System.out.println();
		
		System.out.print("Traverse PostOrder:\t");
		BinaryTreeTraversal.traversePostOrder(root);
		System.out.println("\n\n");

		BinaryTreeTraversal.printBinaryTree(root, 0);

	}
}
