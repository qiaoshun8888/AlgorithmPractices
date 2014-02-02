package google.binarysearch;

/**
 * FindKthLargestNumberInTwoSortedArray.java
 * 
 * Description: Find Kth largest number in two sorted arrays.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 2, 2014
 */

public class FindKthLargestNumberInTwoSortedArray {

	public static int find(int[] vs1, int[] vs2, int k) {
		if (k <= 0)
			return -1;
		return findHelper(vs1, 0, vs1.length - 1, vs2, 0, vs2.length - 1, k);
	}

	private static int findHelper(int[] vs1, int left1, int right1, int[] vs2,
			int left2, int right2, int k) {
		if (left1 > right1) 
			return vs2[right2 - k + 1];
		if (left2 > right2) 
			return vs1[right1 - k + 1];

		int mid1 = left1 + ((right1 - left1) >> 1);
		int mid2 = left2 + ((right2 - left2) >> 1);
		
		int k0 = right1 - mid1 + right2 - mid2 + 1;
		
		if (k <= k0) {
			if (vs1[mid1] <= vs2[mid2])
				return findHelper(vs1, mid1 + 1, right1, vs2, left2, right2, k);
			else
				return findHelper(vs1, left1, right1, vs2, mid2 + 1, right2, k);
		}
		else {
			if (vs1[mid1] <= vs2[mid2])
				return findHelper(vs1, left1, right1, vs2, left2, mid2 - 1, k - (right2 - mid2 + 1));
			else
				return findHelper(vs1, left1, mid1 - 1, vs2, left2, right2, k - (right1 - mid1 + 1));
		}
	}

	public static void main(String[] args) {
		int[] vs1 = { 1, 4, 7, 10, 20 };
		int[] vs2 = { 5, 6, 8, 9, 22, 23, 27 };

		for (int i = 1; i <= vs1.length + vs2.length; i++) {
			System.out.println("k: " + i + " = " + find(vs1, vs2, i));
		}
	}
}
