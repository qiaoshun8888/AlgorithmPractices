package amazon.onlineTest;

/**
 *	Question4.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Mar 14, 2014
 */

public class Question4 {
	
    public static class ListNode {
        public int customerId;
        public ListNode next;

        public ListNode(int x) {
            customerId = x;
        }
    }

    public static ListNode customersToNotify(ListNode myList, int k) {
        if (myList == null) return null;
        if (k < 0) return null;
        ListNode n1 = myList, n2 = myList;
        for (int i = 0; i < k; i++) {
            // assume k < n
            // set the n1 to the kth node of the list
            n1 = n1.next;
        }
        while(n1!=null){
            // move n1 and n2 with same steps
            // when n1 is the end, n2 is the last k-th customer.
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;
    }

    public static void main(String[] args) {
        // simple test 1,8,4,2,7,13,3
        ListNode head = new ListNode(1);
        ListNode node = head;
        node.next = new ListNode(8);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(7);
        node = node.next;
        node.next = new ListNode(13);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;

        ListNode result = customersToNotify(head, 2);
        while (result != null) {
        	System.out.print(result.customerId + " -> ");
        	result = result.next;
        }
        
    }
}