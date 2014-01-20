package myUtils;

import myUtils.datastructure.LinkedNode;

public class LinkedNodeUtils {

	public static LinkedNode generateLinkedNode (int [] vs) {
		if (vs == null || vs.length == 0) return null;
		LinkedNode head = new LinkedNode(vs[0]);
		LinkedNode runner = head;
		for (int i = 1; i < vs.length; i++) {
			runner.next = new LinkedNode(vs[i]);
			runner = runner.next;
		}
		return head;
	}
	
	public static void print(LinkedNode head) {
		if (head == null) return;
		while (head.next != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println(head.val);
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 3};
		LinkedNode head = generateLinkedNode(vs);
		print(head);
	}
}
