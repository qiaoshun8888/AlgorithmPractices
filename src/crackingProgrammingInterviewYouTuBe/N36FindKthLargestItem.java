package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

public class N36FindKthLargestItem {

	/**
	 * Find the Kth largest item from array
	 * 
	 * */
	 
	public static void find(int [] vs, int k) {
		mergeSort(vs, 0, vs.length - 1);
		
		for (int i = 0; i < vs.length; i++) {
			System.out.print(vs[i] + " ");
		}
		System.out.println();
		
		System.out.println("Kth largest item is: " + vs[vs.length - k]);
	}
	private static void mergeSort(int [] vs, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(vs, left, mid);
			mergeSort(vs, mid + 1, right);
			merge(vs, left, mid, right);
		}
	}
	private static void merge(int [] vs, int left, int mid, int right) {
		int [] aux = new int [vs.length];
		for (int i = 0; i < vs.length; i++) {
			aux[i] = vs[i];
		}
		
		int l_aux = left, r_aux = mid + 1;
		while (l_aux <= mid && r_aux <= right) {
			vs[left++] = aux[l_aux] < aux[r_aux] ? aux[l_aux++] : aux[r_aux++]; 
		}
		
		while (l_aux <= mid) {
			vs[left++] = aux[l_aux++];
		}
	}
	
	public static void main(String [] args) {
		int [] vs = {7, 2, 3, 9, 8, 5, 0, 1, 6};
		find(vs, 2);
	}
}
