package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N42PrintSubsetOfArray {

	/**
	 * Print all size-K subset for an array
	 * 
	 * e.g {1, 2, 3}
	 * 
	 * all size-2 subsets are {1, 2}, {2, 3}, {1, 3}
	 * 
	 * */
	
	private static int calledTimes = 0;

	private static boolean advance(int[] index, int length) {
		int k = index.length - 1;
		while (k >= 0 && index[k] + 1 == length - (index.length - 1 - k)) {
			k--;
		}
		if (k < 0)
			return false;
		index[k]++;
		for (k++; k < index.length; k++) {
			calledTimes++;
			index[k] = index[k - 1] + 1;
		}
		return true;
	}

	private static Set<Integer> generateSet(int[] index, int[] vs) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : index) {
			calledTimes++;
			set.add(vs[i]);
		}
		return set;
	}

	// {1, 2, 3, 4, 5, 6, 7}
	public static List<Set<Integer>> subsets(int[] vs, int k) {
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();

		if (k == vs.length) {
			Set<Integer> set = new HashSet<Integer>();
			for (int i : vs) {
				set.add(i);
			}
			return list;
		}

		int[] index = new int[k];
		for (int i = 0; i < k; i++) {
			index[i] = i;
		}

		do {
			list.add(generateSet(index, vs));
		} while (advance(index, vs.length));

		return list;
	}

	// ============================================
	// Method 2 - Recursion
	static void PrintAllSizeKSubset(int[] array, boolean[] used,
			int startIndex, int currentSize, int K) {
		calledTimes++;
		// firstly define when the recursion stops
		// case 1, the currentSize equals K, we print out
		if (currentSize == K) {
			for (int i = 0; i < array.length; i++) {
				if (used[i]) {
					System.out.print(array[i] + " ");
				}
			}
			System.out.println();// add a new line
			return;// do not forget to stop the recursion!
		}
		// case 2, focusIndex exceeds array length
		if (startIndex == array.length)
			return;
		// now it's the key recursion step as illustrated in our slides' example
		// firstly we select this index
		used[startIndex] = true;
		PrintAllSizeKSubset(array, used, startIndex + 1, currentSize + 1, K);// key
																				// is
																				// +1
		// or 2nd option is to not using this index
		used[startIndex] = false;
		PrintAllSizeKSubset(array, used, startIndex + 1, currentSize, K);
		// please notice index is increamented no matter we select or not!
	}

	public static void main(String[] args) {
		int[] vs = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
		// int[] vs = { 1, 2, 3, 4};
		
		/*
		int MAX = 1000;
		int [] vs = new int[MAX];
		for (int i = 1; i < MAX; i++) {
			vs[i] = i;
		}
		*/
		
		int K = 5;
		List<Set<Integer>> list = subsets(vs, K);
		System.out.println("Results size is: " + list.size());
		System.out.println("calledTimes: " + calledTimes);
		for (Set<Integer> s : list) {
			System.out.print(s + "  ");
		}
		
		System.out.println("\n\n ======== ");
		calledTimes = 0;
		boolean[] used = new boolean[vs.length];
		PrintAllSizeKSubset(vs, used, 0, 0, K);
		System.out.println("calledTimes: " + calledTimes);
	}
}
