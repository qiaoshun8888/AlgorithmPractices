package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsOfSubstractions {

	/**
	 * Given a unsorted array of distinct integers, find each pair whose
	 * subtraction result equals to target value. 
	 * 
	 * For example, 
	 * Given [5, 7, 8, 10, 12] and target value 2, 
	 * return [5, 7], [8, 10], [10, 12].
	 * 
	 */
	
	static class Pair {
		int x, y;
		
		public Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	public ArrayList<Pair> pairSofSbustractions(int[] vs, int target) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		Arrays.sort(vs);
		
		for (int i = 0 ; i < vs.length - 1; i++) {
			int x = vs[i];
			for (int j = i + 1; j < vs.length; j++) {
				if (vs[j] - x < target) continue;
				else if (vs[j] - x == target) result.add(new Pair(x, vs[j]));
				else break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] vs = {5, 7, 8, 10, 12};
		int target = 2;
		
		PairsOfSubstractions o = new PairsOfSubstractions();
		ArrayList<Pair> result = o.pairSofSbustractions(vs, target);
		for (Pair p : result) {
			System.out.print(p + " ");
		}
	}
}
