package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_Subsets {

	/**
	 * Get all subsets of the given set
	 * 
	 * e.g.
	 * 
	 * 		{1, 2, 3}
	 * 
	 * 		{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
	 * 
	 * */
	
	private static int calledTimes = 0;
	
	public static void subsets(List<Integer> list, List<List<Integer>> resultList) {
		calledTimes++;
		if (list == null || list.size() == 0) return;
		if (resultList.size() == 0 && list.size() != 0) resultList.add(list);
		
		for (int i = 0; i < list.size(); i++) {
			List<Integer> tempList = new ArrayList<Integer>(list);
			tempList.remove(i);
			if (!resultList.contains(tempList)) {
				resultList.add(tempList);
				subsets(tempList, resultList);
			}
		}
	}
	
	
	public static void main(String [] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i + 1);
		}
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		subsets(list, resultList);
		
		System.out.println("size:[" + resultList.size() + "] called_times: " + calledTimes);
		for (List<Integer> l : resultList) {
			System.out.print("{");
			int i = 0;
			for (int v : l) {
				System.out.print((i == 0 ? "" : ", ") + v);
				i++;
			}
			System.out.print("} ");
		}
	}
}
