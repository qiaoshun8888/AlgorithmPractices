package leetcode;

public class RemoveDuplicatesFromSortedListII {

	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, 
	 * 
	 * Given 1->2->3->3->4->4->5, return 1->2->5. 
	 * 
	 * Given 1->1->1->2->3, return 2->3.
	 * 
	 * */
	
	static class ListNode {
		ListNode next;
		int val;
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode runner = head, lastNode = null;
        
        while (runner != null) {
            int v = runner.val;
            boolean duplicate = false;
            // 1->1->1->2->3    (2->3)
            // 1->2->3->3->4->4->5    (1->2->5)
            while (runner.next != null && v == runner.next.val) {
                // If there is a duplicate, then drop it
                duplicate = true;
                runner.next = runner.next.next;
            }
            // If there is a duplicate, then remove itself
            if (duplicate) {
                if (runner == head) {
                    head = runner.next;
                }
                else {
                    lastNode.next = runner.next;
                }
            }
            else {
                lastNode = runner;
            }
            runner = runner.next;
        }
        
        return head;
    }
}
