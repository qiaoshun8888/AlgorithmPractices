package chapter2;

import chapter2.datastructure.MSLinkedListIntNode;

public class RearrangeLinkedList {

	/*
	 * Unknow the size of the linked list 
	 * */
	public static MSLinkedListIntNode rearrange(MSLinkedListIntNode head) {
		MSLinkedListIntNode slow_runner = head, fast_runner = head;
		
		while (fast_runner.next != null && fast_runner.next.next != null) {
			slow_runner = slow_runner.next;
			fast_runner = fast_runner.next.next;
		}
		
		fast_runner = head;
		
		slow_runner = slow_runner.next; // move one step into B (second half of the linked list)
		
		// 1, 3, 5, 7, 2, 4, 6, 8
		// 1, 2, 3, 4, 5, 6, 7, 8, 2, 3, ...
		MSLinkedListIntNode temp = null;
		while (slow_runner.next != null) {
			temp = slow_runner.next;
			slow_runner.next = fast_runner.next;
			fast_runner.next = slow_runner;
			
			fast_runner = slow_runner.next;
			slow_runner = temp;
		}
		
		temp.next = null;
		fast_runner.next = temp;
		
		// System.out.println(fast_runner.data);
		
		DetectCircularLinkedList.detectCircularLinkedList2(head);
		
		return head;
	}
	
	public static void main(String args [])  {
		// Given a linked list which has even number of elements.
		// a1, a2, a3, ..., an, b1, b2, b3, ..., bn
		// Rearrange it to: a1, b1, a2, b2, ..., an, bn
		
		int [] vs = {1, 3, 5, 7, 2, 4, 6, 8};
		// int [] vs = {1, 1, 1 ,1 ,1, 0, 0, 0, 0, 0};
		
		MSLinkedListIntNode runner = null;
		MSLinkedListIntNode head = null;
		
		for (int v : vs) {
			MSLinkedListIntNode temp = new MSLinkedListIntNode(v);
			if (head == null) {
				head = temp;
				runner = head;
			}
			else {
				runner.next = temp;
				runner = runner.next;
			}
		}
		
		runner = head;
		while (runner != null) {
			System.out.print(runner.data + " ");
			runner = runner.next;
		}
		System.out.println();
		
		runner = RearrangeLinkedList.rearrange(head);
		while (runner != null) {
			System.out.print(runner.data + " ");
			runner = runner.next;
		}
	}
}
