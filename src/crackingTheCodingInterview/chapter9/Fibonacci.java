package crackingTheCodingInterview.chapter9;

public class Fibonacci {

	public static int getKthFibonacciNumber(int k) {
		int result = 0;
		int n1 = 0, n2 = 0;
		for (int i = 0; i <= k; i++) {
			if (i == 0) { 
				n1 = 0;
				result = 0;
			}
			else if (i == 1) {
				n2 = 1;
				result = 1;
			}
			else {
				// 0 1 1 2 3 5 8 13 21 34
				result = n1 + n2;
				n1 = n2;
				n2 = result;
			}
		}
		return result;
	}
	
	// Time: O(2^n)  Space: O(n)
	public static int getKthFibonacciNumberRecursively(int k) {
		if (k == 0) return 0;
		else if (k == 1) return 1;
		return getKthFibonacciNumberRecursively(k - 1) + getKthFibonacciNumberRecursively(k - 2);
	}
	
	// Time: O(n)  Space: O(n)
	private static int [] vs = new int [100]; 
	public static int getKthFibonacciNumberRecursivelyImprove(int k) {
		if (k == 0) return 0;
		else if (k == 1) return 1;
		if (vs[k] == 0) vs[k] = getKthFibonacciNumberRecursivelyImprove(k - 1) + getKthFibonacciNumberRecursivelyImprove(k - 2);
		return vs[k];
	}
	
	
	public static void main(String [] args) {
		System.out.println(Fibonacci.getKthFibonacciNumber(40));
		System.out.println(Fibonacci.getKthFibonacciNumberRecursively(40));
		System.out.println(Fibonacci.getKthFibonacciNumberRecursivelyImprove(40));
	}
}
