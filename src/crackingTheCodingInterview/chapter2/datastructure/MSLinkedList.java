package crackingTheCodingInterview.chapter2.datastructure;

public class MSLinkedList {
	public int length;
	public int counter;
	
	public MSLinkedListNode head;
	public MSLinkedListNode tail;
	
	public MSLinkedList add(MSLinkedListNode node) {
		if (this.head != null) {
			this.tail.next = node;
		}
		else {
			this.head = node;
		}
		this.tail = node;
		this.length++;
		return this;
	}
	
	// Know the length.	Time: O(n)	Space: O(1)
	public MSLinkedListNode getKthToLastEle(int k) {
		if (k >= length) return this.tail;
		else if (k <= 0) return this.head;
		
		MSLinkedListNode runner = this.head;
		int index = 0;
		while (runner != null) {
			// 1 2 3 4
			if (index == length - k) {
				return runner;
			}
			runner = runner.next;
			index++;
		}
		
		return null;
	}
	
	// Don't know the length. Time: O(n)	Space: O(n)
	public MSLinkedListNode getKthToLastEleRecursively(MSLinkedListNode head, int k) {
		if (head == null) return head;
		if (k <= 0) return this.tail;
		
		MSLinkedListNode node = this.getKthToLastEleRecursively(head.next, k);
		
		this.counter++;
		if (this.counter == k) {
			return head;
		}
		
		return node;
	}
	
	// Don't know the length. Time: O(n)	Space: O(1)
	public MSLinkedListNode getKthToLastEleIteratively(int k) {
		if (k <= 0) return this.tail;
		MSLinkedListNode node1 = this.head;
		MSLinkedListNode node2 = this.head;
		// Offset node2 with k
		int space = 0;
		for (int i = 0; i < k - 1; i++) {
			if (node2.next != null) {
				space++;
				node2 = node2.next;
			}
			else {
				break;
			}
		}
		
		// If k is larger than the length of the linked list, return head
		if (space < k - 1) return this.head;
		
		while (node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return node1;
	}
}