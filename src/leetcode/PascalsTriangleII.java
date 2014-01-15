package leetcode;

import java.util.*;

public class PascalsTriangleII {

	/**
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 * 
	 * */

	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (rowIndex == 0) {
            result.add(1);
            return result;
        }

		result.add(1);
		result.add(1);

		if (rowIndex == 1) {
			return result;
		}

		for (int i = 2; i <= rowIndex; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(result);
			result.add(1);
			// 1 1
			// 1 2 1
			// 1 2 1 1
			for (int j = 1; j <= result.size() - 2; j++) {
				result.set(j, temp.get(j - 1) + temp.get(j));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int n = 4;
		ArrayList<Integer> list = getRow(n);
		for (int v : list) {
			System.out.print(v + " ");
		}
	}
}
