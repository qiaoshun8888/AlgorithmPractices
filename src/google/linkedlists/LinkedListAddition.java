package google.linkedlists;

import java.util.*;

import org.junit.Ignore;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

public class LinkedListAddition {

	/**
	 * You have two numbers represented by a linked list, where each node
	 * contains a singledigit.Thedigitsarestoredinreverseorder,such that the 1's
	 * digit is at the head of the list. Write a function that adds the two
	 * numbers and returns the sum as a linked list.
	 * 
	 * FOLLOW UP 
	 * 
	 * Suppose the digits are stored in forward order. Repeat the
	 * above problem.
	 * 
	 * */
	
	public static LinkedNode add(LinkedNode n1, LinkedNode n2) {
		if (n1 == null || n2 == null) return null;
		
		LinkedNode head = null, runner = null;
		
		int carry = 0;
		while (n1 != null && n2 != null) {
			int v = n1.val + n2.val + carry;
			if (v >= 10) {
				v -= 10;
				carry = 1;
			}
			if (head == null) {
				head = new LinkedNode(v);
				runner = head;
			}
			else {
				runner.next = new LinkedNode(v);
				runner = runner.next;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		LinkedNode remains = n1 != null ? n1 : n2;
		while (remains != null) {
			int v = remains.val + carry;
			if (carry != 0) {
				carry = 0;
			}
			runner.next = new LinkedNode(v);
			runner = runner.next;
			remains = remains.next;
		}
		
		if (carry != 0) {
			runner.next = new LinkedNode(carry);
		}
		
		return head;
	}
	
	
	public static LinkedNode addFollowUp(LinkedNode n1, LinkedNode n2) {
		if (n1 == null || n2 == null) return null;
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		while (n1 != null) {
			stack1.push(n1.val);
			n1 = n1.next;
		}
		
		while (n2 != null) {
			stack2.push(n2.val);
			n2 = n2.next;
		}
		
		int carry = 0;
		LinkedNode head = null;
		
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int v = carry;
			
			if (!stack1.isEmpty()) {
				v += stack1.pop();
			}
			if (!stack2.isEmpty()) {
				v += stack2.pop();
			}
			
			if (v >= 10) {
				v -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			
			if (head == null) {
				head = new LinkedNode(v);
			}
			else {
				LinkedNode newNode = new LinkedNode(v);
				newNode.next = head;
				head = newNode;
			}
		}
		
		if (carry != 0) {
			LinkedNode newNode = new LinkedNode(carry);
			newNode.next = head;
			head = newNode;
		}
		
		return head;
	}
	
	@Ignore
	private static int size(LinkedNode n) {
		int size = 0;
		while (n != null) {
			n = n.next;
			size++;
		}
		return size;
	}
	
	public static void main(String[] args) {
		int [] vs1 = {6, 1, 7, 1};
		int [] vs2 = {4, 8, 3};
		
		LinkedNode n1 = LinkedListUtils.generateLinkedNode(vs1);
		LinkedNode n2 = LinkedListUtils.generateLinkedNode(vs2);
		
		LinkedListUtils.print(add(n1, n2));
		LinkedListUtils.print(addFollowUp(n1, n2));
	}
}
