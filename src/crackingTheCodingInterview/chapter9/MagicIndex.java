package crackingTheCodingInterview.chapter9;

import java.util.ArrayList;

public class MagicIndex {

	// 0 1 2 3 4 5 6
	// 1 3 2 5 4 6 0
	// _ _ ^ _ ^
	
	public static ArrayList<Integer> getMagicIndex(int [] vs) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < vs.length; i++) {
			if (vs[i] == i) list.add(i);
		}
		return list;
	}
	
	// 0, 1, 2, 3, 5, 6, 8, 9
	// 0  1  2  3  4  5  6  7
	// Time: O(logN)
	public static int getMagicIndex2(int [] vs) {
		int [] v = new int[vs.length];
		int step = vs.length - 1;
		// If the last one is magic index, then all of the elements in the array are magic index
		if (step == vs[step]) return step;
		boolean move_right = false, move_right_temp = false;
		step /= 2;
		int index = step;
		while (true) {
			// on the left
			if (index != vs[index]) {
				index -= step;
				move_right = false;
			}
			// on the right
			else {
				index += step;
				move_right = true;
			}
			System.out.print(vs[index] + "(" + (move_right ? ">" : "<") + step + ") ");
			if (move_right_temp != move_right && step == 1) {
				return move_right ? index : index;
			}
			
			move_right_temp = move_right;
			
			step /= 2; step = step < 1 ? 1: step;
		}
	}
	
	public static int getMagicIndexFast(int [] vs, int start, int end) {
		if (end < start || end >= vs.length || start < 0) return -1;
		int mid = (start + end) / 2;
		if (vs[mid] == mid) return vs[mid];
		else if(vs[mid] > mid) return getMagicIndexFast(vs, start, mid - 1);
		else return getMagicIndexFast(vs, mid + 1, end);
	}
	
	public static int getMagicIndexNotDistinctNumber(int [] vs, int start, int end) {
		if (end < start || start >= vs.length || end < 0) return -1;
		
		int mid_index = (start + end) / 2;
		int mid_value = vs[mid_index];
		if (mid_index == mid_value) return mid_value;
		
		int left_index = Math.min(mid_index - 1, mid_value);
		int left = getMagicIndexNotDistinctNumber(vs, start, left_index);
		if (left >= 0) return left;
		
		int right_index = Math.max(mid_index + 1, mid_value);
		return getMagicIndexNotDistinctNumber(vs, right_index, end);
	}
	
	public static void main(String [] args) {
		int [] vs = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 14, 17, 18, 19, 20, 21, 22}; // sorted array
		ArrayList<Integer> list = MagicIndex.getMagicIndex(vs);
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int index = MagicIndex.getMagicIndex2(vs);
		System.out.println();
		System.out.println("index from 0->" + index + " are magic numbers");
		
		System.out.println();
		int [] vs2 = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		System.out.println("getMagicIndexFast: " + getMagicIndexFast(vs2, 0, vs2.length - 1));
		
		System.out.println();
		int [] vs3 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println("getMagicIndexNotDistinctNumber: " + getMagicIndexNotDistinctNumber(vs3, 0, vs3.length - 1));
	}
}
