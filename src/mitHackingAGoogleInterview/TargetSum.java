package mitHackingAGoogleInterview;

import java.util.Random;

public class TargetSum {

	/**
	 * Given an integer x and an unsorted array of integers, describe an
	 * algorithm to determine whether two of the numbers add up to x. (do not
	 * use hash tables)
	 * 
	 * */

	Random rand = new Random();
	
	static class TwoNums {
		int m, n;

		public TwoNums() {
			this.m = -1;
			this.n = -1;
		}

		public TwoNums(int m, int n) {
			this.m = m;
			this.n = n;
		}

		@Override
		public String toString() {
			return m + " + " + n + " = " + (m + n);
		}
	}

	public TwoNums find(int[] vs, int x) {
		quickSort(vs);
		int head = 0, tail = vs.length - 1;
		boolean found = false;
		while (head < tail) {
			if (vs[head] + vs[tail] > x) {
				tail--;
			} else if (vs[head] + vs[tail] < x) {
				head++;
			} else {
				found = true;
				break;
			}
		}
		
		if (found) {
			return new TwoNums(vs[head], vs[tail]);
		}
		return new TwoNums();
	}

	private void quickSort(int[] vs) {
		quickSort(vs, 0, vs.length - 1);
	}

	private void quickSort(int[] vs, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(vs, low, high);
			quickSort(vs, low, pivotIndex - 1);
			quickSort(vs, pivotIndex, high);
		}
	}

	private int partition(int[] vs, int low, int high) {
		int pIndex = rand.nextInt(high - low + 1) + low;
		int pValue = vs[pIndex];
		while (low < high) {
			while (vs[low] < pValue) {
				low++;
			}
			while (vs[high] > pValue) {
				high--;
			}
			if (vs[low] > vs[high]) {
				swap(vs, low, high);
			}
		}
		return low;
	}

	private void swap(int[] vs, int a, int b) {
		vs[a] ^= vs[b];
		vs[b] ^= vs[a];
		vs[a] ^= vs[b];
	}

	public static void main(String[] args) {
		int[] vs = { 2, -5, 7, 9, 1, 4, 6, 11 };
		TargetSum ts = new TargetSum();
		
		// test quick sort
		/*
		ts.quickSort(vs);
		for (int i : vs) {
			System.out.printf(" %d ", i);
		}
		System.out.println();
		*/
		
		// find
		System.out.println(ts.find(vs, 6));
	}
}
