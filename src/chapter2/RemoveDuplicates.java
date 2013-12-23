package chapter2;

import java.util.HashMap;

public class RemoveDuplicates {

	// No buffer is allowed implementation	Time: O(N^2)	Space:O(1)
	public static LinkedListNode removeDuplicates(LinkedListNode node) {
		LinkedListNode head = node;
		while (node.next != null) {
			LinkedListNode temp_runner = node.next;
			do{
				if (node.data == temp_runner.data) {
					if (temp_runner.next != null) {
						temp_runner.pre.next = temp_runner.next;
						temp_runner.next.pre = temp_runner.pre;
					}
					else {
						temp_runner.pre.next = null;
					}
				}
			}
			while ((temp_runner = temp_runner.next) != null);
			node = node.next;
		}
		return head;
	}
	
	// Extra buffer is allowed	Time: O(n)
	public static LinkedListNode removeDuplicates2(LinkedListNode node) {
		LinkedListNode head = node;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (node.next != null) {
			if (map.containsKey((int)node.data)) {
				node.pre.next = node.next;
				node.next.pre = node.pre;
			}
			else {
				map.put((int)node.data, 1);
			}
			node = node.next;
		}
		return head;
	}
	
	public static void printLinkedList (LinkedListNode head) {
		LinkedListNode temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	
	public static void main(String args[]) {
		String str = "FOLLOW UP BUDDY";
		LinkedListNode head = null;
		LinkedListNode pre_node = null;
		
		for (char c : str.toCharArray()) {
			LinkedListNode node = new LinkedListNode(c);
			if (head == null) head = node;
			if (pre_node != null) {
				node.pre = pre_node;
				node.pre.next = node;
			}
			pre_node = node;
		}
		
		RemoveDuplicates.printLinkedList(head);
		// head = RemoveDuplicates.removeDuplicates(head);
		head = RemoveDuplicates.removeDuplicates2(head);
		RemoveDuplicates.printLinkedList(head);
	}
}

class LinkedListNode {
	
	public char data;
	public LinkedListNode pre;
	public LinkedListNode next;
	
	public LinkedListNode(char data) {
		this.data = data;
	}
}
