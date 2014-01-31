package leetcode;

/**
 * JumpGame.java
 * 
 * Description: Given an array of non-negative integers, you are initially
 * positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * 
 * A = [2,3,1,1,4], return true. 
 * A = [3,2,1,0,4], return false.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class JumpGame {

	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) return true;
		return canJumpHelper(A, 0);
	}
	private boolean canJumpHelper(int [] vs, int index) {
		if (index == vs.length - 1) return true;
		if (index >= vs.length || vs[index] == 0) return false;
		
		for (int i = vs[index]; i > 0; i--) {
			if(canJumpHelper(vs, index + i)) return true;
		}
		
		return false;
	}
	
	public boolean canJumpImprove(int [] vs) {
		if (vs == null || vs.length == 0) return true;
		
		int max = 0;
		
		for (int i = 1; i < vs.length; i++) {
			if (i - max <= vs[max]) {
				if (max + vs[max] < i + vs[i]) max = i;
			}
			else return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) {
//		int [] vs = {3,2,1,0,4};
		int [] vs = {2,3,1,1,4};
//		int [] vs = {4,4,3,2,2,2,1,2};
		JumpGame o = new JumpGame();
		System.out.println(o.canJumpImprove(vs));
	}
}
