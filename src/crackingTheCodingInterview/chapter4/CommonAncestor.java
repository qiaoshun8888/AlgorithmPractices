package crackingTheCodingInterview.chapter4;

public class CommonAncestor {

	static class Node {
		Node left, right, parent;
		int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
		
	/**
	 *              5
	 *            /   \
	 *           4     8
	 *          / \   / \
	 *         6   9 7   0
	 * */
	public static Node generateBinaryTree() {
		Node root = new Node(5);

		Node n1 = new Node(4);
		root.left = n1;
		n1.parent = root;
		Node n2 = new Node(6);
		n1.left = n2;
		n2.parent = n1;
		n2 = new Node(9);
		n1.right = n2;
		n2.parent = n1;

		n1 = new Node(8);
		root.right = n1;
		n1.parent = root;
		n2 = new Node(7);
		n1.left = n2;
		n2.parent = n1;
		n2 = new Node(0);
		n1.right = n2;
		n2.parent = n1;

		return root;
	}
	
	// Time: O(n)	Space: O(n)
	public static Node findNode(Node root, int value) {
		if (root == null) return null;
		/*
		if (root.left == null || root.right == null) return root;
		
		Node left_node = findNode(root.left, value);
		System.out.println(left_node.value + "  " + value);
		if (left_node != null && left_node.value == value) {
			return left_node;
		}
		
		Node right_node = findNode(root.right, value);
		if (right_node != null && right_node.value == value) return right_node;
		
		return null;
		*/
		
		System.out.println(root.value + "  " + value);
		if (root.value == value) return root;
		
		Node temp;
		temp = findNode(root.left, value);
		if (temp != null) return temp;
		temp = findNode(root.right, value);
		
		return temp;
	}
	
	public static void main(String [] args) {
		Node root = CommonAncestor.generateBinaryTree();
		Node n1 = CommonAncestor.findNode(root, 6);
		System.out.println(n1.value);
		Node n2 = CommonAncestor.findNode(root, 0);
		System.out.println(n2.value);
		
		int common_ancestor = -1;
		
		// Time: O(H^2)
		while (n1 != null && common_ancestor == -1) {
			Node runner = n2;
			while (runner != null) {
				System.out.printf("n1: %d  runner: %d\n", n1.value, runner.value);
				if (n1.value == runner.value) {
					common_ancestor = n1.value;
					System.out.println("Common ancestor is: " + common_ancestor);
					break;
				}
				runner = runner.parent;
			}
			n1 = n1.parent;
		}
	}
}
