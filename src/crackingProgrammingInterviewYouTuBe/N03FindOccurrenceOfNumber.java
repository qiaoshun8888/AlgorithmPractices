package crackingProgrammingInterviewYouTuBe;

/**
 * Find Occurrence of a number in a sorted array allowing duplicates
 * 
 * 1 2 2 2 3 4
 * 
 * */

public class N03FindOccurrenceOfNumber {

	/**
	 * We use binary search find the index of the desired integer x, then we
	 * search both sides of the index to count the occurrence.
	 * 
	 * BinarySearch needs O(log(N)) time to locate the index. To count the
	 * occurrence, we need O(N) in the worst case, which all the number in the
	 * array are the same and equal to the integer x.
	 * */
	public static int getOccurrence(int[] vs, int x) {
		int index = binarySearch(vs, x, 0, vs.length - 1);
		int left = index, right = index, count = 0;
		// search two sides
		while ((left >= 0 && vs[left] == x)
				|| (right <= vs.length - 1 && vs[right] == x)) {
			if (left >= 0 && vs[left--] == x)
				count++;
			if (right <= vs.length - 1 && vs[right++] == x)
				count++;
		}
		return count - 1; // at first, because left == right, we count one more time.
	}

	private static int binarySearch(int[] vs, int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (vs[mid] == x)
			return mid;
		else if (vs[mid] > x)
			return binarySearch(vs, x, low, mid - 1);
		else
			return binarySearch(vs, x, mid + 1, high);
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 2, 2, 3 };
		System.out.println(getOccurrence(vs, 3));
	}
}
