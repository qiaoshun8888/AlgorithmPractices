package other_practices2.array;

public class MedianOfTwoSortedArrays {

	/*
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * 1 3 5 7 9
	 * 2 4 6 8
	 */

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length, n = B.length;
		int total = m + n;
		// even 1 2 3 4
		if (total % 2 == 0) {
			return (findKth(A, B, total / 2, 0, m - 1, 0, n - 1) + findKth(A,
					B, total / 2 - 1, 0, m - 1, 0, n - 1)) / 2.0;
		}
		// odd 1 2 3
		else {
			return findKth(A, B, total / 2, 0, m - 1, 0, n - 1);
		}
	}

	private int findKth(int[] A, int[] B, int k, int aStart, int aEnd,
			int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return Math.min(A[aStart], B[bStart]);

		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 7, 8, 11, 44, 55, 62 };
		int[] arr2 = { 2, 4, 5, 7, 33, 56, 77 };
		MedianOfTwoSortedArrays o = new MedianOfTwoSortedArrays();
		System.out.println(o.findMedianSortedArrays(arr1, arr2));
	}
}
