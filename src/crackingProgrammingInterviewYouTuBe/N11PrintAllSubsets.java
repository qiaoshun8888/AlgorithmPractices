package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.List;

public class N11PrintAllSubsets {

	private static int called_times = 0;
	
	/**
	 * Print all subsets of an array
	 * 
	 * */
	
	/*
	 * Array: {e1, e2}
	 * Subsets: {}, {e1}, {e2}, {e1, e2}
	 * 
	 * Each element could show up (1) or not (0):
	 * 
	 * {} 		-> 	0 0
	 * {e1} 	-> 	1 0
	 * {e2}		->	0 1
	 * {e1, e2}	->	1 1
	 * 
	 * */
	public static List<List<String>> subsets(List<String> list) {
		// 1 1 1 ~ 0 0 0    (2^N)
		int i = (1 << list.size()) - 1;
		List<List<String>> result_list = new ArrayList<List<String>>();
		while (i >= 0) {
			int index = 0, runner = i;
			List<String> l = new ArrayList<String>();
			while (runner != 0) { // 1 1 1
				called_times++;
				// System.out.println(Integer.toBinaryString(runner) + "  " + index);
				if ((runner & 1) > 0) l.add(list.get(index));
				runner >>= 1;  // 1 1
				index++; // 0 -> 1
			}
			result_list.add(l);
			i--;
		}
		return result_list;
	}
	
	public static void main(String [] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		List<List<String>> result_list = subsets(list);
		System.out.println("==== Subsets size: " + result_list.size() + "  called_times: " + called_times);
		for (List<String> l : result_list) {
			System.out.print("- ");
			for (String s : l) {
				System.out.printf("%2s", s);
			}
			System.out.println();
		}
	}
}
