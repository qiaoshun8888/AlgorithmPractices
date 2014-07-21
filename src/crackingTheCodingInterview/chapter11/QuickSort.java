package crackingTheCodingInterview.chapter11;

public class QuickSort extends BaseSort{

	public QuickSort(int[] vs) {
		super(vs, "QuickSort");
	}

	@Override
	protected void sort() {
		sort(vs, 0, vs.length - 1);
	}
	
	// Time: O(N log(N)) average-case     O(N^2) worst-case    Space: O(log(N))
	private void sort(int [] vs, int left, int right) {
		if (left >= right)
			return; // #1 end with left == right - 1, #2 end with left == right
		int[] indexes = partition(vs, left, right);
		if (left < indexes[1]) {
			sort(vs, left, indexes[1]); // #1
		}
		if (right > indexes[0])
			sort(vs, indexes[0], right); // #2
	}

	private int[] partition(int[] vs, int left, int right) {
		// pick the pivot
		int mid = left + (right - left) / 2;
		int pivot = vs[mid];
		// make left < pivot and right > pivot
		while (left <= right) {
			while (vs[left] < pivot) {
				called_times++;
				left++;
			}
			while (vs[right] > pivot) {
				called_times++;
				right--;
			}
			if (left <= right) {
				swap(vs, left++, right--);
			}
		}
		return new int[] { left, right };
	}
	
	public static void main(String [] args) {
		// int[] vs = { 71, 2, 15, 4, 6, 19, 8, 1, 25, 3, 9, 5, 10, 44, 44, 44,
		// 44, 7, 0 };
		int[] vs = { 9, 5, 10, 44, 7, 10, 44 };
		QuickSort ms = new QuickSort(vs);
		ms.sort();
		ms.print();
	}
}
