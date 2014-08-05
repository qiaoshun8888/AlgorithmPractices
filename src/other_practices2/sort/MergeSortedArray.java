package other_practices2.sort;

public class MergeSortedArray {

	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

		Note:
		You may assume that A has enough space (size that is greater or equal to m + n) 
		to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
	 */

	public void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null) return;
		int index = m + n - 1, aEnd = m - 1, bEnd = n - 1;
		while (aEnd >= 0 && bEnd >= 0) {
			if (A[aEnd] > B[bEnd]) {
				A[index--] = A[aEnd--];
			} else {
				A[index--] = B[bEnd--];
			}
		}
		while (bEnd >= 0) {
			A[index--] = B[bEnd--];
		}
	}

	public static void main(String[] args) {
		int[] A = new int[20];
		for (int i = 0; i < 5; i++) {
			A[i] = (i + 1) * 3;
		}
		int[] B = new int[5];
		for (int i = 0; i < 5; i ++) {
			B[i] = i * 4;
		}

		System.out.print("A: ");
		for (int i = 0; i < 5; i++) {
			System.out.print(A[i] + " ");
		}

		System.out.print("\nB: ");
		for (int i = 0; i < 5; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.println("\n");

		MergeSortedArray o = new MergeSortedArray();
		o.merge(A, 5, B, 5);
		for (int i = 0; i < 10; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
