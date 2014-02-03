package google.binarysearch;

/**
 * FindNumberExists.java
 * 
 * Description: Given an unknown size sorted array and a number, check if the
 * number exists in the array
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 2, 2014
 */

public class FindNumberExists {

	public static int exists(int[] vs, int target) {
		if (target < vs[0]) return -1;
		
		int left = 0, right = 1;
		
		try {
			for(;;) {
				if (vs[right] == target) return right;
				else if (vs[right] < target) {
					left = right + 1;
					right = left * 2 - 1;
				}
				else break;
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		// binary search 
		while (left <= right) {
			int mid = left + (right - left) / 2;
			try {
				if (vs[mid] == target) return mid;
				else if (vs[mid] > target) right = mid - 1;
				else left = mid + 1;
			}
			catch (IndexOutOfBoundsException e) {
				right = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] vs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		System.out.println(exists(vs, 16));
	}
}
