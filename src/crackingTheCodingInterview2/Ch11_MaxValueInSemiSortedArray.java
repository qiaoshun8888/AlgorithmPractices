package crackingTheCodingInterview2;

public class Ch11_MaxValueInSemiSortedArray {

	/**
	 * Find the max value in an array. The array is "semi-sorted".
	 * 
	 * Here is an example: { 1 3 4 7 9 10 12 13 12 6 3 }
	 * 
	 * As you can see, the array increases and then decreases at one point (13).
	 * 
	 * */
	
	public static int maxValue(int [] vs) {
		return binarySearch(vs, 0, vs.length - 1);
	}
	
	private static int binarySearch(int [] vs, int left, int right) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (vs[mid] > vs[mid - 1] && vs[mid] > vs[mid + 1]) return vs[mid];
			else if (vs[mid] > vs[mid - 1]) {
				return binarySearch(vs, mid + 1, right);
			}
			else {
				return binarySearch(vs, left, mid - 1);
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String [] args) {
		int [] vs = {1, 3, 4, 7, 9, 10, 12, 13, 12, 6, 3};
		System.out.println(maxValue(vs));
	}
}
