package chapter2;

public class FindKthToLastEle {

	
	
	public static void main(String args []) {
		String str = "FOLLOW_UP";
		MySLinkedList list = new MySLinkedList(); 
		for (char c : str.toCharArray()) {
			list.add(new MySLinkedListNode(c));
		}
		
		MySLinkedListNode runner = list.head;
		while (runner != null) {
			System.out.print(runner.data + " ");
			runner = runner.next;
		}
		System.out.println();
		
		// === Method 1 ===
		// System.out.println(list.getKthToLastEle(5).data);
		
		// === Method 2 ===
		/*
		MySLinkedListNode node = list.getKthToLastEleRecursively(list.head, 4); 
		System.out.println(node != null ? node.data : node);
		*/
		
		// === Method 3 ===
		System.out.println(list.getKthToLastEleIteratively(4).data);
	}
	
}

class MySLinkedList {
	int length;
	int counter;
	
	MySLinkedListNode head;
	MySLinkedListNode tail;
	
	public MySLinkedList add(MySLinkedListNode node) {
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
	public MySLinkedListNode getKthToLastEle(int k) {
		if (k >= length) return this.tail;
		else if (k <= 0) return this.head;
		
		MySLinkedListNode runner = this.head;
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
	public MySLinkedListNode getKthToLastEleRecursively(MySLinkedListNode head, int k) {
		if (head == null) return head;
		if (k <= 0) return this.tail;
		
		MySLinkedListNode node = this.getKthToLastEleRecursively(head.next, k);
		
		this.counter++;
		if (this.counter == k) {
			return head;
		}
		
		return node;
	}
	
	// Don't know the length. Time: O(n)	Space: O(1)
	public MySLinkedListNode getKthToLastEleIteratively(int k) {
		if (k <= 0) return this.tail;
		MySLinkedListNode node1 = this.head;
		MySLinkedListNode node2 = this.head;
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

class MySLinkedListNode {
	char data;
	
	MySLinkedListNode next;
	
	public MySLinkedListNode(char c) {
		this.data = c;
	}
}