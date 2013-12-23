package crackingProgrammingInterviewYouTuBe;

public class N12MergeShortSortedArrayToLarger {

	/**
	 * Merge a short sorted array to the larger sorted array, given the larger
	 * one has space at its end.
	 * 
	 * */

	/*
	 * Short array: {2, 4, 6} Long array: {1, 3, 5, 7, 9, 11, 13, 15, 17, _, _,
	 * _, _, ...}
	 */
	public static int[] merge(int[] long_array, int[] short_array, int length_la) {
		int index_sa = short_array.length - 1, index_la = length_la - 1;
		int index = index_la + index_sa + 1;
		/**
		 * Case 1: All the elements in short array are greater than the first
		 * element in the long array.
		 * 
		 * Case 2: There is some element in short array less than the first
		 * element in the long array.
		 * 
		 * {1, 3, 5, 7, 9, _ _ _ _ ...}
		 * 				^
		 * 				| index_la
		 * 
		 * {2, 4, 6}
		 *  	  ^
		 *  	  | index_sa
		 *  
		 * { _ _ _ _ _ _ _ _ _ _ _ ...}
		 *   0 1 2 3 4 5 6 7 8 9 10
		 *                 ^
		 *                 | index              
		 * */
		while (index >= 0 && index_la >= 0) {
			if (index_sa >= 0
					&& (long_array[index_la] <= short_array[index_sa])) {
				long_array[index--] = short_array[index_sa--];
			} else {
				long_array[index--] = long_array[index_la--];
			}
		}

		while (index_sa >= 0) {
			long_array[index--] = short_array[index_sa--];
		}
		return long_array;
	}

	public static void main(String[] args) {
		int[] long_array = new int[50];
		int N = 5;
		for (int i = 0; i < N; i++) {
			long_array[i] = i * 2 + 1;
		}
		int[] short_array = { 2, 4, 6 };

		long_array = merge(long_array, short_array, N);
		for (int i = 0; i < N + short_array.length; i++) {
			System.out.printf("%3d", long_array[i]);
		}
	}
}
