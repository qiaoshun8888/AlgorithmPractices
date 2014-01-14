package leetcode;

public class ContainerWithMostWater {

	/*      |
		|   |           |
		|   |       |   |
		|   |   |   |   |
		|   |   |   |   |
		-----------------
		1   2   3   4   5
	*/
	
	/**
	 * Prove of the correctness:
	 * 
	 * Because the contain volume is decided by the shorter line between two.
	 * Since i is lower than j, so there will be no jj < j that make the area
	 * from i,jj is greater than area from i,j so the maximum area that can
	 * benefit from i is already recorded.thus, we move i forward.
	 * 
	 * */
	public static int maxAreaImproved(int[] height) {
		int maxArea = 0, left = 0, right = height.length - 1;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			if (area > maxArea)
				maxArea = area;
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

	public static int maxAreaNaive(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = 1; j < height.length; j++) {
				int area = Math.min(height[i], height[j]) * (j - i);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 3, 7, 2, 7, 4 };
		System.out.println("Max area is(Improved): " + maxAreaImproved(height));
		System.out.println("Max area is(Naive): " + maxAreaNaive(height));
	}
}
