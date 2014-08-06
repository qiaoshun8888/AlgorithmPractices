package other_practices2.sort;

public class FirstMissingPositive {

	/**
	 * Given an unsorted integer array, find the first missing positive integer.

		For example,
		Given [1,2,0] return 3,
		and [3,4,-1,1] return 2.

		Your algorithm should run in O(n) time and uses constant space.
	 */

	public int firstMissingPositive(int[] A) {
		if (A == null) return -1;
		int endIndex = A.length - 1;
		// put all the negative number at the end of the array.
		for (int i = 0; i < A.length && i < endIndex; i++) {
			if (A[i] <= 0) {
				swap(A, i, endIndex--);
			}

		}
		// try to put the number n into the slot #n (subscript n - 1)
		for (int i = 0; i <= endIndex; i++) {
			int k = A[i] - 1;
			if (k > endIndex) {
				A[i] *= -1; // mark this number as a negative to indicate this number is not useful.
				continue;
			}
			if (k == i || k < 0 || A[i] == A[k]) continue;
			swap(A, i--, k);
		}
		// traverse this array again, and find the first number m which m != i + 1.
		int m = 1;
		for (int i = 0; i <= endIndex; i++, m++) {
			if (A[i] - 1 != i) break;
		}
		// something wrong.
		return m;
	}
	private void swap(int[] A, int a, int b) {
		if (a != b) {
			A[a] ^= A[b];
			A[b] ^= A[a];
			A[a] ^= A[b];
		}
	}

	public static void main(String[] args) {
		//		int[] vs = {3,4,-1,1,12,5,7,};
		int[] vs = {0,1,2};
		//		int[] vs = {1, 1};
		FirstMissingPositive o = new FirstMissingPositive();
		System.out.println(o.firstMissingPositive(vs));
	}
}
