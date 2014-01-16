package crackingTheCodingInterview.chapter2;

import crackingTheCodingInterview.chapter2.datastructure.*;

public class DetectCircularLinkedList {
	
	public static boolean detectCircularLinkedList (MSLinkedListIntNode head) {

		int flag = 0;
		while (head != null) {
			// System.out.println("Loop point is: " + (flag & (1 << head.data)) + "\tflag: "+flag+" head.data: "+head.data);
			if ((flag & (1 << head.data)) > 0) {
				return true;
			}
			flag |= (1 << head.data);
			head = head.next;
		}
		return false;
	}
	
	public static boolean detectCircularLinkedList2(MSLinkedListIntNode head) {
		MSLinkedListIntNode fast_runner = head, slow_runner = head;
		// Find collide point
		boolean is_collided = false;
		while (fast_runner.next != null && fast_runner.next.next != null) {
			slow_runner = slow_runner.next;
			fast_runner = fast_runner.next.next;
			
			if (slow_runner.equals(fast_runner)) {
				is_collided = true;
				break;
			}
		}
		
		// Find the head of the circular linked list
		if (is_collided) {
			// Move slow_runenr to the head of the linked list
			slow_runner = head;
			while (!slow_runner.equals(fast_runner)) {
				slow_runner = slow_runner.next;
				fast_runner = fast_runner.next;
			}
			System.out.println("The head of the loop is: " + slow_runner.data);
			return true;
		}
		return false;
	}
	
	public static int length(MSLinkedListIntNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	public static void main(String args[]) {
		// Loop ... 3 4 5 6 7 3 ...
		int [] vs = {1, 2, 3, 4, 5, 6, 7};
		
		MSLinkedListIntNode node = null;
		MSLinkedListIntNode node_head = null;
		MSLinkedListIntNode loop_node = null;
		
		for (int v : vs) {
			MSLinkedListIntNode temp = new MSLinkedListIntNode(v);
			if (node == null) {
				node = temp;
				node_head = node;
			}
			else {
				node.next = temp;
				
				// Save the loop point
				if (v == 4) {
					loop_node = node.next;
				}
				
				node = node.next;
			}
		}
		
		node.next = loop_node;
		
		/*
		int i = 0;
		while (node_head != null) {
			if (i++ > 20) break;
			System.out.print(node_head.data + " ");
			node_head = node_head.next;
		}
		*/
		
		System.out.println();
		// System.out.println(6&2);
		System.out.println(DetectCircularLinkedList.detectCircularLinkedList(node_head));
		System.out.println(DetectCircularLinkedList.detectCircularLinkedList2(node_head));
	}
}
