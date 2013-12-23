package crackingProgrammingInterviewYouTuBe;

public class N28FindIntersectionOfTwoLinkedList {

	/**
	 * Find the intersection of two linked list.
	 * 
	 * */
	
	static class Node {
		Node next;
		int v;
		public Node(int v) {
			this.v = v;
		}
	}
	
	/**
	 * n1:   1 3 
	 *           \
	 * 		       5 6 7
	 *           /
	 * n2: 2 3 4 
	 * */
	public static Node find(Node n1, Node n2) {
		int len_n1 = 0, len_n2 = 0;
		Node runner = n1;
		while (runner != null) {
			len_n1++;
			runner = runner.next;
		}
		runner = n2;
		while (runner != null) {
			len_n2++;
			runner = runner.next;
		}
		
		int skip = 0;
		if (len_n1 > len_n2) {
			skip = len_n1 - len_n2;
			while (skip-- > 0) {
				n1 = n1.next;
			}
		}
		else {
			skip = len_n2 - len_n1;
			while (skip-- > 0) {
				n2 = n2.next;
			}
		}
		
		while (n1.next != null) {
			if (n1.equals(n2)) return n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return null;
	}
	
	public static void main(String [] args) {
		Node n1 = new Node(12);
		n1.next = new Node(112);
		
		Node n2 = new Node(33);
		n2.next = new Node(22);
		n2.next.next = new Node(9);
		
		Node common = new Node(4);
		common.next = new Node(8);
		common.next.next = new Node(12);
		
		n1.next.next = common;
		n2.next.next.next = common;
		
		Node find = find(n1, n2);
		if (find == null) {
			System.out.println("There is no intersection of two linked list");
		}
		else {
			System.out.println("Found! The intersection of two linked list is: " + find.v);
		}
	}
}
