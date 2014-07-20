package other_practices2.array;

public class RemoveDuplicates {

	/*
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length. Do not allocate extra
	 * space for another array, you must do this in place with constant mem-
	 * ory. For example, Given input array A = [1,1,2], Your function should
	 * return length = 2, and A is now [1,2].
	 */

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		// 1 1 2 2 3 3 4 4 win_start = 1
		// 1 2 1 2 3 3 4 4 win_start = 2

		int cur = A[0], win_start = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > cur) {
				cur = A[i];
				swap(A, i, win_start++);
			}
		}
		return win_start;
	}

	private void swap(int[] A, int a, int b) {
		if (a != b) {
			A[a] ^= A[b];
			A[b] ^= A[a];
			A[a] ^= A[b];
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 3, 3 };
		RemoveDuplicates o = new RemoveDuplicates();
		System.out.println(o.removeDuplicates(A));
	}
}
