package other_practices1;

import java.util.HashSet;
import java.util.Set;

public class Permutations {

	private static int called_times = 0;
	
	/**
	 * 1 - 1
	 * 
	 * 1 2 - {1, 2} {2, 1}
	 * 
	 * 1 2 3 - {1, 2, 3} {1, 3, 2} {2, 1, 3} {2, 3, 1} {3, 1, 2} {3, 2, 1}
	 * 
	 * From above, we can see {1, 2}'s permutations come from {1} and add '2' in
	 * front of the at the end of '1'. _ 1 _
	 * 
	 * {1, 2, 3}'s permutations come from {1, 2}'s permutations {1, 2} {2, 1}
	 * and add '3' in each of the sets. {_, 1, _, 2, _} {_, 2, _, 1, _}
	 * There are six slots.
	 * 
	 * N numbers of element's permutation are N!.
	 * */
	
	// Time: SUM{(N-1) * N!}  (N = 1, 2, 3...)
	public static Set<String> generatePermutations(int n) {
		// Base case, n == 1
		if (n == 1) {
			called_times++;
			Set<String> set = new HashSet<String>();
			set.add("1");
			return set;
		}
		// Get n-1 's permutations and generate n's permutations.
		Set<String> set = generatePermutations(n - 1);
		Set<String> n_set = new HashSet<String>();
		for (String s : set) {
			char [] cc = s.toCharArray();
			for (int i = 0; i <= cc.length; i++) {
				n_set.add(combined(cc, n, i));
			}
		}
		return n_set;
	}
	private static String combined(char [] cc, int n, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cc.length; i++) {
			called_times++;
			if (i == index) sb.append(n);
			sb.append(cc[i]);
		}
		if (index == cc.length) {
			sb.append(n);
		}
		return sb.toString();
	}
	
	public static void main(String [] args) {
		Set<String> set = generatePermutations(5);
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println("========= called_times: " + called_times);
	}
}
