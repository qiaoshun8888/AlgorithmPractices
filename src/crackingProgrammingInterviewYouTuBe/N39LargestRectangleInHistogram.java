package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

public class N39LargestRectangleInHistogram {

	/**
	 * Find the largest rectangle in a histogram in linear time
	 * 
	 * */

	public static int LargestRectangle(int[] histos) {
		// firstly define two stacks, one for heights the other for indexes
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		int largestSize = 0;// the return value

		// now process histos one by one
		for (int i = 0; i < histos.length; i++) {
			// case 1, the height is larger thus can be candidate of rectangle
			// start
			if (heights.isEmpty() || histos[i] > heights.peek()) {
				heights.push(histos[i]);
				indexes.push(i);
			} else if (histos[i] < heights.peek()) {
				// if the current height is shorter, thus we need pop those
				// longer heights
				// and compute the candidate rectangle's area size
				int lastIndex = 0;
				// this index to keep track of the last index which
				// will be replacing the current index for current height
				// inserting

				while (!heights.isEmpty() && histos[i] < heights.peek()) {
					// we need compute the size
					lastIndex = indexes.pop();
					int tempAreaSize = heights.pop() * (i - lastIndex);
					if (largestSize < tempAreaSize)
						largestSize = tempAreaSize;// update largest area size
													// if necessary
				}

				// after popping those unqualified start positions including
				// current index, add current
				heights.push(histos[i]);
				indexes.push(lastIndex);// notice this is not i but lastIndex,
										// check our demo for why

			}
		}

		// after the process, there may still be values in stacks, pop out each
		// and test size
		while (!heights.isEmpty()) {
			// we need compute the size
			int tempAreaSize = heights.pop() * (histos.length - indexes.pop());// the
																				// width=currentIndex(last
																				// one)
																				// -
																				// stored
																				// index
			if (largestSize < tempAreaSize)
				largestSize = tempAreaSize;// update largest area size if
											// necessary
		}

		return largestSize;
	}

	public static void main(String[] args) {
		int [] histos = {3, 4, 2, 3, 4}; // use demo example, expect 6
		System.out.println("Largest rectangle size is "
				+ LargestRectangle(histos));

		int[] histos2 = { 2, 4, 2, 1, 10, 6, 10 };// this time expect 18, with
													// height 6 and width spans
													// last 3 nodes
		System.out.println("Largest rectangle size is "
				+ LargestRectangle(histos2));
	}
}
