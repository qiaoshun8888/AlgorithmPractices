package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class N44AllPossibleInOrderBT {

	/**
	 * Given an array representing the pre-order traversal for binary tree,
	 * print all possible binary tree 'in-order' traversal.
	 * 
	 * */

	static class Node {
		Node left, right;
		int v;

		public Node(int v) {
			this.v = v;
		}

		public void printInOrder() {
			inOrderTraversal(this);
			System.out.println();
		}

		private void inOrderTraversal(Node root) {
			if (root == null)
				return;
			inOrderTraversal(root.left);
			System.out.print(root.v + " ");
			inOrderTraversal(root.right);
		}
	}

	public static List<Node> getAllTrees(int[] preOrder, int start, int end) {
		List<Node> trees = new ArrayList<Node>();

		// Base case
		if (start > end || end >= preOrder.length) {
			trees.add(null);
			return trees;
		}
		if (start == end) { // only one element
			trees.add(new Node(preOrder[start]));
			return trees;
		}

		for (int i = -1; i < end - start; i++) {
			System.out.println("\tfor loop i: " + i);
			
			// start-index is incremented by 1, and end-index for left child is controlled by i
			System.out.printf("getAllTrees for Left (start: %d end: %d)\n", start + 1, start + 1 + i);
			List<Node> leftChildren = getAllTrees(preOrder, start + 1, start + 1 + i);
			System.out.print("## leftChildren size: " + leftChildren.size() + "  [");
			printList(leftChildren);
			System.out.println("]");
			
			// right child is remaining part
			System.out.printf("getAllTrees for Right (start: %d end: %d)\n", start + 1 + i + 1, end);
			List<Node> rightChildren = getAllTrees(preOrder, start + 1 + i + 1, end);
			System.out.print("** rightChildren size: " + rightChildren.size() + "  [");
			printList(leftChildren);
			System.out.println("]");
			
			// go through the loop to assign each left / right to root.
			System.out.println("=== BEGIN ==============");
			for (Node eachLeft : leftChildren) {
				for (Node eachRight : rightChildren) {
					Node tempRoot = new Node(preOrder[start]); // make a copy of root
					tempRoot.left = eachLeft;
					tempRoot.right = eachRight;
					trees.add(tempRoot);
					System.out.println("tempRoot: " + tempRoot.v + " left: " + (eachLeft == null ? "null " : eachLeft.v + " ") + " right: " + (eachRight == null ? "null " : eachRight.v + " "));						
				}
			}
			System.out.println("=== END ==============");
		}
		System.out.print("return trees size: " + trees.size() + "  [");
		printList(trees);
		System.out.println("]");
		return trees;
	}
	
	private static void printList(List<Node> list) {
		Iterator<Node> it = list.iterator();
		while (it.hasNext()) {
			Node n = it.next();
			if (n != null) {
				System.out.print(n.v + " ");				
			}
			else {
				System.out.print("Node is null ");
			}
		}
	}

	public static void main(String[] args) {
		int[] testPreOrder = { 1, 2, 3};
		List<Node> trees = getAllTrees(testPreOrder, 0, testPreOrder.length - 1);
		for (Node eachFormedBt : trees)
			eachFormedBt.printInOrder();
	}
}
