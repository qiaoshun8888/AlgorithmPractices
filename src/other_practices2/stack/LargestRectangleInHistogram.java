package other_practices2.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	/*
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 */

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int largestArea = Integer.MIN_VALUE, area = 0, topIndex = -1;
		Stack<Integer> stack = new Stack<Integer>();
		// 6, 2, 5, 4, 5, 2, 6
		for (int i = 0, v = 0; i < height.length;) {
			v = height[i]; // the height of the current bar.
			if (stack.isEmpty() || v >= height[stack.peek()]) {
				// We increase i here so that when the current bar is less than
				// the one on the top of the stack, i won't be increased. Then
				// after we poped the old top one we can continue to check if
				// the new top one if greater or less than current bar. We stop
				// doing this util we find the bar in the stack that less than
				// current bar.
				stack.push(i++);
			}
			else {
				topIndex = stack.pop();
				// Use the poped one as the minimum bar to calculate the area.
				// The area is equal: (the right index of the bar that less than
				// current one - the left index of the bar that less than
				// current one - 1) * the height of the current minimum bar.
				area = (stack.isEmpty() ? i : i - stack.peek() - 1)
						* height[topIndex];
				largestArea = Math.max(largestArea, area);
			}
		}
		int index = height.length;
		while (!stack.isEmpty()) {
			topIndex = stack.pop();
			area = (stack.isEmpty() ? index : index - stack.peek() - 1)
					* height[topIndex];
			largestArea = Math.max(largestArea, area);
		}
		return largestArea;
	}

	public static void main(String[] args) {
		int[] height = { 6, 2, 5, 4, 5, 1, 6 };
		// int[] height = { 2, 1, 5, 6, 2, 3 };
		LargestRectangleInHistogram o = new LargestRectangleInHistogram();
		System.out.println(o.largestRectangleArea(height));
	}
}
