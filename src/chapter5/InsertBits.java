package chapter5;

public class InsertBits {

	public static int insert(int n, int m, int i, int j) {
		int right_bits = n & ~(1 << i);
		int left_bits = n & ((1 << (j + 1)) - 1); // ~0 << (j+1)
		int mask = right_bits | left_bits;
		int m_bits = m << i;
		return mask | m_bits;
	}
	
	public static void main(String [] args) {
		// N = 34 	- 10 0010
		// M = 3	-    11
		// i = 2, j = 4
		// Result: 46	- 10 1110
		int n = 34, m = 3, i = 2, j = 4;
		System.out.println(InsertBits.insert(n, m, i, j));
		System.out.println(1 << 0);
	}
}
