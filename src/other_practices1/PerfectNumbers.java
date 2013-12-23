package other_practices1;

public class PerfectNumbers {

	/**
	 * 
	 * In number theory, a perfect number is a positive integer that is equal to
	 * the sum of its proper positive divisors, that is, the sum of its positive
	 * divisors excluding the number itself (also known as its aliquot sum).
	 * Equivalently, a perfect number is a number that is half the sum of all of
	 * its positive divisors (including itself)
	 * 
	 * */
	public static void printPerfectNumbers(int n) {
		for (int i = 2; i <= n; i++) {
			int sum = 1;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					sum += j;
			}
			if (sum == i)
				System.out.println(i);
		}
	}

	public static void main(String[] args) {
		printPerfectNumbers(10000);
	}
}
