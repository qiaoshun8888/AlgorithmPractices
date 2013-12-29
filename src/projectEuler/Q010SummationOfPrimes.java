package projectEuler;

public class Q010SummationOfPrimes {

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * 
	 * Find the sum of all the primes below two million.
	 * 
	 * */
	private static long calledTimes = 0;
	
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			calledTimes++;
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		long startTime = System.currentTimeMillis();
		
		long sum = 2;
		int max = 2000000;
		for (int i = 3; i < max; i++) {
			if (isPrime(i)) {
				// System.out.print(i + " ");
				sum += i;
			}
		}
		
		System.out.println();
		System.out.println("Summation of all the primes below " + max + " is: " + sum);
		System.out.println("calledTimes: " + calledTimes);
		System.out.println("runningTime: " + (System.currentTimeMillis() - startTime) + "ms");
		
		sum = 0;
		calledTimes = 0;
		startTime = System.currentTimeMillis();
		
		// Improved Method
		boolean [] sieveSet = new boolean[max + 1];
		for (int i = 2; i <= Math.sqrt(max); i++) {
			for (int j = i * i; j < max; j += i) {
				calledTimes++;
				if (j % i == 0) sieveSet[j] = true;
			}
		}
		
		for (int i = 2; i < max; i++) {
			if (!sieveSet[i]) {
				sum+=i;
			}
		}
		
		System.out.println();
		System.out.println("(Improved) Summation of all the primes below " + max + " is: " + sum);
		System.out.println("calledTimes: " + calledTimes);
		System.out.println("runningTime: " + (System.currentTimeMillis() - startTime) + "ms");
	}
}
