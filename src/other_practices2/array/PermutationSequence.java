package other_practices2.array;

import java.util.Arrays;

public class PermutationSequence {

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

	public String getPermutation(int n, int k) {
		// call k times nextPermutation
		int[] vs = new int[n];
		for (int i = 1; i <= n; i++) {
			vs[i - 1] = i;
		}
		for (int i = 1; i < k; i++) {
			nextPermutation(vs);
		}
		return Arrays.toString(vs);
	}

	private void nextPermutation(int[] vs) {
		int largest = vs[vs.length - 1];
		int index_low = -1;
		// find the elem that breaks the increasing order from the end of the
		// array
		for (int i = vs.length - 2; i >= 0; i--) {
			if (vs[i] < largest) {
				index_low = i;
				break;
			}
			largest = vs[i];
		}
		// if it's already the greatest order, that means the elems in the array
		// are in increasing order from the end to the front.
		if (index_low == -1) {
			// for this question, we don't need to do anything for this case.
			return;
		}
		// find the elem that larger than the elem in index_low
		int index_high = -1;
		for (int i = vs.length - 1; i > index_low; i--) {
			if (vs[i] > vs[index_low]) {
				index_high = i;
				break;
			}
		}
		// swap the index_low and index_high
		swap(vs, index_low, index_high);
		// order the elems on the right side of index_low, which starts from
		// index_low + 1 to vs.length - 1.
		quickSort(vs, index_low + 1, vs.length - 1);
	}

	private void quickSort(int[] vs, int left, int right) {
		if (left >= right)
			return;
		int[] indexes = partition(vs, left, right);
		if (left < indexes[1]) {
			quickSort(vs, left, indexes[1]);
		}
		if (right > indexes[0]) {
			quickSort(vs, indexes[0], right);
		}
	}

	private int[] partition(int[] vs, int left, int right) {
		// pick the pivot
		int mid = left + (right - left) / 2;
		int pivot = vs[mid];
		while (left <= right) {
			// find the elem that greater than the pivot
			while (vs[left] < pivot) {
				left++;
			}
			// find the elem that smaller than the pivot
			while (vs[right] > pivot) {
				right--;
			}
			// swap the two elems
			if (left <= right) {
				swap(vs, left++, right--);
			}
		}
		return new int[] { left, right };
	}

	private void swap(int[] vs, int a, int b) {
		if (a != b) {
			vs[a] ^= vs[b];
			vs[b] ^= vs[a];
			vs[a] ^= vs[b];
		}
	}

	public static void main(String[] args) {
		int n = 3, k = 4;
		PermutationSequence o = new PermutationSequence();
		System.out.println(o.getPermutation(n, k));
	}
}
