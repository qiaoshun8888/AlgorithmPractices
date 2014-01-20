package amazon;

public class DivideTwoNumbers {

	/**
	 * divide two numbers without "/"
	 * 
	 * */

	public static int divide(int a, int b) {
		if (b == 0)
			return Integer.MAX_VALUE;
		while (a > b) {
			a -= b;
		}
		return a;
	}

	// 5 101
	// 9 1001
	public static int divideByThree(int num) {
		int sum = 0;
		while (sum > 3) {
			sum += num >> 2;
			num = (num >> 2) + (num & 3); // (101 >> 2) + (101 & 11) = 1 + 1 =
											// 10 = 2
											// (1001 >> 2) + (1001 & 11) = 10 +
											// 1 = 11 = 3
		}
		if (num == 3)
			sum++;
		return sum;
	}

	// If we cannot use '+', then
	private static int add(int a, int b) {
		int x, y;
		// 3 + 5 = 011 + 101
		do {
			x = a & b; // x = 011 & 101 = 001
						// === Find two 1s ===
						// if two digits at the same
						// position are 1s, then after ADD this position should
						// be 0. And the next higher significant digit should
						// add 1.
			
			y = a ^ b; // y = 011 ^ 101 = 110
						// === Add a and b, and clear two 1s (not calculated carries) ===
						// if two digits at the same position are 1s, then after
						// ADD this position should be 0.
			
			a = x << 1; // a = 001 << 1 = 010
						// === Calculate carry ===
			
			b = y; // b = 110
		} while (x != 0);
		return b;
	}

	public static void main(String[] args) {
		int a = 22, b = 7;
		System.out.println(divide(a, b));

		System.out.println(add(3, 5));
	}
}
