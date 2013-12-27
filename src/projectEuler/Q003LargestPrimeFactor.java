package projectEuler;

public class Q003LargestPrimeFactor {

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 * 
	 * */
	public static boolean isPrime(long l) {
		for (long i = 2; i < Math.sqrt(l); i++) {
			if (l % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		long n = 600851475143L;
		int calledTimes = 0;
		for (long i = 2; i < Math.sqrt(n); i++) {
			calledTimes++;
			if (isPrime(i) && n % i == 0) {
				n /= i;
			}
		}
		System.out.println(n + "\tcalledTimes: " + calledTimes);
	}
}
