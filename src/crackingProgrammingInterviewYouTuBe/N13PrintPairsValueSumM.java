package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.List;

public class N13PrintPairsValueSumM {

	
	/**
	 * Print all pairs of values in a sorted array that sum up to a given value M.
	 * 
	 * */
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
	
	/**
	 * {1, 2, 3, 4, 5, 6, 7}
	 * M = 9
	 * */
	public static List<Pair> printList(int [] vs, int M) {
		List<Pair> list = new ArrayList<Pair>();
		
		int left = 0, right = vs.length - 1;
		
		while (left < right) {
			int sum = vs[left] + vs[right];
			if (sum > M) right--;
			else if (sum < M) left++;
			else {
				list.add(new Pair(vs[left++], vs[right--]));
			}
		}
		return list;
	}
	
	public static void main(String [] args) {
		int M = 19;
		int [] vs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 17, 20, 22, 25};
		List<Pair> list = printList(vs, M);
		
		StringBuilder sb = new StringBuilder();
		for (Pair p : list) {
			sb.append(p + " ");
		}
		System.out.println(sb);
	}
}
