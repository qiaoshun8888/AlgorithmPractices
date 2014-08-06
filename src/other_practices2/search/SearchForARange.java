package other_practices2.search;

public class SearchForARange {
	/**
	 * Given a sorted array of integers, find the starting and ending position of a given target value.

		Your algorithm's runtime complexity must be in the order of O(log n).

		If the target is not found in the array, return [-1, -1].

		For example,
		Given [5, 7, 7, 8, 8, 10] and target value 8,
		return [3, 4].
	 */

	public int[] searchRange(int[] A, int target) {
		if (A == null || A.length == 0) return new int[]{-1, -1};
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		binarySearch(A, 0, A.length - 1, target, 0, result);
		return result;
	}
	/**
	 * flag:
	 * 	0 - search for target
	 *  1 - search for left
	 *  2 - search for right
	 * */
	private void binarySearch(int[] vs, int left, int right, int target, int flag, int[] result) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (vs[mid] == target) {
				if (flag == 0) {
					binarySearch(vs, left, mid, target, 1, result);
					binarySearch(vs, mid, right, target, 2, result);
				}
				else if (flag == 1) {
					// found the left index
					if ((mid == 0 || vs[mid - 1] != target)) {
						result[0] = mid;
					} else {
						// keep searching if either left or right doesn't find.
						binarySearch(vs, left, mid, target, 1, result);
					}
				}
				else if (flag == 2) {
					// found the right index
					if ((mid == vs.length - 1 || vs[mid + 1] != target) && flag == 2) {
						result[1] = mid;
					}
					else {
						// if only two numbers left, we always pick the left one as the mid.
						// so in this case, the recursion won't get finished.
						if (mid == right - 1 && flag == 2) result[1] = right;
						else {
							binarySearch(vs, mid, right, target, 2, result);
						}
					}
				}
			}
			// search left
			else if (vs[mid] > target) {
				binarySearch(vs, left, mid - 1, target, flag, result);
			}

			// search right
			else {
				binarySearch(vs, mid + 1, right, target, flag, result);
			}
		}
	}

	public static void main(String[] args) {
		int[] vs = {5, 7, 7, 8, 8, 10}; int target = 8;
		// int[] vs = {1,1,1}; int target = 1;

		SearchForARange o = new SearchForARange();
		int[] result = o.searchRange(vs, target);
		System.out.println(result[0] + ", " + result[1]);
	}
}
