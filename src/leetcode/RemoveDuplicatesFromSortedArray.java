package leetcode;

public class RemoveDuplicatesFromSortedArray {

	/**
	 * Remove Duplicates from Sorted Array
	 * 
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array A = [1,1,2],
	 * 
	 * Your function should return length = 2, and A is now [1,2].
	 * 
	 * */

	/*
	    i = 0  1, 1, 2, 3, 5, 5, 7, 9  (duplicatesLength = 0)
	    i = 1  1, 2, 1, 3, 5, 5, 7, 9  (duplicatesLength = 1)
	    i = 2  1, 2, 3, 1, 5, 5, 7, 9  (duplicatesLength = 1)
	    i = 3  1, 2, 3, 5, 1, 5, 7, 9  (duplicatesLength = 1)
	    i = 4  1, 2, 3, 5, 5, 1, 7, 9  (duplicatesLength = 2)
	    i = 5  1, 2, 3, 5, 7, 5, 1, 9  (duplicatesLength = 2)
	 */
	private static int calledTimes = 0;
	
	public int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;

		int newLength = A.length, duplicatesLength = 0;
		for (int i = 0; i < A.length - 1; i++) {
			System.out.print(i + " ");
			calledTimes++;
			moveEndToFront(A, i - duplicatesLength + 1, i + 1);
			if (A[i - duplicatesLength] == A[i - duplicatesLength + 1]) {
				newLength--;
				duplicatesLength++;
			}
		}
		return newLength;
	}

	private void moveEndToFront(int[] vs, int start, int end) {
		int endVal = vs[end];
		while (end != start) {
			vs[end] = vs[end - 1];
			end--;
		}
		vs[start] = endVal;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 1, 1, 2, 3, 3, 4, 5, 5, 5, 5, 5, 9, 9};
		RemoveDuplicatesFromSortedArray o = new RemoveDuplicatesFromSortedArray();
		System.out.println(o.removeDuplicates(vs));
		System.out.println("calledTimes: " + calledTimes);
	}
}
