package chapter11;

public class MergeTwoSortedArray {

	public static void merge(int[] a, int[] b, int last_a) {
		int end_index = last_a + b.length, last_b = b.length - 1;
		// If length of a is larger than b's, while will end with last_b >= 0,
		// because b is run out of elements, and we don't need to copy the rest
		// of elements in a since they are already in the right place.
		// If length of b is larger than a's, while will end with end_index >=
		// 0, because we insert all the elements in b into a.
		while (end_index >= 0 && last_b >= 0) {
			// If a[last_a] > b[last_b], we put the larger value, a[last_a], at
			// end_index. Then we decrease end_index by 1.
			// In the situation that b's elements is more than a's, the value of
			// last_a might become smaller than 0 (because we keep decreasing it
			// after we put an element of a at end_index), that means we run out
			// of a's elements and we only need to put b's elements in the front
			// of a by decreasing last_b.
			if (last_a >= 0 && a[last_a] > b[last_b]) {
				a[end_index--] = a[last_a--];
			} else {
				a[end_index--] = b[last_b--];
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[50];
		int[] b = new int[10];
		int a_elements = 15;
		for (int i = 0; i < a_elements; i++) {
			a[i] = i * 2 + 1; // 1 3 5 7 9
		}
		for (int i = 0; i < 10; i++) {
			b[i] = (i + 1) * 2; // 2 4 6 8 10 ...
		}
		merge(a, b, a_elements - 1);

		for (int i : a) {
			if (i == 0)
				break;
			System.out.print(i + " ");
		}
	}
}
