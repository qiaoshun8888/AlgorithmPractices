package crackingTheCodingInterview.chapter7;

public class CheckPrime {

	
	public static boolean isPrimeNaive(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static boolean isPrimeImprove(int n) {
		int j = (int) Math.sqrt(n);
		for (int i = 2; i <= j; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static boolean [] sieveOfEratosthenes(int max) {
		boolean [] flags = new boolean[max + 1]; // plus 1 to count the last element
		for (int i = 0; i < max + 1; i++) {
			flags[i] = true;
		}
		
		int prime = 2;
		
		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			
			prime = getNextPrime(flags, prime);
			if (prime == -1) break;
		}
		return flags;
	}
	
	private static void crossOff(boolean [] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i+= prime) {
			flags[i] = false;
		}
	}
	
	private static int getNextPrime(boolean [] flags, int prime) {
		for (int i = prime + 1; i < flags.length; i++) {
			if (flags[i]) return i;
		}
		return -1;
	}
	
	public static void main(String [] args) {
		int n = 1275121;
		System.out.printf("is %d is prime (Naive) ? %s\n", n, CheckPrime.isPrimeNaive(n));
		System.out.printf("is %d is prime (Improve) ? %s\n", n, CheckPrime.isPrimeImprove(n));
		
		System.out.println();
		boolean [] flags = CheckPrime.sieveOfEratosthenes(97);
		for (int i = 1; i < flags.length; i++) {
			if (flags[i]) System.out.print(i + " ");
		}
		System.out.println();
	}
}
