package google.binarysearch;

/**
 * MergeTwoSortedArrayWithoutDuplicates.java
 * 
 * Description: Write code to merge two arrays in sorted order such that if an
 * integer is in both arrays, it only gets put into the new array once.
 * 
 * Follow up: What if you knew that one array was much longer than the other? Could you optimize it?
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 25, 2014
 */

public class MergeTwoSortedArrayWithoutDuplicates {

	// 1, 2, 2, 3, 4
	// 2, 3, 3, 4, 5
	// Output: 1, 2, 2, 3, 3, 4, 5
	public static int[] merge(int[] vs1, int[] vs2) {
		if (vs1 == null) return vs2;
		if (vs2 == null) return vs1;
		
		int [] vs3 = new int[vs1.length + vs2.length];
		
		int i = 0, j = 0, length = 0;
		while (i < vs1.length && j < vs2.length) {
			if (vs1[i] < vs2[j]) {
				vs3[length++] = vs1[i++];
			}
			else if (vs1[i] > vs2[j]) {
				vs3[length++] = vs2[j++];
			}
			else {
				vs3[length++] = vs1[i++];
				j++;
			}
		}
		
		while (i < vs1.length) {
			vs3[length++] = vs1[i++];
		}
		
		while (j < vs2.length) {
			vs3[length++] = vs2[j++];
		}
		
		int [] result = new int[length];
		for (int k = 0; k < length; k++) {
			result[k] = vs3[k];
		}
		
		return result;
	}
	
	// What if you knew that one array was much longer than the other? Could you optimize it?
	public static int[] mergeImprove(int[] vs1, int[] vs2) {
		if (vs1 == null) return vs2;
		if (vs2 == null) return vs1;
		
		// *** We assume that vs1 is the longer one.
		
		// binary search vs2[i] in vs1 for i from 0 to vs2.length - 1
		int [] vs3 = new int[vs1.length + vs2.length];
		int length = 0, i = 0;
		for (int j = 0; j < vs2.length;) {
			if (i < vs1.length) {
				int x = vs2[j];
				int temp = binarySearchInsertionPoint(vs1, i, vs1.length - 1, x);
				// copy from i to temp
				for (int k = i; k < temp; k++) {
					vs3[length++] = vs1[k];
				}
				if (vs1[temp] < vs2[j]) {
					vs3[length++] = vs1[temp++];
				}
				else if (vs1[temp] > vs2[j]) {
					vs3[length++] = vs2[j++];
				}
				else {
					vs3[length++] = vs1[temp++];
					j++;
				}
				i = temp;
			}
			else {
				vs3[length++] = vs2[j];
			}
		}
		
		while (i < vs1.length) {
			vs3[length++] = vs1[i++];
		}
		
		int [] result = new int[length];
		for (int k = 0; k < length; k++) {
			result[k] = vs3[k];
		}
		
		return result;
	}
	private static int binarySearchInsertionPoint(int [] vs, int left, int right, int x) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (vs[mid] == x) {
				if (left == mid) return left;
				return binarySearchInsertionPoint(vs, left, mid, x);
			}
			else if (vs[mid] > x) return binarySearchInsertionPoint(vs, left, mid - 1, x);
			else return binarySearchInsertionPoint(vs, mid + 1, right, x);
		}
		return x < vs[left] ? left : right;
	}
	
	public static void main(String[] args) {
		int [] vs1 = {1, 1, 2, 2, 2, 3, 4, 5, 7, 8, 9, 10, 11, 15, 18};
		int [] vs2 = {2, 3, 3, 4, 4, 6, 6, 9};
		
//		int [] vs1 = {1, 3, 5, 7, 9};
//		int [] vs2 = {0, 2, 4, 6, 8};
		
		for (int v : merge(vs1, vs2)) {
			System.out.print(v + " ");
		}
		
		System.out.println();
		
		for (int v : mergeImprove(vs1, vs2)) {
			System.out.print(v + " ");
		}
	}
}
