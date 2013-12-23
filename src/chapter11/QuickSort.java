package chapter11;

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
		if (left >= right - 1) return; // #1 end with left == right - 1, #2 end with left == right 
		int mid = partition(vs, left, right); 
		sort(vs, left, mid); // #1
		sort(vs, mid + 1, right); // #2
	}

	private int partition(int [] vs, int left, int right) {
		int pivot = vs[(left + right) / 2];
		while (left < right) {
			while(vs[left] < pivot) {called_times++; left++;} // find the number larger than pivot. vs[left] >= pivot
			while(vs[right] > pivot) {called_times++; right--;} // find the number smaller than pivot. vs[right] <= pivot
			if (vs[left] > vs[right]) {
				swap(vs, left, right);
			}
		}
		return left;
	}
	
	public static void main(String [] args) {
		int [] vs = {71, 2, 15, 4, 6, 19, 8, 1, 25, 3, 9, 5, 10, 44, 7, 0};
		QuickSort ms = new QuickSort(vs);
		ms.sort();
		ms.print();
	}
}
