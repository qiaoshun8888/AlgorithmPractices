package crackingProgrammingInterviewYouTuBe;

public class N18CountRotationsNumberOfSortedArray {

	/**
	 * Count how many rotations happen to a rotated sorted array.
	 * 
	 * e.g. {3, 4, 5, 1, 2}, return 3
	 *       ^  ^  ^
	 *       1  2  3
	 * */
	
	public static int countRotations(int [] vs) {
		return binarySearch(vs, 0, vs.length - 1);
	}
	/**
	 * test case
	 * 4 7 9 10 2
	 *     ^
	 * 7 9 4 5 6   
	 *  
	 * */
	private static int binarySearch(int [] vs, int low, int high) {
		if (low > high) return -1;
		
		int mid = (low + high) /2;
		
		if (mid > 0 && vs[mid] < vs[mid - 1]) {
			return mid;
		}
		else {
			// check rotation happened in the left or right
			if (vs[mid] > vs[high]) return binarySearch(vs, mid + 1, high);
			else return binarySearch(vs, low, mid - 1);
		}
	}
	
	public static int binarySearchNoRecursive(int [] vs) {
		int low = 0, high = vs.length - 1, mid = 0;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if (mid > 0 && vs[mid] < vs[mid - 1]) return mid;
			// if vs[mid] > vs[high], that means rotation happened in the right, otherwise in the left.
			if (vs[mid] > vs[high]) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String [] args) {
		// int [] vs = {4, 7, 9, 10, 2};
		// int [] vs = {7, 9, 4, 5, 6};
		// int [] vs = {4, 5, 6, 1, 2};
		int [] vs = {1, 2, 3, 4, 5, 6};
		System.out.println(countRotations(vs));
		System.out.println(binarySearchNoRecursive(vs));
	}
}
