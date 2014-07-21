package other_practices2.array;

import java.util.Arrays;

public class NextPermutation {

	/*
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
	 * 1,2,3 1,1,5 → 1,5,1
	 */

	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0)
			return;
		int largest = num[num.length - 1];
		int index_low = -1;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < largest) {
				index_low = i;
				break;
			}
			largest = num[i];
		}
		// already in the greatest order
		if (index_low == -1) {
			Arrays.sort(num);
		} else {
			int index_high = -1;
			for (int i = num.length - 1; i > index_low; i--) {
				if (num[i] > num[index_low]) {
					index_high = i;
					break;
				}
			}
			// swap the numbers in index_low & index_high
			swap(num, index_low, index_high);
			quickSort(num, index_low + 1, num.length - 1);
		}
	}

	private void swap(int[] vs, int a, int b) {
		if (a != b) {
			vs[a] ^= vs[b];
			vs[b] ^= vs[a];
			vs[a] ^= vs[b];
		}
	}

	// QuickSortan array in reverse order.
	private void quickSort(int[] vs, int left, int right) {
		if (left >= right) return;
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
			// find the elem > pivot
			while (vs[left] < pivot) {
				left++;
			}
			// find the elem < pivot
			while (vs[right] > pivot) {
				right--;
			}
			// swap two elems
			if (left <= right) {
				swap(vs, left++, right--);
			}
		}
		return new int[] { left, right };
	}

	public static void main(String[] args) {
		// int[] vs = { 6, 8, 7, 4, 3, 2 };
		int[] vs = { 2, 4, 6, 2, 3, 7, 7, 4 };
		NextPermutation o = new NextPermutation();
		o.nextPermutation(vs);
		for (int v : vs) {
			System.out.print(v + " ");
		}
	}
}
