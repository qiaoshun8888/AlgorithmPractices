package other_practices1;

import myUtils.LinkedListUtils;
import myUtils.datastructure.LinkedNode;

/**
 * RemoveLinkedListDuplicates.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 19, 2014
 */

public class RemoveLinkedListDuplicates {

	private static int calledTimes = 0;
	
	public void removeDuplicates2(LinkedNode head) {
		/**
		 * Bug in the tail, I don't understand
		 */
		if (head == null || head.next == null)
			return;
		LinkedNode tmp = head;
		LinkedNode pivot = head.next;
		while (pivot != null) {
			calledTimes++;
			LinkedNode runner = head;
			while (runner != pivot) {
				calledTimes++;
				while (pivot != null && runner.val == pivot.val) {
					calledTimes++;
//				if (runner.val == pivot.val) {
					// remove pivot
					tmp.next = pivot.next;
					pivot = pivot.next;
//					break;
				}
				runner = runner.next;
			}
			tmp = pivot;
			pivot = pivot != null ? pivot.next : null;
		}
	}

	public static void main(String[] args) {
		int[] intArray = { 1, 2, 4, 4, 4, 4, 4, 7, 4 };
		LinkedNode head = LinkedListUtils.generateLinkedNode(intArray);
		RemoveLinkedListDuplicates s = new RemoveLinkedListDuplicates();
		s.removeDuplicates2(head);
		LinkedListUtils.print(head);
		
		System.out.println("calledTimes: " + calledTimes);
	}
}
