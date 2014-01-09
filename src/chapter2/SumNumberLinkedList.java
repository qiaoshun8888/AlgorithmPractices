package chapter2;

import chapter2.datastructure.MLinkedListIntNode;
import chapter2.datastructure.MSLinkedListIntNode;

public class SumNumberLinkedList {
	
	public static MLinkedListIntNode sum (MSLinkedListIntNode l1, MSLinkedListIntNode l2) {
		if (l1 == null && l2 == null) return null;
		
		MLinkedListIntNode sum = new MLinkedListIntNode(0);
		int carry = 0;
		
		while (l1 != null || l2 != null) {
			
			if (l1 != null) {
				sum.data += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum.data += l2.data;
				l2 = l2.next;
			}
			
			// add carry
			sum.data += carry;
			
			if (sum.data >= 10) {
				sum.data -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			
			MLinkedListIntNode zero_node = new MLinkedListIntNode(0); 
			zero_node.next = sum;
			sum.pre = zero_node;
			sum = zero_node;
		}
		
		return sum.next;
	}
	
	public static MLinkedListIntNode sum2 (MSLinkedListIntNode l1, MSLinkedListIntNode l2) {
		if (l1 == null && l2 == null) return null;
		
		MLinkedListIntNode sum = new MLinkedListIntNode(0); 
		MLinkedListIntNode sum_head = sum;
		
		// get the length of each linked list
		int length_l1 = length(l1);
		int length_l2 = length(l2);
		
		int offset = Math.max(length_l1, length_l2) - Math.min(length_l1, length_l2);
		
		while (l1 != null) {
			if (offset != 0) {
				if (length_l1 > length_l2) {
					sum.data = l1.data;
					l1 = l1.next;
				}				
				else {
					sum.data = l2.data;
					l2 = l2.next;
				}
				offset--;
			}
			else {
				int v = l1.data + l2.data;
				if (v >= 10) {
					v -= 10;
					sum.pre.data += 1;
				}
				sum.data = v;
				l1 = l1.next;
				l2 = l2.next;
			}
			
			sum.next = new MLinkedListIntNode(sum.data);
			sum.next.pre = sum;
			sum = sum.next;
		}
		
		sum.pre.next = null;
		
		return sum_head;
	}
	
	public static int length (MSLinkedListIntNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length ++;
		}
		return length;
	}
	
	public static int length (MLinkedListIntNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length ++;
		}
		return length;
	}

	public static void main(String args[]) {
		MSLinkedListIntNode n1_head = null, n2_head = null;
		
		/*
		// Generate lists	int1: 123	int2: 4567
		int [] vs1 = {6, 5, 4, 3}, vs2 = {4, 5, 6, 7};
				
		// Numbers are stored in reverse order
		for (int v : vs1) {
			MSLinkedListIntNode temp = new MSLinkedListIntNode(v);
			temp.next = n1_head;
			n1_head = temp;
		}
		
		for (int v : vs2) {
			MSLinkedListIntNode temp = new MSLinkedListIntNode(v);
			temp.next = n2_head;
			n2_head = temp;
		}
		
		// Sum
		MLinkedListIntNode sum = SumNumberLinkedList.sum(n1_head, n2_head);
		System.out.println();
		System.out.print("sum: \t\t");
		while (sum != null) {
			System.out.print(sum.data);
			sum = sum.next;
		}
		
		*/
		
		// Generate lists	int1: 123	int2: 4567
		int [] vs1 = {3, 4, 6}, vs2 = {7, 6, 5, 4};
		// Numbers are stored in forward order
		for (int v : vs1) {
			MSLinkedListIntNode temp = new MSLinkedListIntNode(v);
			temp.next = n1_head;
			n1_head = temp;
		}
		
		for (int v : vs2) {
			MSLinkedListIntNode temp = new MSLinkedListIntNode(v);
			temp.next = n2_head;
			n2_head = temp;
		}
		
		// Print generated lists
		MSLinkedListIntNode runner = n1_head;
		System.out.print("n1_node: \t");
		while (runner != null) {
			System.out.print(runner.data);
			runner = runner.next;
		}
		System.out.println();
		runner = n2_head;
		System.out.print("n_node: \t");
		while (runner != null) {
			System.out.print(runner.data);
			runner = runner.next;
		}
		System.out.println();
		
		// Sum
		MLinkedListIntNode sum = SumNumberLinkedList.sum(n1_head, n2_head);
		System.out.println();
		System.out.print("sum: \t\t");
		while (sum != null) {
			System.out.print(sum.data);
			sum = sum.next;
		}
	}
}


