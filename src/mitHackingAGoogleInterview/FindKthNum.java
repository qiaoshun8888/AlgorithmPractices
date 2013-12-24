package mitHackingAGoogleInterview;

import java.util.Random;

public class FindKthNum {

	/**
	 * Find the Kth smallest element in an array of n elements.
	 * 
	 * */
	
	public static int findKthSmallest(int [] vs, int k) {
		return quickSort(vs, 0, vs.length - 1, k - 1);
	}
	
	private static int quickSort(int [] vs, int low, int high, int k) {
//		System.out.println("low: " + low + "  high: " + high + " k: " + k);
		if (low < high) {
			int pivotIndex = partition(vs, low, high, k);
//			System.out.print(pivotIndex + "  -  "); for (int i = 0; i < vs.length; i++) {System.out.print(vs[i] + " ");} System.out.println();
			if (k == pivotIndex) return vs[pivotIndex];
			if (k < pivotIndex) return quickSort(vs, low, pivotIndex - 1, k);
			else return quickSort(vs, pivotIndex + 1, high, k); // 0 1 2 3 4 5
		}
		return vs[low];
	}
	private static int partition(int [] vs, int low, int high, int k) {
		int pivotValue = vs[new Random().nextInt(high - low + 1) + low];
		while (low < high) {
			while (vs[low] < pivotValue) {
				low++;
			}
			while (vs[high] > pivotValue) {
				high--;
			}
			if (vs[low] > vs[high]) {
				swap(vs, low, high);
			}
		}
		return low;
	}
	private static void swap(int [] vs, int a, int b) {
		vs[a] ^= vs[b];
		vs[b] ^= vs[a];
		vs[a] ^= vs[b];
	}
	
	
	public static void main(String [] args) {
		int [] vs = {-2, 7, 1, 8, 9, 11, 17, 3, 0};
		int k = 5;
		System.out.println(findKthSmallest(vs, k));			
	}
}
