package chapter2;

import chapter2.datastructure.MSLinkedList;
import chapter2.datastructure.MSLinkedListNode;

public class DeleteGiveNodeInLinkedList {

	public static void main(String args[]) {
		String str = "FOLLOW_UP";
		MSLinkedList list = new MSLinkedList(); 
		for (char c : str.toCharArray()) {
			list.add(new MSLinkedListNode(c));
		}
		
		MSLinkedListNode runner = list.head;
		MSLinkedListNode delete_node = null;
		while (runner != null) {
			System.out.print(runner.data + " ");
			if (runner.data == 'W') {
				delete_node = runner;
			}
			runner = runner.next;
		}
		System.out.println();
		
		// Delete the node (REMEMBER: If the node is the last node, we cannot do this!!)
		delete_node.data = delete_node.next.data;
		delete_node.next = delete_node.next.next;
		
		runner = list.head;
		while (runner != null) {
			System.out.print(runner.data + " ");
			runner = runner.next;
		}
		System.out.println();
	}
}
