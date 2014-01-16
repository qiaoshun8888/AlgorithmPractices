package crackingTheCodingInterview.chapter4;

public class BinaryTree {
	
	public static void main(String [] args) {
		new BinaryTree().run();
	}
	
	public void run() {
		Node root = new Node(5);
		System.out.println("Binary Tree example");
		System.out.println("Building tree with root value " + root.value);
		
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
//		insert(root, 3);
		insert(root, 9);
		insert(root, 7);
		insert(root, 2);
		insert(root, 0);
//		insert(root, 11);
//		insert(root, 13);
//		insert(root, 18);
		
		System.out.println("Traversing binary tree in order");
		printInOrder(root);
		System.out.println();
		System.out.println("Traversing binary tree front-to-back from location 7");
		printFrontToBack(root, 7);
		
		System.out.println();
		System.out.println("The height of the tree is " + height(root));
		
		System.out.println();
		System.out.println("Is the tree balanced? " + (isBalanced(root) ? "YES" : "NO"));
		System.out.println("Is the tree balanced? " + (isBalancedImproved(root) ? "YES" : "NO"));
		System.out.println();
		
		printBinaryTree(root, 0);
	}
	
	static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int v) {
			this.value = v;
		}
	}
	
	public void insert(Node node, int value) {
		// Insert the value on the left side of the node
		if (value <= node.value) {
			if (node.left != null) {
				insert(node.left, value);
			}
			else {
				node.left = new Node(value);
			}			
		}
		// Insert the value on the right side of the node
		else {
			if (node.right != null) {
				insert(node.right, value);
			}
			else {
				node.right = new Node(value);
			}
		}
	}
	
	public int height(Node node) {
		if (node == null) return 0; // base case
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	// Time: O(n^2)
	public boolean isBalanced(Node node) {
		if (node == null) return true;
		
		int height_diff = height(node.left) - height(node.right);
		if (Math.abs(height_diff) > 1) {
			return false;
		}
		else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}
	
	// Time: O(n)	Space: O(h)
	public boolean isBalancedImproved(Node node) {
		return checkHeight(node) != -1;
	}
	
	private int checkHeight(Node node) {
		if (node == null) return 0;
		
		int left_height = checkHeight(node.left), right_height = checkHeight(node.right);
		System.out.printf("left_height: %d  right_height: %d\n", left_height, right_height);
		if (left_height == -1 || right_height == -1) return -1;
		
		int height_diff = Math.abs(left_height - right_height);
		if (height_diff > 1) {
			return -1;
		}
		else {
			return Math.max(left_height, right_height) + 1;
		}
	}
	
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(" " + node.value + " ");
			printInOrder(node.right);
		}
	}
	
	public void printFrontToBack(Node node, int value) {
		if (node == null) {
			return;
		}
		
		if (node.value > value) {
			printFrontToBack(node.left, value);
			System.out.print(" " + node.value + " ");
			printFrontToBack(node.right, value);
		}
		else if (node.value < value) {
			printFrontToBack(node.right, value);
			System.out.print(" " + node.value + " ");
			printFrontToBack(node.left, value);
		}
		else {
			printFrontToBack(node.left, value);
			printFrontToBack(node.right, value);
		}
	}
	
	public static void printBinaryTree(Node root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.value);
	    }
	    else
	        System.out.println(root.value);
	    printBinaryTree(root.left, level+1);
	} 
}
