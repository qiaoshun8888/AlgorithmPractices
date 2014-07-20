package other_practices2.array;

public class SearchInRotatedSortedArray {

	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 */

	public int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		return binarySearch(A, 0, A.length - 1, target);
	}

	// 3, 4, 5, 6, 7, 1, 2, (5)
	private int binarySearch(int[] A, int left, int right, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid])
				return mid;
			// pivot on the left side of the array
			// 7 8 1 2 3 4 5 (8)
			if (A[left] > A[mid]) {
				// only need to search the left side of the array
				if (target < A[mid])
					return binarySearch(A, left, mid - 1, target);
				// need to search both sides of the array
				else {
					int i = binarySearch(A, left, mid - 1, target);
					if (i == -1) {
						return binarySearch(A, mid + 1, right, target);
					}
					return i;
				}
			}
			// pivot on the right side of the array
			// 4, 5, 6, 7, 8, 1, 2, 3
			else {
				// need to search both sides of the array
				if (target < A[mid]) {
					int i = binarySearch(A, left, mid - 1, target);
					if (i == -1) {
						return binarySearch(A, mid + 1, right, target);
					}
					return i;
				}
				// only need to search the right side of the array
				else {
					return binarySearch(A, mid + 1, right, target);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// int[] A = { 5, 1, 3 };
		// int[] A = { 3, 4, 5, 6, 7, 1, 2 };
		int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
		int target = 3;
		SearchInRotatedSortedArray o = new SearchInRotatedSortedArray();
		System.out.println(o.search(A, target));
	}
}
