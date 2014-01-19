package leetcode;

import java.util.Stack;

public class ReorderList {

	/**
	 * Given a singly linked list 
	 * 
	 * L: L0 > L1 > ... > Ln-1 > Ln, 
	 * 
	 * reorder it to:
	 * L0 > Ln > L1 > Ln-1 > L2 > Ln-2 > ...
	 * 
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * 
	 * */
	
	static class ListNode {
		ListNode next;
		int val;
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public void reorderList(ListNode head) {
		if (head == null) return;
		
        ListNode runnerSlow = head;
        ListNode runnerFast = head;
        
        while (runnerFast.next != null && runnerFast.next.next != null) {
        	runnerFast = runnerFast.next.next;
        	runnerSlow = runnerSlow.next;
        }
        
        ListNode stopNode = runnerSlow;
        Stack<ListNode> stack = new Stack<ListNode>();
        
        runnerSlow = runnerSlow.next;
        
        while (runnerSlow != null) {
        	stack.push(runnerSlow);
        	runnerSlow = runnerSlow.next;
        }

        boolean odd = runnerFast.next == null;
        
        // {1,2,3,4}, reorder it to {1,4,2,3}
        // {1, 2, 3}    ->   {1, 3, 2}
        while (!stack.isEmpty()) {
        	ListNode node = stack.pop();
        	node.next = head.next;
        	head.next = node;
        	
        	if (head == stopNode) {
        		node.next = null;
        		break;
        	}
        	
        	head = node.next;
        }
        
        if (odd) head.next = null;
    }
}
