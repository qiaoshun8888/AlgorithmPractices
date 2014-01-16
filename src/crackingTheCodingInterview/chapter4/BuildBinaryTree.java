package crackingTheCodingInterview.chapter4;

public class BuildBinaryTree {

	Node root;

	static class Node {
		Node left, right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public BuildBinaryTree(int value) {
		this.root = new Node(value);
	}

	public BuildBinaryTree(Node root) {
		this.root = root;
	}

	public void insert(Node node, int value) {
		if (node != null) {
			if (value > node.value) {
				if (node.right == null) {
					node.right = new Node(value);
				} else {
					insert(node.right, value);
				}
			} else {
				if (node.left == null) {
					node.left = new Node(value);
				} else {
					insert(node.left, value);
				}
			}
		}
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

	public static Node insert2(int[] vs, int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		Node n = new Node(vs[mid]);
		n.left = insert2(vs, start, mid - 1);
		n.right = insert2(vs, mid + 1, end);
		return n;
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Node root = new Node(vs[vs.length / 2]);
		BuildBinaryTree bbt = new BuildBinaryTree(root);
		for (int i = 0, j = 1; i < vs.length; i++, j = -j) {
			if (root.value == vs[i])
				continue;
			if (j == 1) {
				bbt.insert(root, vs[i / 2]);
			} else {
				bbt.insert(root, vs[vs.length - i / 2 - 1]);
			}
		}

		BuildBinaryTree.printBinaryTree(root, 0);
		System.out.println();

		Node root2 = BuildBinaryTree.insert2(vs, 0, vs.length - 1);
		BuildBinaryTree.printBinaryTree(root2, 0);
	}
}
