package other_practices2.array;

public class RemoveDuplicatesII {

	/*
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 */
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int cur = A[0], index = 1, repeat = 1;
		// original: 1, 1, 1, 2, 2, 2, 3, 3
		// 1, 1, 2, 1, 2, 2, 3, 3
		// 1, 1,
		// expected: 1, 1, 1, 2, 2, 2, 3, 3
		for (int i = 1; i < A.length; i++) {
			if (A[i] == cur) {
				repeat++;
				if (repeat > 2) {
					continue;
				}
			} else {
				repeat = 1;
				cur = A[i];
			}
			swap(A, index, i);
			index++;
		}
		return index;
	}

	// This method will rewrite the original value
	public int removeDuplicates2(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int repeat = 1, index = 0;
		// 1 1 1 1 3 3
		// 1 1 3 1 3 3
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[index]) {
				repeat++;
				if (repeat > 2) {
					continue;
				}
			} else {
				repeat = 1;
			}
			A[++index] = A[i];
		}
		return index + 1;
	}

	private void swap(int[] A, int a, int b) {
		if (a != b) {
			A[a] ^= A[b];
			A[b] ^= A[a];
			A[a] ^= A[b];
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 3, 3, 3, 3 };
		RemoveDuplicatesII o = new RemoveDuplicatesII();
		// System.out.println(o.removeDuplicates2(A));
		System.out.println(o.removeDuplicates(A));
		for (int a : A) {
			System.out.print(a + " ");
		}
	}
}
