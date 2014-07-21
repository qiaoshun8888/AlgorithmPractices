package crackingTheCodingInterview.chapter11;

public abstract class BaseSort {

	private final String alg_name;
	protected int [] vs;
	protected int called_times;
	
	public BaseSort(int [] vs, String alg_name) {
		this.vs = vs;
		called_times = 0;
		this.alg_name = alg_name;
	}
	
	protected abstract void sort();
	
	protected void print() {
		System.out.println("=== " + alg_name + " === size: " + vs.length + " called_times: " + called_times);
		for (int v : vs) {
			System.out.print(v + " ");
		}
		System.out.println();
	}
	
	protected void swap(int [] vs, int i, int j) {
		if (i == j)
			return;
		vs[i] ^= vs[j]; vs[j] ^= vs[i]; vs[i] ^= vs[j];
	}
}
