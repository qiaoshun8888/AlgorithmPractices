package crackingTheCodingInterview.chapter11;

public class BubbleSort extends BaseSort {

	public BubbleSort(int[] vs) {
		super(vs, "BubbleSort");
	}

	// Time: O(N^2)    Space: O(1)
	public void sort() {
		for (int i = 0; i < vs.length - 1; i++) {
			for (int j = 1; j < vs.length; j++) {
				called_times++;
				if (vs[j - 1] > vs[j]) {
					vs[j - 1] += vs[j];
					vs[j] = vs[j - 1] - vs[j];
					vs[j - 1] = vs[j - 1] - vs[j];
				}
			}
		}
	}
	
	public static void main(String [] args) {
		int a = 3, b = 5;
		 a += b; b = a - b; a = a - b;
		 a ^= b; b ^= a; a ^= b;
		System.out.println("a: " + a + "  b: " + b);
		
		int [] vs = {2, 4, 6, 8, 1, 3, 5, 7, 0};
		BubbleSort bs = new BubbleSort(vs);
		bs.sort();
		bs.print();
	}
}
