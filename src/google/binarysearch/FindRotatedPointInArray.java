package google.binarysearch;

/**
 *	FindRotatedPointInArray.java
 *
 *	Description: Find the head of a given rotated array
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 25, 2014
 */

public class FindRotatedPointInArray {

	private static int findHeadOffset(int [] vs) {
		if (vs == null) return -1;
		return findHeadOffsetHelper(vs, 0, vs.length - 1);
	}
	private static int findHeadOffsetHelper(int [] vs, int left, int right) {
		if (left > right) return 0;
		
		int mid = left + (right - left) / 2;
		
		// Base cases
		if (left == mid && left == right) { // When right == mid, there is only one case, that is left == right 
			// ... 5,6 ... (8) ... 1,2 ...
			//              ^
			//              |
			//         left = right
			return mid;
		}
		else if (left == mid && left != right) {
			// ... 6,7 ... (8 1) ... 2,3 ...
			//              ^ ^
			//              | L *right
			//              left 
			if (vs[left] > vs[right]) return right;
			// ... 11,12 ... (8 8) ... 9,10 ...
			//                ^ ^
			//                | L right
			//                *left 
			else return left;
		}
		if ((vs[mid] < vs[mid - 1] && vs[mid] <= vs[mid + 1])) {
			// Any time we found a vs[mid] which is smaller than vs[mid - 1] and vs[mid + 1], we return mid
			return mid;
		}
		
		// 6 6 2 3
		// head on the right
		if (vs[mid] >= vs[left]) {
			return findHeadOffsetHelper(vs, mid + 1, right);
		}
		// 5 6 1 2 3
		// head on the left or right
		else {
			int index = findHeadOffsetHelper(vs, left, mid - 1);
			return index != -1 ? index : findHeadOffsetHelper(vs, mid + 1, right);
		}
	}
	
	public static void main(String[] args) {
		
		int [] vs = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 1};
		System.out.println(findHeadOffset(vs));
	}
}
