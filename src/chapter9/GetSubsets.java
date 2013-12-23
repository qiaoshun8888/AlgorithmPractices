package chapter9;

import java.util.ArrayList;

public class GetSubsets {

	private static int called_times = 0;
	public static void subsets(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result_list) {
		called_times++;
		// Base case
		if (list.size() == 0 || list == null) {
			return;
		}
		
		// 1 2 3 -> 2 3, 1 3, 1 2
		// 1 2 3 4 -> 2 3 4, 1 3 4, 1 2 4, 1 2 3 -> 
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> l = new ArrayList<Integer>(list);
			l.remove(i);
			if (!result_list.contains(l)){
				result_list.add(l);
				subsets(l, result_list);
			}
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> result_list = new ArrayList<ArrayList<Integer>>();
		int max = 1 << list.size(); // 2^n
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = convertIntToSet(i, list);
			result_list.add(subset);
		}
		return result_list;
	}
	private static ArrayList<Integer> convertIntToSet(int i, ArrayList<Integer> list) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = i; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(list.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// list {1, 2, 3}
		for (int i = 0; i < 4; i++) {
			list.add(i+1);
		}
		
		/*
		ArrayList<ArrayList<Integer>> result_list = new ArrayList<ArrayList<Integer>>();
		subsets(list, result_list);
		result_list.add(list);
		*/
		
		ArrayList<ArrayList<Integer>> result_list = subsets2(list);
		
		System.out.println("size:[" + result_list.size() + "] called_times: " + called_times);
		for (ArrayList<Integer> l : result_list) {
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
