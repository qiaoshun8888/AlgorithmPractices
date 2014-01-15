package leetcode;

public class SearchInRotatedSortedArrayII {

	/**
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 * 
	 * Write a function to determine if a given target is in the array.
	 * 
	 * */

	public boolean search(int[] A, int target) {
		if (A == null)
			return false;
		return binarySearch(A, 0, A.length - 1, target) != -1;
	}

	private int binarySearch(int[] vs, int left, int right, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (vs[mid] == target)
				return mid;

			// Rotation point in the right
			if (vs[left] < vs[mid]) {
				if (target > vs[mid])
					return binarySearch(vs, mid + 1, right, target);
				else {
					int v = binarySearch(vs, left, mid - 1, target);
					return v != -1 ? v : binarySearch(vs, mid + 1, right,
							target);
				}
			}
			// Rotation point in the left
			else if (vs[left] > vs[mid]) {
				if (target < vs[mid])
					return binarySearch(vs, left, mid - 1, target);
				else {
					int v = binarySearch(vs, mid + 1, right, target);
					return v != -1 ? v
							: binarySearch(vs, left, mid - 1, target);
				}
			}
			// Rotation point in right or unknown.
			else {
				// 1,3,1,1,1
				// 1,1,3,1
				int v = binarySearch(vs, left, mid - 1, target);
				return v != -1 ? v : binarySearch(vs, mid + 1, right, target);
			}
		}
		return -1;
	}
}
