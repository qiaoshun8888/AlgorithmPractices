package crackingTheCodingInterview.chapter2;

import crackingTheCodingInterview.chapter2.datastructure.*;

public class PartitionLinkedList {
	
	public static void partitionWithNoExtraBuffer(MSLinkedListIntNode head, MSLinkedListIntNode tail, int length, int X) {
		// Partition
		int index = 0;
		MSLinkedListIntNode runner = head;
		do {
			if (index > length - 1)
				break;

			System.out.print(runner.data + " ");

			if (runner.data >= X) {
				MSLinkedListIntNode temp = new MSLinkedListIntNode(runner.data);

				// Remove the original node from linked list
				runner.data = runner.next.data;
				runner.next = runner.next.next;

				// Copy the node to the end of the linked list
				tail.next = temp;
				tail = temp;
			} else {
				runner = runner.next;
			}

			index++;
		} while (runner.next != null);

		System.out.println();
		System.out.print("[partition v=" + X + "]: ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void partitionWithExtraBuffer(MSLinkedListIntNode head, int X) {
		MSLinkedListIntNode less_than_node = null, greater_than_node = null;
		
		while (head != null) {
			MSLinkedListIntNode next = head.next;
			if (head.data >= X) {
				head.next = greater_than_node;
				greater_than_node = head;
			}
			else {
				head.next = less_than_node;
				less_than_node = head;
			}
			head = next;
		}
		
		MSLinkedListIntNode n_head = null;
		
		if (less_than_node == null) n_head = greater_than_node;
		else {
			n_head = less_than_node;
			// Find the end of the less_than_node
			while (less_than_node.next != null) {
				less_than_node = less_than_node.next;
			}
			// Merge two linked list
			less_than_node.next = greater_than_node;
		}
		
		System.out.println();
		System.out.print("[partition v=" + X + "]: ");
		while (n_head != null) {
			System.out.print(n_head.data + " ");
			n_head = n_head.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		// generate list
		int [] vs = {2, 3, 7, 1, 5, 9, 8, 0, 4};
		MSLinkedListIntNode head = null, tail = null;
		
		for (int v : vs) {
			MSLinkedListIntNode node = new MSLinkedListIntNode(v);
			if (head == null) head = node;
			if (tail != null) tail.next = node;
			tail = node;
		}
		
		PartitionLinkedList.partitionWithNoExtraBuffer(head, tail, vs.length, 6);
		
		PartitionLinkedList.partitionWithExtraBuffer(head, 6);
	}
}