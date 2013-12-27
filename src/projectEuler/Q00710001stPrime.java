package projectEuler;

public class Q00710001stPrime {

	/**
	 * The sum of the squares of the first ten natural numbers is,
	 * 
	 * 12 + 22 + ... + 102 = 385 The square of the sum of the first ten natural
	 * numbers is,
	 * 
	 * (1 + 2 + ... + 10)2 = 552 = 3025 Hence the difference between the sum of
	 * the squares of the first ten natural numbers and the square of the sum is
	 * 3025 - 385 = 2640.
	 * 
	 * Find the difference between the sum of the squares of the first one
	 * hundred natural numbers and the square of the sum.
	 * 
	 * */
	
	private static int calledTimes = 0;
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			calledTimes++;
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		int count = 1, N = 10001;
		for (int i = 3; i < N * N; i++) {
			if (isPrime(i)) {
				count++;
				if (count == N) {
					System.out.println(i);
					break;
				}
			}
		}
		System.out.println("calledTimes: " + calledTimes);
	}
}
