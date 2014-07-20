package other_practices2.array;

public class SearchInRotatedSortedArrayII {

	/*
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 * 
	 * Write a function to determine if a given target is in the array.
	 */

	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0)
			return false;
		return binarySearch2(A, 0, A.length - 1, target) != -1;
	}

	private int binarySearch(int[] A, int left, int right, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid])
				return mid;
			// don't know where is the pivot
			// 7 7 7 7 7 8 9 7 7
			// 1 3 1 1 1 1 1 1 1
			if (A[left] == A[mid] && A[right] == A[mid]) {
				// need to search both sides of the array ( 2)
				int i = binarySearch(A, left, mid - 1, target); // left
				if (i == -1) {
					return binarySearch(A, mid + 1, right, target); // right
				}
				return i;
			}
			// pivot on the left
			// 7 8 9 1 2 3 4 5 7
			// 2 3 1 1 1 1 1
			else if (A[left] > A[mid]) {
				// only need to search the left side of the array
				if (target < A[mid]) {
					return binarySearch(A, left, mid - 1, target);
				}
				// need to search both sides of the array ( 2)
				else {
					int i = binarySearch(A, left, mid - 1, target); // left
					if (i == -1) {
						return binarySearch(A, mid + 1, right, target); // right
					}
					return i;
				}
			}
			// pivot on the right
			// 5 6 7 8 9 1 2 3 4
			// 7 7 7 7 7 1 1 2 3
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

	private int binarySearch2(int[] A, int left, int right, int target) {
		// e.g. 1 3 1 1 1 (3)
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid])
				return mid;
			// pivot is on the right side
			if (A[left] < A[mid]) {
				// 1 1 2 3 4 1 1 (2)
				if (A[left] <= target && target < A[mid]) {
					return binarySearch(A, left, mid - 1, target);
				}
				// 2 2 2 3 4 1 1 (1)
				return binarySearch(A, mid + 1, right, target);
			} else if (A[left] > A[mid]) {
				// 3 4 5 1 1 2 3
				if (A[mid] < target && target <= A[right]) {
					return binarySearch(A, mid + 1, right, target);
				}
				return binarySearch(A, left, mid - 1, target);
			} else {
				// skip duplicate one, A[left] == A[mid]
				return binarySearch(A, left++, right, target);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
		// int[] A = { 7, 7, 7, 7, 7, 1, 1, 2, 3 };
		// int[] A = { 7, 8, 9, 7 };
		// int[] A = { 5, 6, 7, 8, 9, 1, 2, 3, 4 };
		int[] A = { 1, 3, 1, 1, 1 };
		int target = 3;
		SearchInRotatedSortedArrayII o = new SearchInRotatedSortedArrayII();
		System.out.println(o.search(A, target));
	}
}
