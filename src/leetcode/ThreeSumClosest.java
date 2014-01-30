package leetcode;

import java.util.Arrays;

/**
 * ThreeSumClosest.java
 * 
 * Description: Given an array S of n integers, find three integers in S such
 * that the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one
 * solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 30, 2014
 */

public class ThreeSumClosest {

	public static int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) return 0;
		
		Arrays.sort(num);
		
        int n = Integer.MAX_VALUE, v = 0;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                int temp = num[i] + num[left] + num[right];
                
                if (Math.abs(temp - target) < n) {
                    n = Math.abs(temp - target);
                    v = temp;
                }
                
                if (temp < target) left++;
                else if (temp > target) right--;
                else {
                	left++; right--;
                }
            }
        }
        return v;
    }
	
	public static void main(String[] args) {
		int [] vs = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(threeSumClosest(vs, target));
	}
}
