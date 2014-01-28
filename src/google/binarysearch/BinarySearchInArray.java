package google.binarysearch;

/**
 *	BinarySearchInArray.java
 *
 *	Description: Given an sorted array of positive integers, find x. 
 *	
 *	Follow up 1: If numbers are not distinct, find the first one.
 *
 *	Follow up 2: If the array is rotated.
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 25, 2014
 */

public class BinarySearchInArray {

	private static boolean eraseHead = false;
	
	public static int binarySearch(int [] vs, int target) {
		return binarySearchHelper(vs, 0, vs.length - 1, target);
	}
	private static int binarySearchHelper(int [] vs, int left, int right, int target) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (vs[mid] < vs[left]) {
				int offset = vs[mid] == target ? 0 : 1;
				int index = binarySearchHelper(vs, left, mid - offset, target);
				return index != -1 ? index : binarySearchHelper(vs, mid + offset, right, target);
			}
			else if (vs[mid] > vs[left]) {
				if (vs[mid] < target) return binarySearchHelper(vs, mid + 1, right, target);
				else if (vs[mid] > target) {
					int index = binarySearchHelper(vs, left, mid - 1, target);
					return index != -1 ? index : binarySearchHelper(vs, mid + 1, right, target);
				}
				else return binarySearchHelper(vs, left, mid, target);
			}
			else {
				if (vs[mid] != target){
					int index = binarySearchHelper(vs, mid + 1, right, target);
					return index != -1 ? index : binarySearchHelper(vs, left, mid - 1, target);
				}
				// In the case that vs[mid] == vs[left] and vs[mid] == target
				// If we want to find the first target appeared in the current array, 
				// then we can just return left.
				// But if we want to find the first target appeared before the array was rotated,
				// that will be much more tricky! (I don't have a solution yet)
				if (!eraseHead && vs[vs.length - 1] == target) {
					System.out.println(mid + "  " + left);
					eraseHead = true;
					return binarySearchHelper(vs, mid + 1, vs.length - 1, target);
				}
				else return left;
			}
		}
		return -1;		
	}
	
	public static void main(String[] args) {
		// int [] vs = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8, 1};
		int [] vs = {1,2,3,1,1,1,1,1,1,1,1,1,1};
		int target = 1;
		System.out.println(binarySearch(vs, target));
	}
}
