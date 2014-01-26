package google.linkedlists;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

public class FindTheKthLastElementInLinkedList {

	/**
	 * Find the kth last element in linked list (Recursively & Iteratively)
	 * */
	
	public static int findRecursively(LinkedNode head, int k) {
		if (k <= 0) return -1;
		if (head == null) return 0;
		
		int v = findRecursively(head.next, k) + 1;
		
		if (v == k) {
			System.out.println(head.val);
		}
		
		return v;
	}
	
	public static LinkedNode findIteratively(LinkedNode head, int k) {
		if (k <= 0 || head == null) return null;
		
		LinkedNode fastRunner = head;
		int step = 0;
		while (step != k && fastRunner.next != null) {
			fastRunner = fastRunner.next;
			step++;
		}
		
		while (fastRunner != null) {
			head = head.next;
			fastRunner = fastRunner.next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		int [] vs = {1, 2, 2, 2, 3, 3, 2, 5, 1, 5};
		LinkedNode head = LinkedListUtils.generateLinkedNode(vs);
		int k = 6;
		findRecursively(head, k);
		System.out.println(findIteratively(head, k).val);
	}
}
