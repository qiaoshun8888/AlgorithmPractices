package leetcode;

public class SearchInRotatedSortedArray {

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * */

	public int search(int[] A, int target) {
		if (A == null)
			return -1;
		return binarySearch(A, 0, A.length - 1, target);
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
				// 2 2 2 2 1
				if (vs[mid] == vs[right])
					return -1;
				return binarySearch(vs, mid + 1, right, target);
			}
		}
		return -1;
	}
}
