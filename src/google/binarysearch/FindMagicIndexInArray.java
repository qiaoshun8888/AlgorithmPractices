package google.binarysearch;

/**
 * FindMagicIndexInArray.java
 * 
 * Description: AmagicindexinanarrayA[l...n-l] is defined to be an index such
 * that A[i] = i. Given a sorted array of distinct integers, write a method to
 * find a magic index, if one exists, in array A. 
 * 
 * FOLLOW UP What if the values are not distinct?
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 27, 2014
 */

public class FindMagicIndexInArray {

	public static int find(int [] vs) {
		if (vs == null || vs.length == 0) return -1;
		return findHelper(vs, 0, vs.length -1);
	}
	private static int findHelper(int [] vs, int left, int right) {
		if (left > right) return -1;
		int mid = left + (right - left) / 2;
		if (vs[mid] == mid) return mid;
		
		int index = findHelper(vs, left, mid - 1);
		return index != -1 ? index : findHelper(vs, mid + 1, right);
	}
	
	public static void main(String[] args) {
		int [] vs = new int[]{-4, -1, 1, 2, 3, 4, 5, 6, 8};
		System.out.println(find(vs));
		// Follow up 
		vs = new int[]{-1, 1, 2, 3, 3, 4, 5, 6, 8};
		System.out.println(find(vs));
	}
}
