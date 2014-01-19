package leetcode;

public class CopyListWithRandomPointer {

	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 * 
	 * */

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		
		RandomListNode runner = head;
		
		// Copy a duplicate node and insert it next to the original one
		while (runner != null) {
			RandomListNode copy = new RandomListNode(runner.label);
			copy.next = runner.next;
			runner.next = copy;
			runner = copy.next;
		}
		
		// Copy Random node of duplicates nodes
		runner = head;
		while (runner != null) {
			runner.next.random = runner.random == null ? null : runner.random.next;
			runner = runner.next.next;
		}
		
		// Break the original node and the duplicates
		// 3 3 1 1 2 2
		// ^ ^
		// | L head.next
		// |
		// head
		runner = head;
		RandomListNode nHead = runner.next;
		
		while (runner != null) {
			RandomListNode temp = runner.next;
			runner.next = runner.next.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
			runner = runner.next;
		}

		return nHead;
	}
	
	public static void main(String[] args) {
		/**
		 * 1 -> 2 -> 3 -> 4 -> 5
		 * |    |    |    |    |
		 * v    v    v    v    v
		 * 3    4    1    5    2
		 * */
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node1.random = node3;
		node2.random = node4;
//		node3.random = node1;
		node4.random = node5;
		node5.random = node2;
		
		CopyListWithRandomPointer o = new CopyListWithRandomPointer();
		RandomListNode node = o.copyRandomList(node1);
		
		while (node != null) {
			System.out.print(node.label + "(" + (node.random == null ? "#" : node.random.label) + ")" + "  ");
			node = node.next;
		}
	}
}
