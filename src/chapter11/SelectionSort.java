package chapter11;

public class SelectionSort extends BaseSort {

	public SelectionSort(int [] vs) {
		super(vs, "SelectionSort");
	}
	
	// Time: O(N^2)    Space: O(1)
	public void sort() {
		int si = -1; // smallest_index
		for (int i = 0; i < vs.length; i++) {
			si = i;
			for (int j = i; j < vs.length; j++) {
				called_times++;
				if (vs[si] > vs[j]) {
					si = j;
				}
			}
			if (i != si) {
				vs[i] = vs[si] + vs[i];
				vs[si] = vs[i] - vs[si];
				vs[i] = vs[i] - vs[si];
			}
		}
	}
	
	public static void main(String [] args) {
		int [] vs = {2, 4, 6, 8, 1, 3, 5, 7, 0};
		SelectionSort ss = new SelectionSort(vs);
		ss.sort();
		ss.print();
	}
}
