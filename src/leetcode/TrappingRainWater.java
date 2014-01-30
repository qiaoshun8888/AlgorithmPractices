package leetcode;

/**
 * TrappingRainWater.java
 * 
 * Description: Given n non-negative integers representing an elevation map
 * where the width of each bar is 1, compute how much water it is able to trap
 * after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 30, 2014
 */

public class TrappingRainWater {

	public int trap(int[] A) {
		if (A == null || A.length == 0) return 0;
		int [] leftHeights = new int[A.length];
		int maxHeight = A[0];
		for (int i = 0; i < A.length; i++) {
			int v = A[i];
			maxHeight = v > maxHeight ? v : maxHeight;
			leftHeights[i] = maxHeight;
		}
		maxHeight = A[A.length - 1];
		int water = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			int v = A[i];
			if (v < Math.min(maxHeight, leftHeights[i])) {
				water += Math.min(maxHeight, leftHeights[i]) - v;
			}
			maxHeight = Math.max(maxHeight, v);
		}
		return water;
	}
	
	public static void main(String[] args) {
		int [] vs = {0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater o = new TrappingRainWater();
		System.out.println(o.trap(vs));
	}
}
