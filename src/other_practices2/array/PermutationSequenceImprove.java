package other_practices2.array;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceImprove {

	/*
	 * The set [1,2,3,É,n] contains a total of n! unique permutations.
	 * 
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth
	 * permutation sequence.
	 * 
	 * Note: Given n will be between 1 and 9 inclusive.
	 */

	/*
	 * Actually there is O(n) solution. From pure mathematical view, for example
	 * we want to find k-th sequence of length n, basically let a[1]Éa[n] denote
	 * the k-th sequence, think about this: except a[1] there are totally (n-1)!
	 * different permutations for a[2]Éa[n], then a[1] = k / (n-1)! and we need
	 * to find k % (n-1)! -th element is the a[2]É[an] sequence, this is
	 * recursively the same problem. Just be careful when dealing with some
	 * border cases like k is exactly (n-1)! or 3 * (n-1)! sort of these cases.
	 */
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		k = (k - 1) % factorial(n);
		int[] result = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int f = factorial(i);
			int d = k / f;
			k = k % f;
			result[n - i - 1] = list.remove(d);
		}
		StringBuilder sb = new StringBuilder();
		for (int r : result)
			sb.append(r);
		return sb.toString();
	}

	private int factorial(int n) {
		int f = 1;
		while (n > 1) {
			f *= n--;
		}
		return f;
	}

	public static void main(String[] args) {
		int n = 3, k = 2;
		PermutationSequenceImprove o = new PermutationSequenceImprove();
		System.out.println(o.getPermutation(n, k));
	}
}
