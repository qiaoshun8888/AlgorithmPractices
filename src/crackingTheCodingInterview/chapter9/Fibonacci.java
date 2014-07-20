package crackingTheCodingInterview.chapter9;

public class Fibonacci {
	
	private static long calledTimes = 0;

	public static int getKthFibonacciNumber(int k) {
		int result = 0;
		int n1 = 0, n2 = 0;
		for (int i = 0; i <= k; i++) {
			calledTimes++;
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
	
	public static int getKthFibonacciNumber2(int k) {
        if (k == 0) return 0;
		int[] vs = { 1, 2 };
		if (k < 3)
			return vs[(k - 1) % 2];
        int cur = 2;
		while (cur < k) {
            vs[cur%2] = vs[0] + vs[1];
			cur++;
        }
        return vs[cur%2];
    }

	// Time: O(2^n)  Space: O(n)
	public static int getKthFibonacciNumberRecursively(int k) {
		calledTimes++;
		if (k == 0) return 0;
		else if (k == 1) return 1;
		return getKthFibonacciNumberRecursively(k - 1) + getKthFibonacciNumberRecursively(k - 2);
	}
	
	// Time: O(n)  Space: O(n)
	private static int [] vs = new int [100]; 
	public static int getKthFibonacciNumberRecursivelyImprove(int k) {
		calledTimes++;
		if (k == 0) return 0;
		else if (k == 1) return 1;
		if (vs[k] == 0) vs[k] = getKthFibonacciNumberRecursivelyImprove(k - 1) + getKthFibonacciNumberRecursivelyImprove(k - 2);
		return vs[k];
	}
	
	public static void main(String [] args) {
		System.out.println(Fibonacci.getKthFibonacciNumber(40) + " calledTimes: " + calledTimes);
		calledTimes = 0;
		
		System.out.println(Fibonacci.getKthFibonacciNumberRecursively(40) + " calledTimes: " + calledTimes);
		calledTimes = 0;
		
		System.out.println(Fibonacci.getKthFibonacciNumberRecursivelyImprove(40) + " calledTimes: " + calledTimes);

		System.out.println(Fibonacci.getKthFibonacciNumber2(40));
	}
}
