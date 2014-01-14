package leetcode;

public class RemoveDuplicatesFromSortedArrayII {

	/**
	 * 
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory. 
	 * 
	 * Follow up for "Remove Duplicates": What if
	 * duplicates are allowed at most twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 * 
	 * */

	public static int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;

		int last = A[0], lastNum = 1, endOffset = 0;
		for (int i = 1; i < A.length - endOffset; i++) {
			int v = A[i];
			if (v == last) {
				lastNum++;
				if (lastNum > 2) {
					moveEndToFront(A, i, A.length - 1 - endOffset);
					endOffset++;
					i--;
				}
			} else {
				last = v;
				lastNum = 1;
			}
		}
		
		return A.length - endOffset;
	}

	private static void moveEndToFront(int[] vs, int start, int end) {
		// 1 1 1 2 2 3 4
		int temp = vs[start];
		while (start < end) {
			vs[start] = vs[start + 1];
			start++;
		}
		vs[start] = temp;
	}
	
	public static void main(String [] args) {
		int [] vs = {1, 1, 1, 1};
		int newLength = removeDuplicates(vs);
		System.out.println("New length of array: " + newLength);
		for (int i = 0; i < newLength; i++) {
			System.out.print(vs[i] + " ");
		}
	}
}
