package projectEuler;

public class Q009SpecialPythagoreanTriplet {

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
	 * which,
	 * 
	 * a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 * 
	 * */
	
	public static boolean verify(int a, int b, int c) {
		return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
	}
	
	public static void main(String [] args) {
		int N = 1000, calledTimes = 0;
		for (int c = 997; c > 0; c--) {
			int v = N - c;
			for (int b = v - 1, a = 1; b > a; b--, a++) {
				calledTimes++;
				if (verify(a, b, c)) {
					System.out.printf("%d * %d * %d = %d\n", a, b, c, a * b * c);
					System.out.println("calledTimes: " + calledTimes);
					return;
				}
			}
		}
	}
}
