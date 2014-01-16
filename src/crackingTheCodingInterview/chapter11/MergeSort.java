package crackingTheCodingInterview.chapter11;

public class MergeSort extends BaseSort {

	private int [] aux;
	
	public MergeSort(int[] vs) {
		super(vs, "MergeSort");
		aux = new int[vs.length];
	}

	@Override
	protected void sort(){
		sort(0, vs.length - 1);
	}
	
	// Time: O(N log(N))
	public void sort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			sort(low, middle);
			sort(middle + 1, high);
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		// copy both halves into aux array
		for (int i = low; i <= high; i++) {
			aux[i] = vs[i];
		}
		//  1  4  5  #  2  8  9
		//  ^        #  ^
		//  |        #  |
		//  aux_left #  aux_right
		//  part 1   #  part 2
		int index = low, aux_left = low, aux_right = middle + 1;
		while (aux_left <= middle && aux_right <= high) {
			called_times++;
			vs[index++] = aux[aux_left] < aux[aux_right] ? aux[aux_left++] : aux[aux_right++]; 
		}
		
		while (aux_left <= middle) {
			called_times++;
			vs[index++] = aux[aux_left++];
		}
	}

	public static void main(String [] args) {
		int [] vs = {71, 2, 15, 4, 6, 19, 8, 1, 25, 3, 9, 5, 10, 44, 7, 0};
		MergeSort ms = new MergeSort(vs);
		ms.sort();
		ms.print();
	}
}
