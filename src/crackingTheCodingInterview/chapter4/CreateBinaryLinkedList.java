package crackingTheCodingInterview.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

import crackingTheCodingInterview.chapter4.BuildBinaryTree;
import crackingTheCodingInterview.chapter4.BuildBinaryTree.Node;

public class CreateBinaryLinkedList {
	
	Node root;
	
	public CreateBinaryLinkedList() {
		int [] vs = {1, 2, 3, 4, 5, 6, 7};
		root = BuildBinaryTree.insert2(vs, 0, vs.length-1);
		
		BuildBinaryTree.printBinaryTree(root, 0);
	}
	
	public void create(Node node, ArrayList<LinkedList<Node>> lists, int level) {
		if (node == null) return;
		LinkedList<Node> list = null;
		if (lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
		}
		else {
			list = lists.get(level);
		}
		list.add(node);
		create(node.left, lists, level + 1);
		create(node.right, lists, level + 1);
	}
	
	public void create_BFS(Node root, ArrayList<LinkedList<Node>> lists) {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while (!list.isEmpty()) {
			lists.add(list);
			LinkedList<Node> parents = list;
			list = new LinkedList<Node>();
			for (Node parent : parents) {
				if (parent.left != null) {
					list.add(parent.left);
				}
				if (parent.right != null) {
					list.add(parent.right);
				}
			}
		}
	}

	public static void main(String [] args) {
		CreateBinaryLinkedList cbll = new CreateBinaryLinkedList();
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		// cbll.create(cbll.root, lists, 0);
		cbll.create_BFS(cbll.root, lists);
		
		for (LinkedList<Node> ll : lists) {
			System.out.print("LEVEL: ");
			for (Node n : ll) {
				System.out.print(n.value + " ");
			}
			System.out.println();
		}
	}
}
