package other_practices2.search;

public class SearchInsertPosition {

	/**
	 * Given a sorted array and a target value, 
	 * return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.

		You may assume no duplicates in the array.

		Here are few examples.
		[1,3,5,6], 5 → 2
		[1,3,5,6], 2 → 1
		[1,3,5,6], 7 → 4
		[1,3,5,6], 0 → 0
	 */

	public int searchInsert(int[] A, int target) {
		if (A == null) return 0;
		if (target < A[0]) return 0;
		if (target > A[A.length - 1]) return A.length;
		return binarySearch(A, 0, A.length - 1, target);
	}
	private int binarySearch(int[] vs, int left, int right, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (vs[mid] == target) return mid;
			if (vs[mid] > target) return binarySearch(vs, left, mid - 1, target);
			else return binarySearch(vs, mid + 1, right, target);
		}
		return left;
	}

	public static void main(String[] args) {
		int[] vs = {1, 3, 5, 6};
		int target = 2;
		SearchInsertPosition o = new SearchInsertPosition();
		System.out.println(o.searchInsert(vs, target));
	}
}
