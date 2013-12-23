package chapter2;

import java.util.Stack;

import chapter2.datastructure.MLinkedListIntNode;

public class IsPalindrome {
	
	/*
	 * Know the length of the linked list
	 * */
	public static boolean isPalindrome(MLinkedListIntNode head, int length) {
		if (head == null) return false;
		
		MLinkedListIntNode tail = null;
		MLinkedListIntNode runner = head;
		
		while (runner != null) {
			tail = runner;
			runner = runner.next;
		}
		
		int index = 0;
		while (index++ < length / 2 ) {
			if (head.data != tail.data) {
				return false;
			}
			head = head.next;
			tail = tail.pre;
		}
		
		return true;
	}
	
	/*
	 * Know the length of the linked list
	 * Using recursion to solve this problem
	 * 
	 * 1, 2, 3, 5, 5, 3, 2, 1
	 * 
	 * */
	public static RecuseResult isPalindromeRecurse(MLinkedListIntNode head, int length) {
		if (head == null || length == 0) {
			System.out.println("head == null || length == 0");
			return new RecuseResult(null, false);
		}
		// Odd
		if (length == 1) {
			System.out.println("length == 1, head.data: " + head.data);
			return new RecuseResult(head.next, true);
		}
		// Even
		else if (length == 2) {
			System.out.println("length == 2");
			return new RecuseResult(head.next.next, head.data == head.next.data);
		}
		
		System.out.println("head.next.data: " + head.next.data + " length-2: " + (length-2));
		RecuseResult res = isPalindromeRecurse(head.next, length - 2);
		
		if (!res.result || res.node == null) {
			System.out.println("!res.result || res.node == null");
			return res;
		}
		else {
			System.out.println("head.data: " + head.data + " res.node.data: " + res.node.data);
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	/*
	 * Unknow the length of the linked list
	 * Using fast_runner & slow_runner
	 * */
	public static boolean isPalindrome(MLinkedListIntNode head) {
		if (head == null) return false;
		
		Stack<Integer> stack = new Stack<Integer>();
		MLinkedListIntNode slow_runner = head;
		MLinkedListIntNode fast_runner = head;
		
		stack.push(slow_runner.data);
		
		// Find the middle point
		while (fast_runner.next != null && fast_runner.next.next != null) {
			slow_runner = slow_runner.next;
			fast_runner = fast_runner.next.next;
			stack.push(slow_runner.data);
		}
		
		// If fast_runner.next == null, odd
		// If fast_runner.next.next == null, even
		if (fast_runner.next != null) {
			slow_runner = slow_runner.next;
		}
		
		// Check if it is palindrome
		while (slow_runner != null) {
			if (slow_runner.data != stack.pop()) {
				return false;
			}
			slow_runner = slow_runner.next;
		}
		return true;
	}

	public static void main(String args[]) {
		int [] vs = {1, 2, 3, 5, 3, 2, 1};
		
		MLinkedListIntNode node = null;
		MLinkedListIntNode node_head = null;
		
		for (int v : vs) {
			MLinkedListIntNode temp = new MLinkedListIntNode(v); 
			if (node == null) {
				node = temp;
				node_head = node;
			}
			else {
				node.next = temp;
				node.next.pre = node;
				node = node.next;
			}
		}
		
		MLinkedListIntNode runner = node_head;
		while (runner != null) {
			System.out.print(runner.data + " ");
			runner = runner.next;
		}
		System.out.println();
		
		System.out.println("isPalindrome: " + IsPalindrome.isPalindrome(node_head, vs.length));
		System.out.println("isPalinedrome: " + IsPalindrome.isPalindrome(node_head));
		System.out.println("isPalinedrome: " + IsPalindrome.isPalindromeRecurse(node_head, vs.length).result);
	}
}

class RecuseResult {
	public MLinkedListIntNode node;
	public boolean result;
	
	public RecuseResult(MLinkedListIntNode node, boolean result) {
		this.node = node;
		this.result = result;
	}
}
