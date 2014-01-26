package google.arrays;

import java.util.*;

/**
 * FindAllSetsOfThreeNumbersWithAGivenSum.java
 * 
 * Description: Given an array with integers and a number n, design an algorithm
 * and write code to print all pairs of numbers that sum to this number.
 * 
 * FOLLOW UP: Find all sets of THREE nubmers that summed to this value.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 26, 2014
 */

public class FindAllSetsOfThreeNumbersWithAGivenSum {

	static class ThreeNum {
		int a, b, c;
		public ThreeNum(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return a + " + " + b + " + " + c + " = " + (a + b + c);
		}
	}
	
	public static ArrayList<ThreeNum> search(int [] vs, int target) {
		ArrayList<ThreeNum> result = new ArrayList<ThreeNum>();
		if (vs == null || vs.length == 0) return result;
		
		Arrays.sort(vs);
		
		for (int i = 0; i < vs.length; i++) {
			int a = vs[i], left = i + 1, right = vs.length - 1;
			while (left < right) {
				int sum = a + vs[left] + vs[right];
				if (sum == target) {
					result.add(new ThreeNum(a, vs[left++], vs[right--]));
				}
				else if (sum > target) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int [] vs = {1,2,3,4,5,6,7,7,8,9,10};
		int target = 12;
		ArrayList<ThreeNum> result = search(vs, target);
		for (ThreeNum o : result) {
			System.out.println(o);
		}
	}
}
